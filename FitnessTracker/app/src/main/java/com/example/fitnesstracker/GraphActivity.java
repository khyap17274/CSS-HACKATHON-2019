package com.example.fitnesstracker;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
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

        series = new LineGraphSeries<>();
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>();
        List<Intake> intakes = UserInSession.getUser().getIntakes();
        for(Intake i : intakes){
            series.appendData(new DataPoint(i.getDate(),i.getCalories()),true,intakes.size());
            series2.appendData(new DataPoint(i.getDate(),2000.0),true,intakes.size());

        }
        graphView.addSeries(series);
        graphView.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
        graphView.getGridLabelRenderer().setNumHorizontalLabels(6); // only 4 because of the space

        Date d1 = intakes.get(0).getDate();
        Date dLast = intakes.get(intakes.size() - 1).getDate();

        // set manual x bounds to have nice steps
        graphView.getViewport().setMinX(d1.getTime());
        graphView.getViewport().setMaxX(dLast.getTime());
        graphView.getViewport().setXAxisBoundsManual(true);

        graphView.getGridLabelRenderer().setHumanRounding(false);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setARGB(100,120,0,0);
        paint.setStrokeWidth(5);
        paint.setPathEffect(new DashPathEffect(new float[]{10,20}, 0));
        series2.setCustomPaint(paint);

        graphView.addSeries(series2);

    }
}
