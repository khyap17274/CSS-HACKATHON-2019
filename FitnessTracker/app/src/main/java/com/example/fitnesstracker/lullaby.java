package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class lullaby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lullaby);

        final ListView songs = (ListView) findViewById(R.id.songs);
        final ArrayList<String> s = new ArrayList<>();
        s.add("nostalgia");
        s.add("calmpiano");
        s.add("medidation");
        s.add("cheerypiano");
        s.add("harpsounds");
        //s.add("Song5");

        ArrayAdapter songList = new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);

        songs.setAdapter(songList);

        songs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickeditem = s.get(position);
                Intent j = new Intent(getApplicationContext(),sleepsound.class);
                j.putExtra("KEY",clickeditem);
                startActivity(j);


            }
        });

    }
}

