package com.example.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.fitnesstracker.JSONParser.getFoods;

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
        itemClick();
    }

    private void itemClick(){
        foodListview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        List<Food> foods = getFoods();
                        Food f = foods.get(position);
                        openDialog(f.getNf_calories());
                    }
                }
        );
    }

    private void openDialog(double calories){
        ServingDialog servingDialog = new ServingDialog();
        servingDialog.setCalories(calories);
        servingDialog.show(getSupportFragmentManager(),"serving dialog");
    }

}
