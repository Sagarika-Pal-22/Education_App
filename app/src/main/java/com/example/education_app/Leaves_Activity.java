package com.example.education_app;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;

import com.example.education_app.Adapter.Leave_Adapter;
import com.example.education_app.Model.Leave_Model;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Leaves_Activity extends AppCompatActivity {

    PieChart piechart;
    RecyclerView rv_upcmngLeave,rv_pastLeave;
    List<Leave_Model> leave_models;
    List<Leave_Model> past_leaveList;
    Leave_Adapter leave_adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaves_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        piechart = findViewById(R.id.piechart);
        fab = findViewById(R.id.fab);

        leave_models = new ArrayList<>();
        past_leaveList = new ArrayList<>();

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
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);
        piechart.setData(data);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Leaves_Activity.this);
                LayoutInflater inflater = LayoutInflater.from(Leaves_Activity.this);
                final View dialogView = inflater.inflate(R.layout.dialog_take_leave, null);
                final EditText edit_reason= dialogView.findViewById(R.id.edit_reason);
                final TextView from_date= dialogView.findViewById(R.id.from_date);
                final TextView to_date= dialogView.findViewById(R.id.to_date);
                Button btn_submit= dialogView.findViewById(R.id.btn_submit);
                Button btn_cancel= dialogView.findViewById(R.id.btn_cancel);
                builder.setView(dialogView);
                final AlertDialog alert = builder.create();
                alert.setCanceledOnTouchOutside(true);
                alert.show();
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();

                    }
                });
                from_date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar mcurrentDate = Calendar.getInstance();

                        int mDay   = mcurrentDate.get(Calendar.DAY_OF_MONTH);
                        int mMonth = mcurrentDate.get(Calendar.MONTH);
                        int mYear  = mcurrentDate.get(Calendar.YEAR);
                        DatePickerDialog datePickerDialog = new DatePickerDialog(Leaves_Activity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                String fmonth, fDate;
                                try {
                                    if (month < 10 && dayOfMonth < 10) {

                                        fmonth = "0" + month;
                                        month = Integer.parseInt(fmonth) + 1;
                                        fDate = "0" + dayOfMonth;
                                        String paddedMonth = String.format("%02d", month);
                                        from_date.setText(year + "-" + paddedMonth + "-" + fDate);

                                    } else {

                                        fmonth = "0" + month;
                                        month = Integer.parseInt(fmonth) + 1;
                                        String paddedMonth = String.format("%02d", month);
                                        from_date.setText(year + "-" + paddedMonth + "-" + dayOfMonth);
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, mYear, mMonth, mDay);
                        datePickerDialog.show();
                    }
                });

                to_date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar mcurrentDate = Calendar.getInstance();

                        int mDay   = mcurrentDate.get(Calendar.DAY_OF_MONTH);
                        int mMonth = mcurrentDate.get(Calendar.MONTH);
                        int mYear  = mcurrentDate.get(Calendar.YEAR);
                        DatePickerDialog datePickerDialog = new DatePickerDialog(Leaves_Activity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                String fmonth, fDate;
                                try {
                                    if (month < 10 && dayOfMonth < 10) {

                                        fmonth = "0" + month;
                                        month = Integer.parseInt(fmonth) + 1;
                                        fDate = "0" + dayOfMonth;
                                        String paddedMonth = String.format("%02d", month);
                                        to_date.setText(year + "-" + paddedMonth + "-" + fDate);

                                    } else {

                                        fmonth = "0" + month;
                                        month = Integer.parseInt(fmonth) + 1;
                                        String paddedMonth = String.format("%02d", month);
                                        to_date.setText(year + "-" + paddedMonth + "-" + dayOfMonth);
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, mYear, mMonth, mDay);
                        datePickerDialog.show();
                    }
                });

            }
        });

        rv_upcmngLeave = findViewById(R.id.rv_upcmngLeave);
        rv_upcmngLeave.setHasFixedSize(true);
        rv_upcmngLeave.setLayoutManager(new LinearLayoutManager(Leaves_Activity.this,LinearLayoutManager.VERTICAL,false));
        leave_models.add(new Leave_Model("20-7-2020","20-7-2020","Social Function"));
        leave_adapter = new Leave_Adapter(Leaves_Activity.this,leave_models);
        rv_upcmngLeave.setAdapter(leave_adapter);

        rv_pastLeave = findViewById(R.id.rv_pastLeave);
        rv_pastLeave.setHasFixedSize(true);
        rv_pastLeave.setLayoutManager(new LinearLayoutManager(Leaves_Activity.this,LinearLayoutManager.VERTICAL,false));
        past_leaveList.add(new Leave_Model("10-6-2020","11-6-2020","Because of heavy rain"));
        past_leaveList.add(new Leave_Model("04-04-2020","08-04-2020","Out of station"));
        past_leaveList.add(new Leave_Model("04-04-2020","08-04-2020","Out of station"));
        leave_adapter = new Leave_Adapter(Leaves_Activity.this,past_leaveList);
        rv_pastLeave.setAdapter(leave_adapter);

    }
}