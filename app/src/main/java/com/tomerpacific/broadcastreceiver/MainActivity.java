package com.tomerpacific.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
* TODO: Distinguish between broadcast Intents
* TODO: Launch pop up with background activity unfocused
*
*/


public class MainActivity extends AppCompatActivity {

    private Button sendBroadcastBtn;
    private Button startServiceBtn;
    private BroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final IntentFilter intentFilter = new IntentFilter("MY_ACTION");
        this.registerReceiver(myBroadcastReceiver, intentFilter);

        sendBroadcastBtn = findViewById(R.id.sendBroadcastBtn);
        sendBroadcastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("MY_ACTION");
                intent.putExtra("data", "Broadcast!");
                sendBroadcast(intent);
                Log.i("BROADCAST", "onClick" );
            }
        });

        startServiceBtn = findViewById(R.id.startService);
        startServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OverlayService.class);
                intent.putExtra("data", "Service!");
                startService(intent);
                Log.i("SERVICE","onClick");

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(myBroadcastReceiver);
        Log.i("BROADCAST", "onStop" );
    }
}
