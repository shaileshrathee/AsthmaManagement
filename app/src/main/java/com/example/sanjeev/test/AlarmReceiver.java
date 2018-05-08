package com.example.sanjeev.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.Vibrator;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

    // This will receive the alarm
    @Override
    public void onReceive(Context context, Intent intent) {
        // show a toast message
        Toast.makeText(context, "Alarm Sounded", Toast.LENGTH_LONG).show();
        // vibrate the phone for 1 second
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (v != null) {
            v.vibrate(1000);
        }
        // Launch the video
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        // Launch the video when screen is turned on
        if (pm != null && pm.isInteractive()) {
            Intent i = new Intent();
            i.setClassName("com.example.sanjeev.test", "com.example.sanjeev.test.VideoPlayer");
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
