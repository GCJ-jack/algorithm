package com.itheima.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ReceiveFileDemo {

    public static void main(String[] args) throws IOException {

        int port = 10086;

        ServerSocket serverSocket = new ServerSocket(port);

        Socket socket = serverSocket.accept();


        UUID uuid = UUID.randomUUID();

        String id = uuid.toString().replaceAll("-","");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(id +".png"));


        byte[] bytes = new byte[1024];

        int len;

        while ((len=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,len);
        }

        socket.shutdownInput();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        bufferedWriter.write("上传完成！");
        bufferedWriter.flush();
        bufferedWriter.close();

        serverSocket.close();
    }
}
