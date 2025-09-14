package com.itheima.Netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        //处理接到的请求
        String request = (String) msg;

        System.out.println("Receive request: " +request);

        //发送请求
        String response = "Hello, client!";

        ctx.writeAndFlush(response);

        ctx.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
        //处理异常
        cause.printStackTrace();
        ctx.close();
    }
}
