package com.chaojun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class NioClient {

    public static void runClient(int id){
        try(Socket socket = new Socket("localhost",8083);
        ){
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            out.write("I LOVE U");
            out.newLine();
            out.flush();

            System.out.println("client-" + id + " sent");

        } catch (Exception e) {
            System.err.println("client-" + id + " error: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 1000; i++) {

            int id = i;
            new Thread(()->{
                runClient(id);
            }).start();
        }
    }
}

