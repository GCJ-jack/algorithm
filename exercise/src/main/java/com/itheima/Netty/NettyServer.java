package com.itheima.Netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer {

    public static void main(String[] args) {

        //创建一个hashmap 来存储数据

        //创建 bootstrap 组件
        ServerBootstrap serverBootstrap = new ServerBootstrap().group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception{
                        ch.pipeline().addLast(new LineBasedFrameDecoder(1024))
                                .addLast(new StringDecoder())
                                .addLast(new StringEncoder());
                        //加入相对应的回应处理器
                        //以及这个 db 处理器
                    }
                });

        ChannelFuture bindFuture = serverBootstrap.bind(8082);
        bindFuture.addListener(f ->{
            if(f.isSuccess()){
                System.out.println("服务器成功监听");
            }else{
                System.out.println("服务器监听失败");
            }
        });
    }
}
