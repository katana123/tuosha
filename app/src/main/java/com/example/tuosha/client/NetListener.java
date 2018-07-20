package com.example.tuosha.client;

import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Helen on 2014/10/24.
 */
public interface NetListener {
    public void channelActive(ChannelHandlerContext ctx) throws Exception;

    public void channelInactive(ChannelHandlerContext ctx) throws Exception;

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception;

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception;

    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception;
}
