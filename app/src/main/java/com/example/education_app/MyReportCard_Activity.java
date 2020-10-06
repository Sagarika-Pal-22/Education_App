package com.example.education_app;

import android.os.Bundle;

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

public class MyReportCard_Activity extends AppCompatActivity {

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelsNames;
    ArrayList<StudentPerformance_Model> studentPerformance_models = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_report_card_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        barChart = findViewById(R.id.barChart);

        barEntryArrayList = new ArrayList<>();
        labelsNames = new ArrayList<>();

        getEntries();

        for (int i=0; i < studentPerformance_models.size(); i++){
            String subjects =studentPerformance_models.get(i).getSubject();
            int numbers = studentPerformance_models.get(i).getNumbers();
            barEntryArrayList.add(new BarEntry(i,numbers));
            labelsNames.add(subjects);
        }

        BarDataSet barDataSet = new BarDataSet(barEntryArrayList,"Grade Points");
        barDataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        barDataSet.setValueTextSize(14f);
        barDataSet.setHighlightEnabled(false);
        Description description = new Description();
        description.setText("Grades");
        barChart.setDescription(description);
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsNames));
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(true);
        xAxis.setGranularity(1f);
        xAxis.setTextSize(12f);
        xAxis.setLabelCount(labelsNames.size());
        xAxis.setLabelRotationAngle(380);
        barChart.animateY(1000);
        barChart.invalidate();
    }

    private void getEntries(){
        studentPerformance_models.clear();
        studentPerformance_models.add(new StudentPerformance_Model("A1",10));
        studentPerformance_models.add(new StudentPerformance_Model("A2",9));
        studentPerformance_models.add(new StudentPerformance_Model("B1",8));
        studentPerformance_models.add(new StudentPerformance_Model("B2",7));
        studentPerformance_models.add(new StudentPerformance_Model("C1",6));
        studentPerformance_models.add(new StudentPerformance_Model("C2",5));
        studentPerformance_models.add(new StudentPerformance_Model("D",4));
        studentPerformance_models.add(new StudentPerformance_Model("E1",0));
        studentPerformance_models.add(new StudentPerformance_Model("E0",0));
    }

    }
