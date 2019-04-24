package com.example.socketsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MoodActivity extends AppCompatActivity {

    Button happyBtn,sadBtn,fearBtn,angryBtn;
    Socket socket;
    DataOutputStream dataOutputStream;
    TextView moodText;
    Button closeBtn;

    static TextView staticMood;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moods);

        happyBtn = (Button)findViewById(R.id.happyBtn);
        sadBtn = (Button)findViewById(R.id.sadBtn);
        fearBtn = (Button)findViewById(R.id.fearBtn);
        angryBtn = (Button)findViewById(R.id.angerBtn);
        moodText = (TextView) findViewById(R.id.moodtxt);
        closeBtn = (Button) findViewById(R.id.close);

        MoodActivity.staticMood = moodText;

        socket = Client.socketIns;
        Thread thread = new Thread(new MessageReceivingThread());
        thread.start();
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    socket.close();
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        happyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodText.setText("Happy");
                try {
                    dataOutputStream.writeUTF("Happy");
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        sadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodText.setText("Sad");
                try {
                    dataOutputStream.writeUTF("Sad");
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        fearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodText.setText("Fear");
                try {
                    dataOutputStream.writeUTF("Fear");
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        angryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodText.setText("Angry");
                try {
                    dataOutputStream.writeUTF("Angry");
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
