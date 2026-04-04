package com.example.udp.talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class TalkSend implements Runnable {
    private DatagramSocket socket = null;
    private BufferedReader bufferedReader = null;

    private int fromPort;
    private String toIp;
    private int toPort;

    public TalkSend(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket(this.fromPort);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                String s = bufferedReader.readLine();
                byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
                DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(this.toIp, this.toPort));

                socket.send(datagramPacket);
                if (s.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        socket.close();
    }
}
