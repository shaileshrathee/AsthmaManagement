package com.example.sanjeev.test;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Alarm Sounded", Toast.LENGTH_SHORT).show();




        // This will launch the specified activity of Test App
        Intent i = new Intent();
        i.setClassName("com.example.sanjeev.test", "com.example.sanjeev.test.VideoPlayer");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }


}
