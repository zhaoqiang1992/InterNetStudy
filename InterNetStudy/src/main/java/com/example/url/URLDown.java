package com.example.url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDown {
    public static void main(String[] args) throws IOException {
        // 1. 下载地址
        URL url = new URL("http://localhost/text.txt");

        // 2. 连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len); // 写出这个数据
        }

        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();
        urlConnection.disconnect();// 断开连接
    }
}
