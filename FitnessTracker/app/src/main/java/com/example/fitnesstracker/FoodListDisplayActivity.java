package com.example.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodListDisplayActivity extends AppCompatActivity {

    private ListView foodListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list_display);
        foodListview = findViewById(R.id.food_listview);
        String[] foodArray = i.getStringArrayExtra("FOODS");
        List<String> foods = Arrays.asList(foodArray);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,foods);
        foodListview.setAdapter(arrayAdapter);
    }

}
