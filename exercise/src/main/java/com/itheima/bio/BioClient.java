package com.itheima.bio;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class BioClient {

    public static void main(String[] args) {

        Thread thread1 = startClient("Jerry");
        Thread thread2 = startClient("Tom");

    }


    public static Thread startClient(String name){
        Thread thread = new Thread(() ->{
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("localhost",8082));
                OutputStream outputStream = socket.getOutputStream();

                for (int i = 0; i < 10; i++) {
                    String message = String.format("你好啊，我的名字是 %s %d",Thread.currentThread().getName(),i);
                    outputStream.write(message.getBytes());
                    outputStream.flush();
                    Thread.sleep(100);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        },name);

        thread.start();

        return thread;
    }
}
