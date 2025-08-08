package com.itheima.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SendFileDemo {

    public static void main(String[] args) throws IOException {

        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");

        int port = 10086;

        Socket socket = new Socket(inetAddress,port);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("Danielle.jpg"));

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[1024];

        int a;

        while ((a=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,a);
        }

        socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String res = bufferedReader.readLine();

        System.out.println(res);

        socket.close();
    }
}
