package com.itheima.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveMessageDemo {

    public static void main(String[] args) throws IOException {


        DatagramSocket datagramSocket = new DatagramSocket(10086);

        byte[] bytes = new byte[1024];

        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);

        System.out.println(11111);

        datagramSocket.receive(datagramPacket);

        byte[] message = datagramPacket.getData();

        int length = message.length;

        InetAddress inetAddress = datagramPacket.getAddress();

        int port = datagramPacket.getPort();

        System.out.println(new String(message,0,length));

        System.out.println(22222);
    }
}
