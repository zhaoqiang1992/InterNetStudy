package com.example.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream out = null;
        try {
            // 1. 要知道服务期的地址和端口号
            InetAddress serviceIP = InetAddress.getByName("127.0.0.1");
            int port = 9000;
            // 2. 创建一个socket连接
            socket = new Socket(serviceIP, port);

            // 3. 发送消息 IO流
            out = socket.getOutputStream();
            out.write(("Hello World!").getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
