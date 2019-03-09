package com.example.fitnesstracker;

import java.util.Date;

public class Intake {
    private Date date;
    private double calories;

    Intake(Date date, double calories){
        this.date = date;
        this.calories = calories;
    }

    public void add(double c){
        calories += c;
    }
}
