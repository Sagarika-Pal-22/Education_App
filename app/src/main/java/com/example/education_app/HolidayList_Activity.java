package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.Holiday_Adapter;
import com.example.education_app.Model.Holiday_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HolidayList_Activity extends AppCompatActivity {

    RecyclerView rv_holidays;
    List<Holiday_Model> holiday_models;
    Holiday_Adapter holiday_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_list_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        holiday_models = new ArrayList<>();

        rv_holidays = findViewById(R.id.rv_holidays);
        rv_holidays.setHasFixedSize(true);
        rv_holidays.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        holiday_models.add(new Holiday_Model("2020-06-16","Holi"));
        holiday_models.add(new Holiday_Model("2020-06-20","Durga puja"));
        holiday_models.add(new Holiday_Model("2020-06-22","Christmas"));
        holiday_models.add(new Holiday_Model("2020-06-25","Sankranti"));
        holiday_adapter = new Holiday_Adapter(this,holiday_models);
        rv_holidays.setAdapter(holiday_adapter);
    }
}