package com.tomerpacific.broadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class OverlayService extends Service {

    private WindowManager windowManager;
    private ImageView popUp;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("SERVICE", "onStartCommand" );
        Toast.makeText(getApplicationContext(), "Service!", Toast.LENGTH_LONG).show();

        // change view
        /*
        Intent i = new Intent(this, ViewA.class);
        startActivity(i);
        */

        // not sure what this line does yet
        return Service.START_NOT_STICKY;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("SERVICE", "onCreate" );

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);



    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("SERVICE", "onBind" );
        return null;
    }
}
