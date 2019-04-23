package com.example.socketsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MoodActivity extends AppCompatActivity {

    Button happyBtn,sadBtn,fearBtn,angryBtn;
    TextView moodText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.moods);

        happyBtn = (Button)findViewById(R.id.happyBtn);
        sadBtn = (Button)findViewById(R.id.sadBtn);
        fearBtn = (Button)findViewById(R.id.fearBtn);
        angryBtn = (Button)findViewById(R.id.angerBtn);

        moodText = (TextView) findViewById(R.id.moodtxt);
        happyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodText.setText("Happy");
            }
        });

        sadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodText.setText("Sad");
            }
        });

        fearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodText.setText("Fear");
            }
        });

        angryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodText.setText("Angry");
            }
        });

    }
}
