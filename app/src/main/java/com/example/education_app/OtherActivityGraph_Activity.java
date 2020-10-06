package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Model.OtherActivity_Model;
import com.example.education_app.Model.StudentPerformance_Model;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.util.ArrayList;

public class OtherActivityGraph_Activity extends AppCompatActivity {

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelsNames;
    ArrayList<OtherActivity_Model> otherActivity_models = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_graph_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        barChart = findViewById(R.id.barChart);

        barEntryArrayList = new ArrayList<>();
        labelsNames = new ArrayList<>();

        getEntries();

        for (int i=0; i < otherActivity_models.size(); i++){
            String activities =otherActivity_models.get(i).getActivity_name();
            int points = otherActivity_models.get(i).getActivity_points();
            barEntryArrayList.add(new BarEntry(i,points));
            labelsNames.add(activities);
        }

        BarDataSet barDataSet = new BarDataSet(barEntryArrayList,"Monthly Activities");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextSize(14f);
        barDataSet.setHighlightEnabled(false);
        Description description = new Description();
        description.setText("Activity Points");
        barChart.setDescription(description);
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsNames));
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setTextSize(12f);
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(true);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(labelsNames.size());
        xAxis.setLabelRotationAngle(270);
        barChart.animateY(1000);
        barChart.invalidate();
    }

    private void getEntries(){
        otherActivity_models.clear();
        otherActivity_models.add(new OtherActivity_Model("Dance",70));
        otherActivity_models.add(new OtherActivity_Model("Music",60));
        otherActivity_models.add(new OtherActivity_Model("Recitation",80));
        otherActivity_models.add(new OtherActivity_Model("Drawing",65));
        otherActivity_models.add(new OtherActivity_Model("Computer",72));
        otherActivity_models.add(new OtherActivity_Model("Handwork",80));
    }


    }
