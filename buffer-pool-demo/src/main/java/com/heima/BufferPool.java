package com.heima;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BufferPool {

    private final int totalSize;

    private int free;

    private final int slotSize;

    private final Deque<Condition> waiter = new ArrayDeque<>();

    private final Deque<ByteBuffer> slotQueue = new ArrayDeque<>();

    ReentrantLock lock = new ReentrantLock();


    public BufferPool(int totalSize, int slotSize) {
        this.totalSize = totalSize;
        this.slotSize = slotSize;
        this.free = totalSize;
    }

//    功能：
//
//    用于申请一个指定大小的 ByteBuffer。
//
//    输入参数：
//
//    size：请求的内存大小。
//
//    timeout：等待内存分配的最大时间（毫秒）。
//
//    步骤：
//
//    首先检查 size 是否合理（大于零且不超过总容量）。
//
//    如果请求的 size 等于 slotSize 且槽队列（slotQueue）不为空，直接从槽队列中取一个缓冲区对象返回。
//
//    如果当前剩余内存足够分配 size，则尝试释放内存并分配一个新的 ByteBuffer。
//
//    如果内存不足，则当前线程被放入 waiters 队列，等待直到有足够内存，最多等待 timeout 时间。
//
//    如果在 timeout 时间内没有获得内存，抛出异常。
//
//    一旦内存满足条件，唤醒等待的线程，并返回一个 ByteBuffer。

    public ByteBuffer allocate(int size,long timeout) throws InterruptedException {

        if(size > totalSize || size < 0){
            throw new RuntimeException();
        }

        lock.lock();
        try {

            if(size == slotSize && !slotQueue.isEmpty()){
                return slotQueue.pollFirst();
            }

            if((free + slotQueue.size() * slotSize) >= size){
                freeUp(size);
                free -= size;
                return ByteBuffer.allocate(size);
            }

            Condition condition = lock.newCondition();
            waiter.addLast(condition);

            long remainTime = timeout;


            try {
                while (true){
                    long start = System.currentTimeMillis();

                    boolean wakeUp = condition.await(remainTime,TimeUnit.MILLISECONDS);

                    if(!wakeUp){
                        throw new RuntimeException("规定时间内不能申请需要的内存");
                    }

                    if(size == slotSize && !slotQueue.isEmpty()){
                        return slotQueue.pollFirst();
                    }

                    if((free + slotQueue.size() * slotSize) >= size){
                        freeUp(size);
                        free -= size;
                        return ByteBuffer.allocate(size);
                    }


                    remainTime -= System.currentTimeMillis() - start;
                }
            }finally {
                waiter.remove(condition);
            }

        }finally {
            lock.unlock();
        }
    }

    private void freeUp(int size){
        while (free < size && !slotQueue.isEmpty()){
            free += slotQueue.pollFirst().capacity();
        }
    }

    public void deallocate(ByteBuffer byteBuffer){
        lock.lock();

        try {
            if(byteBuffer.capacity() == slotSize){
                slotQueue.addLast(byteBuffer);
            }else{
                free += byteBuffer.capacity();
            }

            //如果有线程等待直接唤醒
            if(!waiter.isEmpty()){
                waiter.peekFirst().signal();
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

}
