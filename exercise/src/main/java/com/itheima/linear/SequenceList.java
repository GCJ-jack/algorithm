package com.itheima.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {

    //储存数据的数组
    private T[] eles;

    //记录当前顺序表中的元素个数
    private int size;

    //构造方法
    public SequenceList(int capacity) {
        eles = (T[])new Object[capacity];
        size=0;
    }

    //将一个线性表置为空表
    public void clear() {
        size = 0;
    }

    //判断当前的表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //获取线性表的长度
    public int length(){
        return size;
    }

    //获取指定的元素
    public T get(int i){
        if(i>=size||i<0){
            throw new RuntimeException("当前元素不存在！");
        }
        return eles[i];
    }

    //向数组中插入元素
    public void insert(T v){
        if(size==eles.length){
            resize(eles.length*2);
        }
        eles[size++]=v;
    }

    //向数组中添加元素
    public void insert(int i,T v){

        if(i==eles.length){
            resize(eles.length*2);
        }

        if(i>size||i<0){
            throw new RuntimeException("插入的位置不合理");
        }


        //把i的位置腾出来以方便新的元素的插入
        for(int j=size;j>i;j--){
            eles[j]=eles[j-1];
        }
        //在对应的位置插入想要的元素
        eles[i] = v;
        //元素的数量加1
        size++;
    }


    //删除指定位置的元素，并把后续的元素向前移动
    public T delete(int i){
        if(i>size-1||i<0){
            throw new RuntimeException("删除的位置不合理");
        }

        //记录对应位置的元素
        T number = eles[i];

        //指定位置之后的元素都向前移动一位
        for(int j=i;j<size-1;j++){
            eles[j]=eles[j+1];
        }

        //当前的元素减1
        size--;

        //如果当前现有的元素的数量已经不足容量的四分之一
        //进行缩容
        if(size > 0 &&size<eles.length/4){
            resize(eles.length/2);
        }

        return number;
    }

    //查找元素第一次出现的位置
    public int indexOf(T v){

        if(v==null){
            throw new RuntimeException("查找的元素不合理");
        }

        for(int i=0;i<size;i++){
            if(v.equals(eles[i])){
                return i;
            }
        }

        return -1;
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private int cur;
        public SIterator(){
            this.cur=0;
        }
        @Override
        public boolean hasNext() {
            return cur<size;
        }
        @Override
        public T next() {
            return eles[cur++];
        }
    }

    //改变容量
    private void resize(int newsize) {
        //创造临时数组来记录当前的元素
        T[] temp = eles;
        //扩容
        eles = (T[])new Object[newsize];

        for(int i=0;i<size;i++){
            eles[i]=temp[i];
        }
    }

    public int capacity(){
        return eles.length;
    }

    public static void main(String[] args) {
        //创建顺序表对象
        SequenceList<String> sequenceList = new SequenceList<>(4);

        sequenceList.insert("卡卡罗特");
        sequenceList.insert("贝吉塔");
        sequenceList.insert("弗利沙");
        sequenceList.insert(0,"克林");

        //获取第一个元素
        String s = sequenceList.get(0);

//        System.out.println(s);

        //遍历数组中的所有元素
        for(int i=0;i<sequenceList.length();i++){
            System.out.println(sequenceList.get(i));
        }

        //测试删除
        String removeResult = sequenceList.delete(0);
        System.out.println("删除的元素是："+removeResult);

        //测试清空
//        sequenceList.clear();
//
//        System.out.println("清空后的线性表中的元素个数为:"+sequenceList.length());


        for(String name:sequenceList){
            System.out.println(name);
        }

        sequenceList.insert("卡卡罗特");
        sequenceList.insert("贝吉塔");
        sequenceList.insert("弗利沙");
        sequenceList.insert("卡卡罗特");
        sequenceList.insert("贝吉塔");
        sequenceList.insert("弗利沙");
        sequenceList.insert("卡卡罗特");
        sequenceList.insert("贝吉塔");
        sequenceList.insert("弗利沙");

        System.out.println(sequenceList.capacity());

    }
}
