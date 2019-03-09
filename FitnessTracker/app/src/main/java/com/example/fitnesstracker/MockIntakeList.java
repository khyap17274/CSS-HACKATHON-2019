package com.example.fitnesstracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MockIntakeList {
    private static List<Intake> intakes = new ArrayList<>();
    static{
        List<Double> calories = Arrays.asList(1800.0,2100.0,1600.0,2400.0,2000.0);
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int i = 8;
        while(i >= 4){
            calendar.set(2019,3,i);
            Date d = calendar.getTime();
            dates.add(d);
            i--;
        }
        for(int j = 0; j < calories.size(); j++){
            Intake intake = new Intake(dates.get(j),calories.get(j));
            intakes.add(intake);
        }
    }

    public static List<Intake> getIntakes() {
        return intakes;
    }
}
