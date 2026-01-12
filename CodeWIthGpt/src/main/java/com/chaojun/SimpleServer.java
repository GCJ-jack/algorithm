package com.chaojun;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class SimpleServer {

    private static void handle(ServerSocket serverSocket) throws IOException {
        Socket clientSocket = serverSocket.accept();


        try(            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));)
        {

            bufferedWriter.write("I LOVE YOU TOO");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String resp = bufferedReader.readLine();
            System.out.println("得到回复 " + resp);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(8083);
        System.out.println("服务端启动，监听 8083 端口...");


        try {
            while (true){
                handle(serverSocket);
            }
        }catch (Exception e){
            log.error("处理客户端失败", e);
        }


        serverSocket.close();
    }
}
