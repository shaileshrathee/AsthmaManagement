package com.example.sanjeev.test;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSet;
    long finalTime;
    EditText day;
    EditText hour;
    EditText minute;
    int day_input, hour_input, minute_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSet = findViewById(R.id.btnSetAlarm);
        day = findViewById(R.id.day);
        hour = findViewById(R.id.hour);
        minute = findViewById(R.id.minute);

    }

    public void setAlarm(View view) {


        day_input = Integer.parseInt(String.valueOf(day.getText()));
        hour_input = Integer.parseInt(String.valueOf(hour.getText()));
        minute_input = Integer.parseInt(String.valueOf(minute.getText()));

        finalTime = calculateTime(day_input, hour_input, minute_input);

        Intent intent  = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 23432443, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + finalTime, pendingIntent);
        Toast.makeText(this, "Alarm will sound in "+ String.valueOf(finalTime/1000) +" seconds", Toast.LENGTH_SHORT).show();

    }

    private long calculateTime(int day_input, int hour_input, int minute_input) {
        long ans = 0;
        ans = minute_input*60*1000;
        ans += hour_input*60*60*1000;
        ans += day_input*24*60*60*1000;
        return ans;
    }

    public void playVideo(View view) {

        Intent in = new Intent(this, VideoPlayer.class);
        startActivity(in);
    }
}
