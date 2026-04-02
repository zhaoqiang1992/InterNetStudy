package com.example.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServiceDemo02 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        try {
            // 1. 得有一个地址
            serverSocket = new ServerSocket(9000);
            // 2. 等待客户端连接过来
            socket = serverSocket.accept(); // 阻塞式监听，会一直等待客户端连接
            // 3. 读取客户端的消息
            inputStream = socket.getInputStream();
            // 管道流
            fileOutputStream = new FileOutputStream(new File("receive.png"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }

            outputStream = socket.getOutputStream();
            outputStream.write("服务器已接收完毕".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
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

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
