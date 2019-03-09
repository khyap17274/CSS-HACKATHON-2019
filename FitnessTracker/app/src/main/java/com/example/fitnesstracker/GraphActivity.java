package com.example.fitnesstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;
import java.util.List;

import static com.example.fitnesstracker.MockIntakeList.getIntakes;

public class GraphActivity extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        GraphView graphView = findViewById(R.id.graph_view);

        series = new LineGraphSeries<DataPoint>();
        List<Intake> intakes = UserInSession.getUser().getIntakes();
        for(Intake i : intakes){
            series.appendData(new DataPoint(i.getDate(),i.getCalories()),true,6);
        }
        graphView.addSeries(series);

        LineGraphSeries<DataPoint> series2;

        graphView.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
        graphView.getGridLabelRenderer().setNumHorizontalLabels(6); // only 4 because of the space

        Date d1 = intakes.get(0).getDate();
        Date dLast = intakes.get(intakes.size() - 1).getDate();

        // set manual x bounds to have nice steps
        graphView.getViewport().setMinX(d1.getTime());
        graphView.getViewport().setMaxX(dLast.getTime());
        graphView.getViewport().setXAxisBoundsManual(true);

        graphView.getGridLabelRenderer().setHumanRounding(false);

    }
}
