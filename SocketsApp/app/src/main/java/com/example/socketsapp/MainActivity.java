package com.example.socketsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1;

    Button sendButton;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.moods);
        e1 = (EditText)findViewById(R.id.ipAddress);
        sendButton = (Button)findViewById(R.id.sendBtn);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,MoodActivity.class));
            }
        });
    }

    public void send(View view) {
        MessageSender messageSender = new MessageSender();
        messageSender.execute(e1.getText().toString());
    }
}
