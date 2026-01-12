package com.chaojun;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8080);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        out.write("I LOVE U");
        out.newLine();
        out.flush();

        String resp = in.readLine();
        System.out.println("收到回复 " + resp);

        socket.close();
    }
}
