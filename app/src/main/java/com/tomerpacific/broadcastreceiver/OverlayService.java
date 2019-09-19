package com.tomerpacific.broadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class OverlayService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("SERVICE", "onStartCommand" );

        // change view
        Intent i = new Intent(this, ViewA.class);
        startActivity(i);


        // not sure what this line does yet
        return Service.START_NOT_STICKY;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("SERVICE", "onCreate" );
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("SERVICE", "onBind" );
        return null;
    }
}
