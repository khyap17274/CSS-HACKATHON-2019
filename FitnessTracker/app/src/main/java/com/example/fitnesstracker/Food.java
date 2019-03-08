package com.example.fitnesstracker;

public class Food {
    private String item_name;
    private float nf_calories;
    private int nf_serving_size_qty;


    public void setNf_calories(float nf_calories) {
        this.nf_calories = nf_calories;
    }

    public float getNf_calories() {
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
}
