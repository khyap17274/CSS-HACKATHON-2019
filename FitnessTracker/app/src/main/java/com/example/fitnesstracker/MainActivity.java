package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import static com.example.fitnesstracker.MockIntakeList.getIntakes;

public class MainActivity extends AppCompatActivity {

//    private Button sleepSoundBtn;
//    private Button sleepTrackerBtn;
//    private Button calorieCounterBtn;

    private ImageButton sleepSoundBtn;
    private ImageButton sleepTrackerBtn;
    private ImageButton calorieCounterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sleepSoundBtn = findViewById(R.id.sleepsound_btn);
        sleepTrackerBtn = findViewById(R.id.sleeptracker_btn);
        calorieCounterBtn = findViewById(R.id.caloriecounter_btn);
        User u = new User();
        List<Intake> intakes = getIntakes();
        u.setIntakes(intakes);
        UserInSession userInSession = UserInSession.getInstance(u);
        goToTracker();
        goToSound();
        goToCalorie();

    }


    private void goToTracker(){
        sleepTrackerBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SleepTracker.class);
                        startActivity(intent);
                    }
                }
        );

    }

    private void goToCalorie(){
        calorieCounterBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }

    private void goToSound(){
        sleepSoundBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, lullaby.class);
                        startActivity(intent);
                    }
                }
        );

    }

}
