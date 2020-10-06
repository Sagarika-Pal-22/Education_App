package com.example.education_app;

import android.graphics.Color;
import android.os.Bundle;

import com.example.education_app.Model.StudentPerformance_Model;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Attendance_Activity extends AppCompatActivity {

    TextView monthly,final_attendance;
    View view_monthly,view_final;
    LinearLayout linear_monthly,linear_final;

    BetterSpinner spin_month;

    PieChart piechart;
    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelsNames;
    ArrayList<StudentPerformance_Model> studentPerformance_models = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        piechart = findViewById(R.id.piechart);
        barChart = findViewById(R.id.barChart);
        linear_monthly = findViewById(R.id.linear_monthly);
        linear_final = findViewById(R.id.linear_final);
        monthly = findViewById(R.id.monthly);
        final_attendance = findViewById(R.id.final_attendance);
        view_monthly = findViewById(R.id.view_monthly);
        view_final = findViewById(R.id.view_final);
        spin_month = findViewById(R.id.spin_month);

        String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Attendance_Activity.this, android.R.layout.simple_dropdown_item_1line, month);
        spin_month.setAdapter(arrayAdapter);

        barEntryArrayList = new ArrayList<>();
        labelsNames = new ArrayList<>();

        monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monthly.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_monthly.setVisibility(View.VISIBLE);
                final_attendance.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_final.setVisibility(View.GONE);
                linear_monthly.setVisibility(View.VISIBLE);
                linear_final.setVisibility(View.GONE);

            }
        });
        final_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final_attendance.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_final.setVisibility(View.VISIBLE);
                monthly.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_monthly.setVisibility(View.GONE);
                linear_monthly.setVisibility(View.GONE);
                linear_final.setVisibility(View.VISIBLE);


            }
        });

        piechart.setUsePercentValues(false);
        piechart.getDescription().setEnabled(false);
        piechart.setExtraOffsets(5,10,5,5);

        piechart.setDrawHoleEnabled(true);
        piechart.setHoleColor(Color.WHITE);
        piechart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(70f,"Total Classes"));
        yValues.add(new PieEntry(10f,"Total Absents"));
        yValues.add(new PieEntry(60f,"Total Presents"));

        piechart.animateY(1000, Easing.EaseInOutCubic);

        PieDataSet dataSet = new PieDataSet(yValues,"(Attendance)");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.PASTEL_COLORS);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);
        piechart.setData(data);

        // bar chart for final attendance //
        getEntries();

        for (int i=0; i < studentPerformance_models.size(); i++){
            String subjects =studentPerformance_models.get(i).getSubject();
            int numbers = studentPerformance_models.get(i).getNumbers();
            barEntryArrayList.add(new BarEntry(i,numbers));
            labelsNames.add(subjects);
        }

        BarDataSet barDataSet = new BarDataSet(barEntryArrayList,"Total Presents");
        barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        barDataSet.setValueTextSize(14f);
        barDataSet.setHighlightEnabled(false);
        Description description = new Description();
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
        xAxis.setLabelRotationAngle(360);
        barChart.animateY(1000);
        barChart.invalidate();
        // bar chart for final attendance //
    }

    private void getEntries(){
        studentPerformance_models.clear();
        studentPerformance_models.add(new StudentPerformance_Model("Jan",20));
        studentPerformance_models.add(new StudentPerformance_Model("Feb",18));
        studentPerformance_models.add(new StudentPerformance_Model("Mar",25));
        studentPerformance_models.add(new StudentPerformance_Model("Apr",20));
        studentPerformance_models.add(new StudentPerformance_Model("May",22));
        studentPerformance_models.add(new StudentPerformance_Model("Jun",24));
        studentPerformance_models.add(new StudentPerformance_Model("Jul",22));
        studentPerformance_models.add(new StudentPerformance_Model("Aug",24));
        studentPerformance_models.add(new StudentPerformance_Model("Sep",26));
        studentPerformance_models.add(new StudentPerformance_Model("Oct",10));
        studentPerformance_models.add(new StudentPerformance_Model("Nov",21));
        studentPerformance_models.add(new StudentPerformance_Model("Dec",23));
    }

    }
