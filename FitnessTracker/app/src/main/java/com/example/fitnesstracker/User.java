package com.example.fitnesstracker;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Intake> intakes = new ArrayList<>();

    public void addIntake(Intake i){
        intakes.add(i);
    }

    public void setIntakes(List<Intake> intakes) {
        this.intakes = intakes;
    }
}
