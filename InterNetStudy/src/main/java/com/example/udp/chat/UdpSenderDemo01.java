package com.example.udp.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        // 准备数据， 控制台读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bufferedReader.readLine();
            byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 6666));

            socket.send(datagramPacket);
            if (s.equals("bye")) {
                break;
            }
        }

        socket.close();
    }
}
