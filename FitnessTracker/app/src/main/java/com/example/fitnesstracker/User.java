package com.example.fitnesstracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private List<Intake> intakes = new ArrayList<>();

    public void addIntake(Intake i){
        intakes.add(i);
    }

    public void setIntakes(List<Intake> intakes) {
        this.intakes = intakes;
    }

    public List<Intake> getIntakes() {
        Collections.sort(intakes);
        return intakes;
    }
}
