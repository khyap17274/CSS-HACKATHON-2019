package com.example.fitnesstracker.food.api;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fitnesstracker.Food;
import com.example.fitnesstracker.FoodActivity;
import com.example.fitnesstracker.FoodListDisplayActivity;
import com.example.fitnesstracker.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.example.fitnesstracker.JSONParser.getFoods;

public class FoodAsyncTask extends AsyncTask<Void,Void,Void> {

    private String request;
    private String json = "";

    private FoodActivity foodActivity;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(request);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while(line != null){
                line = bufferedReader.readLine();
                sb.append(line);
            }
            json = sb.toString();
            JSONParser jsonParser = new JSONParser();
            jsonParser.parseJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void v){
        List<Food> foods = getFoods();
        String[] foodArray = new String[foods.size()];
        for(int i = 0; i < foodArray.length; i++){
            foodArray[i] = foods.get(i).toString();
        }
        Intent i = new Intent(foodActivity,FoodListDisplayActivity.class);
        i.putExtra("FOODS",foodArray);
        foodActivity.startActivity(i);
        //ListView foodList = foodActivity.food_listView;
        // ArrayAdapter arrayAdapter = new ArrayAdapter<>(foodActivity, android.R.layout.simple_list_item_1,foods);
       // foodList.setAdapter(arrayAdapter);
        super.onPostExecute(v);
    }

    public void setParams(String request,FoodActivity foodActivity) {
        this.request = request;
        this.foodActivity = foodActivity;
    }
}
