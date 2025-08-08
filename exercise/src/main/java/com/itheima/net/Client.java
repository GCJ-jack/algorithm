package com.itheima.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        String ip = "127.0.0.1";

        int port = 10002;

        Socket socket = new Socket(ip,port);

        String content = "from the client";

        byte[] intoBytes = content.getBytes();

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(intoBytes);

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        int b;

        while ((b=inputStreamReader.read())!=-1){
            System.out.print((char) b);
        }

        socket.close();
    }
}
