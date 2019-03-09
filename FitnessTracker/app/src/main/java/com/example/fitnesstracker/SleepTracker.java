package com.example.fitnesstracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SleepTracker extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    TextView date;
    TextView timeSlept;
    int sleeping_hour,sleeping_min,waking_hour,waking_min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_tracker);
        timeSlept = findViewById(R.id.example_time);
        date = findViewById(R.id.example_date);
        Date calendar = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("EEE, MMM d");
        String currentDate = format.format(calendar.getTime());
        Log.i(TAG, currentDate);
        date.setText(currentDate);
    }

    public void snooze(View view) {
        Calendar calendar = Calendar.getInstance();
        sleeping_hour = calendar.get(Calendar.HOUR_OF_DAY);
        sleeping_min = calendar.get(Calendar.MINUTE);
    }

    public void awake(View view) {
        Calendar calendar = Calendar.getInstance();
        waking_hour = calendar.get(Calendar.HOUR_OF_DAY);
        waking_min = calendar.get(Calendar.MINUTE);
        if(sleeping_min>waking_min){
            waking_hour += 1;
            waking_min += 60;
        }
        int hourSlept = waking_hour - sleeping_hour;
        int minSlept = waking_min - sleeping_min;
        if(hourSlept<0){
            hourSlept+=24;
        }
        Log.i(TAG,String.valueOf(hourSlept));
        String timeDiff = String.valueOf(hourSlept) + "hrs" + String.valueOf(minSlept)  + "mins";
        Log.i(TAG,timeDiff);
        timeSlept.setText(timeDiff);
    }
}
