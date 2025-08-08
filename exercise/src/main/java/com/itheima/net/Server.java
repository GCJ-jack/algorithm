package com.itheima.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(10002);

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        int b = 0;

        while ((b=inputStream.read())!=-1){
            System.out.print((char) b);
        }

        inputStream.close();
        serverSocket.close();
    }
}
