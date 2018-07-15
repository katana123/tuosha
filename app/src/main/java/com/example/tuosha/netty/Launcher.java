package com.example.tuosha.netty;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("启动客户端");
        final NettyClientBootstrap client = new NettyClientBootstrap();
        try {
            client.startNetty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
