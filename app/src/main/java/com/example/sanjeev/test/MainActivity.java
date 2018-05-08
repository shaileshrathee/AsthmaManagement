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

    EditText time_input;
    String[] hour_minute = new String[2];
    int hour, minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time_input = findViewById(R.id.time_input);

    }

    // This method is called, when setAlarm method is clicked
    // It will extract time from edittext that user has entered in 24 hour format
    // and set the alarm at that particular time which will sound daily at that time
    public void setAlarm(View view) {
        // extracting time input as string
        String str = String.valueOf(time_input.getText());
        hour_minute = str.split(":");
        // converting it to integer
        hour = Integer.parseInt(hour_minute[0]);
        minute = Integer.parseInt(hour_minute[1]) - 1;
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
}
