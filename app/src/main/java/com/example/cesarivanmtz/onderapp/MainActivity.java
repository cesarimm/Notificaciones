package com.example.cesarivanmtz.onderapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tVToken;
    private BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tVToken = findViewById(R.id.tvToken);


        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                tVToken.setText(SharedPrefManager.getInstance(MainActivity.this).getToken());
            }
        };

        registerReceiver(broadcastReceiver, new IntentFilter(FirebaseInstanceIdServices.TOKEN_BROADCAST));
    }
}
