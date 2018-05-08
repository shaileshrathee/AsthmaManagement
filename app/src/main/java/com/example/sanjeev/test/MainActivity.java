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

    long finalTime;
    EditText time_input;
    String[] hour_minute = new String[2];
    int hour, minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent in = getIntent();
        //String message = in.getStringExtra(AlarmReceiver.EXTRA_MESSAGE);
        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        /*
        if(message.equals("PlayVideo")){
            Intent inV = new Intent(this, VideoPlayer.class);
            startActivity(inV);
        }
        */
        time_input = findViewById(R.id.time_input);

    }

    public void setAlarm(View view) {

        String str = String.valueOf(time_input.getText());
        hour_minute = str.split(":");
        hour = Integer.parseInt(hour_minute[0]);
        minute = Integer.parseInt(hour_minute[1]);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        //Toast.makeText(this, "Hour : " + String.valueOf(hour) + "Minute : " + String.valueOf(minute), Toast.LENGTH_SHORT).show();
        Intent intent  = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 23432443, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 86400000, pendingIntent);
        //alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 10, pendingIntent);
        Toast.makeText(this, "Alarm is set successfully", Toast.LENGTH_SHORT).show();

    }


}
