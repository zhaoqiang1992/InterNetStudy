package com.example.udp.talk;

public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(6666,"localhost", 9999)).start();
        new Thread(new TalkReceiver(8888,"老师")).start();
    }
}
