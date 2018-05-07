package com.example.sanjeev.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Sounded", Toast.LENGTH_SHORT).show();

        PackageManager pm = context.getPackageManager();
        Intent launchIntent = pm.getLaunchIntentForPackage("com.example.sanjeev.test");
        intent.putExtra("playVideo", true);
        context.startActivity(launchIntent);
    }
}
