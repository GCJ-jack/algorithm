package com.itheima.net;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ChatBot1 {

    public static void main(String[] args) throws IOException {


        DatagramSocket datagramSocket = new DatagramSocket();

        int port = 10086;

        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入你想要说的话: ");

            String line = scanner.nextLine();
            if (line.equals("886")){
                break;
            }

            byte[] bytes = line.getBytes();

            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,inetAddress,port);

            datagramSocket.send(datagramPacket);
        }

        datagramSocket.close();
    }
}
