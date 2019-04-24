package com.example.socketsapp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageReceivingThread implements Runnable {

    static String message;

    @Override
    public void run() {

        Socket socket = Client.socketIns;

        try {
            while (true) {
                Log.v("1","1");
                InputStream inputStream = socket.getInputStream();
                Log.v("1","1");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Log.v("1","1");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                Log.v("1","1");
                MessageReceivingThread.message = bufferedReader.readLine();
                System.out.println("Message is :: " + MessageReceivingThread.message);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
