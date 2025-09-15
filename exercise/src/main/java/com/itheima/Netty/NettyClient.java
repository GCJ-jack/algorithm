package com.itheima.Netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NettyClient {

    public static boolean running = true;

    public static void startClient(String name){
        Bootstrap bootstrap = new Bootstrap().group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new StringEncoder())
                                .addLast(new StringDecoder())
                                .addLast(new SimpleChannelInboundHandler<String>() {
                                    @Override
                                    protected void channelRead0(ChannelHandlerContext ctx,String msg) throws Exception{
                                        System.out.println(msg);
                                    }
                                });
                    }
                });


        ChannelFuture channelFuture = bootstrap.connect("localhost", 8082);
        channelFuture.addListener(f->{
            if(f.isSuccess()){
                System.out.println("连接成功来自 " +  name);
                EventLoop eventLoop = channelFuture.channel().eventLoop();
                eventLoop.scheduleAtFixedRate(()->{
                    channelFuture.channel().writeAndFlush("hello from "+ name + System.currentTimeMillis() + "\n");
                },0,1, TimeUnit.SECONDS);
            }else{
                System.out.println("连接失败");
            }
        });

    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(()->{

            System.out.println("线程在运行...");
            startClient("thread1");


        });

        Thread thread2 = new Thread(()->{
            startClient("thread2");
        });

        thread1.start();
        Thread.sleep(3000);
        thread1.interrupt();

        thread2.start();


    }
}
