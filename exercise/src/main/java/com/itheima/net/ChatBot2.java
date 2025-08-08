package com.itheima.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatBot2 {

    public static void main(String[] args) throws IOException {


        DatagramSocket datagramSocket = new DatagramSocket(10086);


        byte[] bytes = new byte[1024];


        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);

        while (true){
            datagramSocket.receive(datagramPacket);

            int len = datagramPacket.getLength();

            byte[] message = datagramPacket.getData();

            System.out.println("收到消息：" + new String(message,0,len));
        }
    }
}
