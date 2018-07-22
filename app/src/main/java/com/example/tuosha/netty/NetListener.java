package com.example.tuosha.netty;

import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Helen on 2014/10/24.
 */
public interface NetListener {
    void channelActive(ChannelHandlerContext ctx) throws Exception;

    void channelInactive(ChannelHandlerContext ctx) throws Exception;

    void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception;

    void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception;

    void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception;
}
