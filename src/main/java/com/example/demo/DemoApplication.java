package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class DemoApplication implements Runnable {
    public String inputData;

  /*  public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    } */

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        SpringApplication.run(DemoApplication.class, args);

        Thread desktopServerThread = new Thread(new DemoApplication());
        desktopServerThread.start();
    }

    public static final int ServerPort = 9900;

    public static final String ServerIP = "192.168.10.109";

    @Override

    public void run() {
        // TODO Auto-generated method stub

        try {
            System.out.println("S: Connecting...");
            ServerSocket serverSocket = new ServerSocket(ServerPort);

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("S: Receiving...");

                try {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(client.getInputStream()));

                    String inputData = in.readLine();
                    System.out.println("S: Received: '" + inputData + "'");
                    PrintWriter out = new PrintWriter(new BufferedWriter(
                            new OutputStreamWriter(client.getOutputStream())),true);
                    out.println("Server Received " + inputData);

                } catch (Exception e) {
                    System.out.println("S: Error");
                    e.printStackTrace();

                } finally {
                    client.close();
                    System.out.println("S: Done.");
                }
            }

        } catch (Exception e) {
            System.out.println("S: Error");
            e.printStackTrace();
        }
    }

}
