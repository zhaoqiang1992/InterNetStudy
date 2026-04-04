package com.example.udp.talk;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class TalkReceiver implements Runnable {
    private DatagramSocket datagramSocket = null;
    private int port;
    private String msgFrom;

    public TalkReceiver(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            datagramSocket = datagramSocket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            // 准备接收数据包
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
            try {
                datagramSocket.receive(datagramPacket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // 断开连接
            byte[] data = datagramPacket.getData();
            //String s = new String(data,0,data.length, StandardCharsets.UTF_8);
            String s =  new String(datagramPacket.getData(), 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println(msgFrom + " : " +s);
            if (s.equals("bye")) {
                break;
            }
        }

        datagramSocket.close();
    }
}
