package com.example.sanjeev.test;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSet;
    TimePicker time;
    DatePicker date;
    long timeEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSet = findViewById(R.id.btnSetAlarm);
        date = findViewById(R.id.date_pick);
        time = findViewById(R.id.time_picker);

        date.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            }
        });
    }

    public void setAlarm(View view) {
        Intent intent  = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 23432443, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000, pendingIntent);
        Toast.makeText(this, "Alarm will sound in 10 seconds", Toast.LENGTH_SHORT).show();

    }


    public void getTime(View view) {

        Toast.makeText(this, String.valueOf(timeEnd), Toast.LENGTH_SHORT).show();
    }

    public void playVideo(View view) {

        Intent in = new Intent(this, VideoPlayer.class);
        startActivity(in);
    }
}
