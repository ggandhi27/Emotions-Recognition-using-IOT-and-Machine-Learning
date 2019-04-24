package com.example.socketsapp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    String ipAddress;
    int port;

    Client(String addr, int port) {
        this.ipAddress = addr;
        this.port = port;
    }


    public Socket connectServer() {

        Socket socket = null;
        try {
            InetAddress serverAddr = InetAddress.getByName(ipAddress);
            socket = new Socket(serverAddr, port);
            return socket;

        }
        catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return socket;
    }

}
