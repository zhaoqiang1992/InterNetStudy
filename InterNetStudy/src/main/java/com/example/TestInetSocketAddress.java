package com.example;

import java.net.InetSocketAddress;

public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("127.0.0.1", 1234);
        System.out.println(inetSocketAddress1);

        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost", 1234);
        System.out.println(inetSocketAddress2);

        System.out.println(inetSocketAddress1.getAddress());
        System.out.println(inetSocketAddress1.getHostName());//地址
        System.out.println(inetSocketAddress1.getPort());// 端口

    }
}
