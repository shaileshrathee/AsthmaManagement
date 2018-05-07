package com.example.sanjeev.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Alarm extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context,"Wake up",Toast.LENGTH_LONG).show();
        Intent i = new Intent();
        i.setClassName("com.example.sanjeev.test", "com.example.sanjeev.test.VideoPlayer");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
