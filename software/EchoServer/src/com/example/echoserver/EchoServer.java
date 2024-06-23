package com.example.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

// Write a program that simulates a server listening with TCP and sending with UDP

public class EchoServer {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Provide port number");

        int port = Integer.parseInt(args[0]);
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                System.out.println("Listening for clients to connect");
                new Connection(server.accept()).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Connection extends Thread {
        private static BufferedReader reader;
        private static DatagramSocket client;
        private static InputStreamReader stream;
        private static PrintWriter writer;
        private static Socket server;

        public Connection(Socket socket) {
            Connection.server = socket;
        }

        public static void setup() {
            try {
                writer = new PrintWriter(server.getOutputStream(),true);
                stream = new InputStreamReader(server.getInputStream());
                reader = new BufferedReader(stream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void close() {
            try {
                server.close();
                client.close();
                writer.close();
                stream.close();
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            try {
                Connection.setup();
                String readLine;
                while ((readLine = reader.readLine()) != null) {
                    if (readLine.equals("quit")) break;
                    System.out.println("Sending message back to client");
                    client = new DatagramSocket();
                    client.send(new DatagramPacket(
                            // The client becomes the server
                            readLine.getBytes(),
                            readLine.length(),
                            server.getInetAddress(),
                            server.getLocalPort()
                    ));
                }
                Connection.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
