package com.itheima.Netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.concurrent.TimeUnit;

public class NettyClientInterruption {

    private static volatile boolean running = true;
    private static EventLoopGroup group;
    private static Channel channel;

    public static void startClient(String name) {
        group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new StringEncoder())
                                    .addLast(new StringDecoder())
                                    .addLast(new SimpleChannelInboundHandler<String>() {
                                        @Override
                                        protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                                            System.out.println("Received: " + msg);
                                        }

                                        @Override
                                        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                                            cause.printStackTrace();
                                            ctx.close();
                                        }
                                    });
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8082).sync();
            channel = channelFuture.channel();

            System.out.println("连接成功来自 " + name);

            // 定期发送消息
            channel.eventLoop().scheduleAtFixedRate(() -> {
                if (channel.isActive()) {
                    channel.writeAndFlush("hello from " + name + " " + System.currentTimeMillis() + "\n");
                }
            }, 0, 1, TimeUnit.SECONDS);

            // 等待通道关闭
            channel.closeFuture().sync();

        } catch (InterruptedException e) {
            System.out.println("客户端被中断: " + name);
            Thread.currentThread().interrupt();
        } finally {
            shutdown();
        }
    }

    public static void shutdown() {
        if (channel != null && channel.isActive()) {
            channel.close();
        }
        if (group != null) {
            group.shutdownGracefully();
        }
        running = false;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void main(String[] args) {



    }
}
