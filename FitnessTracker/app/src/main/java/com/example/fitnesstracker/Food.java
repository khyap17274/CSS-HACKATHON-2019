package com.example.fitnesstracker;

import android.support.annotation.NonNull;

public class Food {
    private String item_name;
    private double nf_calories;
    private int nf_serving_size_qty;


    public void setNf_calories(double nf_calories) {
        this.nf_calories = nf_calories;
    }

    public double getNf_calories() {
        return nf_calories;
    }

    public void setItem_name(String name) {
        this.item_name = name;
    }

    public String getName() {
        return item_name;
    }

    public int getNf_serving_size_qty() {
        return nf_serving_size_qty;
    }

    public void setNf_serving_size_qty(int nf_serving_size_qty) {
        this.nf_serving_size_qty = nf_serving_size_qty;
    }

    @NonNull
    @Override
    public String toString() {
        return item_name + "\n" + nf_calories + "calories \n";
    }
}
