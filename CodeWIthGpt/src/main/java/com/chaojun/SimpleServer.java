package com.chaojun;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务端启动，监听 8080 端口...");

        Socket clientSocket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        bufferedWriter.write("I LOVE YOU");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        String resp = bufferedReader.readLine();
        System.out.println("得到回复 " + resp);

        serverSocket.close();
    }
}
