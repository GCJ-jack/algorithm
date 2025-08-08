package com.itheima.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ReceiveFileDemo {

    public static void main(String[] args) throws IOException {

        int port = 10086;

        ServerSocket serverSocket = new ServerSocket(port);

        while (true){
            Socket socket = serverSocket.accept();

            MyRunnable myRunnable = new MyRunnable(socket);

            Thread thread = new Thread(myRunnable);

            thread.start();
        }
    }
}
