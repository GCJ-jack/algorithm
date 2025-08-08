package com.itheima.net;

import java.io.IOException;
import java.net.*;

public class SendMessageDemo {

    public static void main(String[] args) throws IOException {


        DatagramSocket ds = new DatagramSocket();

        String message = "hello world";

        byte[] bytes = message.getBytes();

        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");

        int port = 10086;

        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,inetAddress,port);

        ds.send(datagramPacket);

        ds.close();
    }
}
