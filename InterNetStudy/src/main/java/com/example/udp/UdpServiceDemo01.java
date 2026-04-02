package com.example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class UdpServiceDemo01 {
    public static void main(String[] args) throws Exception {
        // 开放端口
        DatagramSocket datagramSocket = new DatagramSocket(9090);
        // 接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        datagramSocket.receive(datagramPacket);// 阻塞接收
        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength(), StandardCharsets.UTF_8));

        // 关闭连接
        datagramSocket.close();
    }
}
