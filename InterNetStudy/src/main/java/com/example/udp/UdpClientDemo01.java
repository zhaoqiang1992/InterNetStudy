package com.example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1) 建立一个socket
        DatagramSocket socket = new DatagramSocket();

        //2) 建个包
        String msg = "你好！！！";
        // 发送给谁
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 9090;
        // 数据，数据的长度起始，要发送给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(StandardCharsets.UTF_8), 0, msg.getBytes("UTF-8").length, address, port);

        //3) 发送包
        socket.send(packet);

        // 关闭资源
        socket.close();
    }
}
