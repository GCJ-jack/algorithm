package com.itheima.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(10002);

        Socket socket = serverSocket.accept();

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());

        int b = 0;

        while ((b=inputStreamReader.read())!=-1){
            System.out.print((char) b);
        }

        String string = "认识你很高兴,我叫做郭超军";

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(string.getBytes());

        inputStreamReader.close();
        serverSocket.close();
    }
}
