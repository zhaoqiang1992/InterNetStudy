package com.example.udp.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UdpReceiverDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(6666);

        while (true) {
            // 准备接收数据包
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
            datagramSocket.receive(datagramPacket);

            // 断开连接
            byte[] data = datagramPacket.getData();
            //String s = new String(data,0,data.length, StandardCharsets.UTF_8);
            String s =  new String(datagramPacket.getData(), 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println(s);
            if (s.equals("bye")) {
                break;
            }
        }

        datagramSocket.close();
    }
}
