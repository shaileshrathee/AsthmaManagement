package com.example.sanjeev.alarm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "HEY", Toast.LENGTH_SHORT).show();

        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (v != null) {
            v.vibrate(1000);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context,"Asthma Management")
                .setContentTitle("TITLE")
                .setContentText("RECIVIED NOTIFICATION")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        if (Build.VERSION.SDK_INT > 25){
            NotificationChannel notificationChannel = new NotificationChannel("Asthma Management","Asthma Management", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.notify("tag",1,notificationBuilder.build());
        }

        Intent i = new Intent();
        i.setClassName("com.example.sanjeev.alarm", "com.example.sanjeev.alarm.VideoPlayer");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

/*    // This will receive the alarm
    @Override
    public void onReceive(Context context, Intent intent) {
        // show a toast message
        Toast.makeText(context, "Alarm Sounded", Toast.LENGTH_LONG).show();
        // vibrate the phone for 1 second

        // Launch the video
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        // Launch the video when screen is turned on


    }*/
}
