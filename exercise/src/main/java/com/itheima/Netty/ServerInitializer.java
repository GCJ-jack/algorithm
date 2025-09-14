package com.itheima.Netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();

        //添加字符串编码和解码器
        pipeline.addLast(new StringEncoder());
        pipeline.addLast(new StringDecoder());


        //添加自定义的业务处理器
        pipeline.addLast(new ServerHandler());
    }
}
