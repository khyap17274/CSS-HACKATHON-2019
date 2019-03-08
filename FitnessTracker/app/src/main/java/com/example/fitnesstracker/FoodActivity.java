package com.example.fitnesstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitnesstracker.food.api.FoodAsyncTask;

public class FoodActivity extends AppCompatActivity {

    public TextView test_textView;
    private Button  search_btn;
    private EditText search_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        test_textView = findViewById(R.id.food_textView);
        search_btn = findViewById(R.id.search_btn);
        search_editText = findViewById(R.id.search_editText);
        start();
    }

    private void start(){
        search_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = "https://api.nutritionix.com/v1_1/search/";
                        String queries = "?fields=nf_calories%2Citem_name&appId=b56bae5d&appKey=c546a49fec4a16103111213c8c11531b";
                        String phrase = search_editText.getText().toString();
                        phrase = phrase.replaceAll(" ","%20");
                        url += phrase;
                        url += queries;
                        FoodAsyncTask asyncTask = new FoodAsyncTask();
                        asyncTask.setParams(url,FoodActivity.this);
                        asyncTask.execute();
                    }
                }
        );
    }
}
