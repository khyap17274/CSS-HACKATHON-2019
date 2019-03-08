package com.example.fitnesstracker.food.api;

import android.os.AsyncTask;

import com.example.fitnesstracker.FoodActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void v){
        foodActivity.test_textView.setText(json);
        super.onPostExecute(v);
    }

    public void setParams(String request,FoodActivity foodActivity) {
        this.request = request;
        this.foodActivity = foodActivity;
    }
}
