package com.example.fitnesstracker;

import java.util.Date;

public class Intake implements Comparable<Intake> {
    private Date date;
    private double calories;

    Intake(Date date, double calories){
        this.date = date;
        this.calories = calories;
    }

    public void add(double c){
        calories += c;
    }

    public Date getDate() {
        return date;
    }

    public double getCalories() {
        return calories;
    }

    @Override
    public int compareTo(Intake i) {
        return date.compareTo(i.getDate());
    }
}
