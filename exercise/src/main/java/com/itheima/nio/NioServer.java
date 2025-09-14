package com.itheima.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import static java.nio.channels.SelectionKey.OP_ACCEPT;

public class NioServer {

    public static void main(String[] args) throws IOException {

        //打开一个多路复用器
        Selector selector = Selector.open();
        //打开一个服务端通道 用于监听客户端连接
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //绑定端口为 8082 等待客户端链接
        serverSocketChannel.bind(new InetSocketAddress(8082));
        // 将 serverchannel 注册到 selector 上 关注 "OP_ACCEPT" 事件（新的客户端连接）
        serverSocketChannel.register(selector,OP_ACCEPT);
        // 主循环 不停的等待 处理事件
        while (true){
            //阻塞 知道至少有一个通道就绪
            selector.select();
            // 拿到所有就绪的事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            // 遍历处理所有的就绪事件
            while (iterator.hasNext()){
                // 取出一个事件
                SelectionKey key = iterator.next();
                //处理完后必须移除 避免下次重复处理
                iterator.remove();

                // 如果是一个新的连接到来（OP_ACCEPT）
                if(key.isAcceptable()){
                    // 拿到触发时间的通道（就是 ServerSocketChannel）
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    // 打印确认是不是我们注册的 serverChannel
                    System.out.println(ssc == serverSocketChannel);
                    // 接受客户端连接，得到一个 SocketChannel（客户端通道）
                    SocketChannel client = ssc.accept();
                    // 也必须设置为非阻塞
                    client.configureBlocking(false);
                    // 把客户端通道也注册到 selector 上，这次关注 "OP_READ" 事件（客户端发数据）
                    client.register(selector, SelectionKey.OP_READ);
                }


                if(key.isReadable()){

                    SocketChannel socketChannel = (SocketChannel) key.channel();

                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    if(socketChannel.read(byteBuffer)== -1){
                        System.out.println(socketChannel.getRemoteAddress() + " 断开连接了");
                        socketChannel.close();
                    }else {
                        byteBuffer.flip();
                        byte[] bytes = new byte[1024];
                        byteBuffer.get(bytes);
                        // 打印客户端发来的字符串
                        System.out.println(new String(bytes));
                    }

                    byteBuffer.clear();
                }
            }
        }
    }
}
