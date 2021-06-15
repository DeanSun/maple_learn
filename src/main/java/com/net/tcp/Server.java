package com.net.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        InetSocketAddress addr = new InetSocketAddress(3001);
        serverSocket.bind(addr);
        List<Socket> list = new LinkedList<>();
        while (true){
            Socket socket = serverSocket.accept();
            list.add(socket);
            System.out.println(list.size());
        }
    }
}
