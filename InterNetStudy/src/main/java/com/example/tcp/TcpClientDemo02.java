package com.example.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo02 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream out = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 1. 要知道服务器的地址和端口号
            InetAddress serviceIP = InetAddress.getByName("127.0.0.1");
            int port = 9000;
            // 2. 创建一个socket连接
            socket = new Socket(serviceIP, port);
            // 3. 创建一个输出流
            out = socket.getOutputStream();

            // 4. 读取文件
            fileInputStream = new FileInputStream(new File("src/cat.png"));
            // 5. 写入文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            // 通知服务器已经写入完毕
            socket.shutdownOutput();

            // 确保服务器接受完毕，才能断开连接
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];
            while ((len = inputStream.read(buffer2)) != -1) {
                byteArrayOutputStream.write(buffer2, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
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
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
