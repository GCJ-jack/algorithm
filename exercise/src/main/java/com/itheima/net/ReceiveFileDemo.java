package com.itheima.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveFileDemo {

    public static void main(String[] args) throws IOException {

        int port = 10086;

        ServerSocket serverSocket = new ServerSocket(port);

        Socket socket = serverSocket.accept();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("new_pic.png"));


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
