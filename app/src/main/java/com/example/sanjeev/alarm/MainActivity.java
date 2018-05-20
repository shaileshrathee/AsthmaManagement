package com.example.sanjeev.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    int hour, minute;
    public static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.time_input);
    }

    public void setAlarm(View view) {
        hour = timePicker.getCurrentHour();
        minute = timePicker.getCurrentMinute();
        // Building a calender object
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        // creating an intent
        Intent intent  = new Intent(this, AlarmReceiver.class);
        // Creating a Broadcast and setting alarm
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 23432443, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 86400000, pendingIntent);
        }
        Toast.makeText(this, "Alarm is set successfully", Toast.LENGTH_LONG).show();
    }

    public void submitData(View view) {
        Intent in = new Intent(this, WebPageDisplay.class);
        url = "https://docs.google.com/forms/d/e/1FAIpQLSdYMCaQ2ypqSgkRGc6q2FFNc6uWeQtPzzbVGJrB6_Uty2r04g/viewform?usp=sf_link";
        in.putExtra("URL", url);
        startActivity(in);
    }

    public void survey1(View view) {
        Intent in = new Intent(this, WebPageDisplay.class);
        url = "https://docs.google.com/forms/d/e/1FAIpQLSfuOzx8lllerEqEsYU0sM1S-NINYDO_4KGETE1dbDS1H1d4Bg/viewform";
        in.putExtra("URL", url);
        startActivity(in);
    }

    public void survey2(View view) {
        Intent in = new Intent(this, WebPageDisplay.class);
        url = "https://docs.google.com/forms/d/e/1FAIpQLSd4UPGv-1qJfEyjjiT1tbikTkqwLWzn-P3BOiarGr8YxDNBqg/viewform";
        in.putExtra("URL", url);
        startActivity(in);
    }
}
