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

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSet;
    TimePicker time;
    DatePicker date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSet = findViewById(R.id.btnSetAlarm);
        time = findViewById(R.id.time_picker);
        date = findViewById(R.id.date_pick);
        Calendar calender = Calendar.getInstance();
        calender.set(date.getYear(), date.getMonth(), date.getDayOfMonth(), time.getHour(), time.getMinute(), 0);
        final long time = calender.getTimeInMillis();
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Alarm.class);
                PendingIntent p1= PendingIntent.getBroadcast(getApplicationContext(),0, intent,0);
                AlarmManager a=(AlarmManager)getSystemService(ALARM_SERVICE);
                a.set(AlarmManager.RTC,System.currentTimeMillis() + time,p1);

            }
        });
    }
}
