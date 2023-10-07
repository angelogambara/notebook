package com.example.echoclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Scanner;

// Write a program that simulates a client connecting with TCP and receiving with UDP

public class EchoClient {
    private static BufferedReader reader;
    private static DatagramSocket server;
    private static InputStreamReader stream;
    private static PrintWriter writer;
    private static Socket client;

    public static void main(String[] args) {
        if (args.length != 2)
            throw new IllegalArgumentException("Provide host address and port number");

        Scanner scanner = new Scanner(System.in);

        establishConnection(args[0], Integer.parseInt(args[1]));
        while (true) {
            System.out.print("Awaiting input: ");
            String nextLine = scanner.nextLine();
            writer.println(nextLine);
            if (nextLine.equals("quit")) break;
            System.out.println("> " + getDatagram());
        }
        terminateConnection();
    }

    public static String getDatagram() {
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        try { server.receive(packet); } catch (IOException e) { throw new RuntimeException(e); }
        return new String(packet.getData(), 0, packet.getLength());
    }

    public static void establishConnection(String host, int port) {
        try {
            client = new Socket(host, port);
            server = new DatagramSocket(port);
            writer = new PrintWriter(client.getOutputStream(),true);
            stream = new InputStreamReader(client.getInputStream());
            reader = new BufferedReader(stream);
        } catch (IOException e) {
            System.err.println("Is the server listening for connections?");
            throw new RuntimeException(e);
        }
    }

    public static void terminateConnection() {
        try {
            client.close();
            server.close();
            writer.close();
            stream.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
