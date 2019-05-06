package com.example.socketsapp;

import android.content.Intent;
import android.os.Looper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MessageReceivingThread implements Runnable {

    static String message="";
    Handler handler;

    public void playAudio() {

        MoodActivity activity = new MoodActivity();
        if(message.equals("Happy")) {
            activity.stopMusic();
            activity.startHappyMusic();
        }
        else if(message.equals("Sad")) {
            activity.stopMusic();
            activity.startSadMusic();
        }
        else if(message.equals("Anger")) {
            activity.stopMusic();
            activity.startAngerMusic();
        }
        else if(message.equals("Fear")) {
            activity.stopMusic();
            activity.startFearMusic();
        }
    }

    @Override
    public void run() {

        Looper.prepare();

        handler = new Handler() {
            @Override
            public void publish(LogRecord record) {

            }

            @Override
            public void flush() {

            }

            @Override
            public void close() throws SecurityException {

            }
        };

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
                if(!MoodActivity.staticMood.getText().equals(message)) {
                    MoodActivity.staticMood.setText(message);
//                    playAudio();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
