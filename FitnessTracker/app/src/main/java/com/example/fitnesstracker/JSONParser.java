package com.example.fitnesstracker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONParser {
    private static List<Food> foods = new ArrayList<>();


    public void parseJson(String json){
        foods.clear();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray  jsonArray = jsonObject.getJSONArray("hits");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject post = jsonArray.getJSONObject(i);
                JSONObject fields = post.getJSONObject("fields");
                Food food = new Food();
                food.setItem_name(fields.getString("item_name"));
                food.setNf_calories(fields.getDouble("nf_calories"));
                food.setNf_serving_size_qty(1);
                foods.add(food);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static List<Food> getFoods(){
        return foods;
    }


}


