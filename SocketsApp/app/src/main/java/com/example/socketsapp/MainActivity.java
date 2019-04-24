package com.example.socketsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    EditText ipAddressTxt;
    EditText portTxt;
    Button sendButton;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);
//        setContentView(R.layout.moods);
        ipAddressTxt = (EditText) findViewById(R.id.ipAddress);
        sendButton = (Button) findViewById(R.id.sendBtn);
        portTxt = (EditText) findViewById(R.id.port);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int port = 0;
                String ipAddress = ipAddressTxt.getText().toString();
                String portString = portTxt.getText().toString();
                ipAddress.replaceAll(" ", "");
                Socket socket;
                if ("".equals(ipAddress)) {
                    showToast("Please enter a valid Ip Address");
                } else if ("".equals(portString)) {
                    showToast("Please enter a valid port number");
                } else {
                    try {
                        port = Integer.parseInt(portString);

                        Client client = new Client(ipAddress, port);
                        socket = client.connectServer();
                        showToast("Trying to connect");
                        if (socket != null) {
                            Intent intent = new Intent(MainActivity.this, MoodActivity.class);
                            startActivity(intent);
                        }
                        else {
                            showToast("Could not create connection");
                        }

                    } catch (NumberFormatException e) {
                        showToast("Please enter a valid port number.");
                    } catch (Exception e) {
                       showToast("Could not connect to the server");
                       e.printStackTrace();
                    }
                }
            }
        });
    }


    public void showToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
