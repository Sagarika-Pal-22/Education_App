package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.SchoolTask_Adapter;
import com.example.education_app.Model.SchoolTask_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomeWork_Activity extends AppCompatActivity {

    RecyclerView rv_newTask;
    List<SchoolTask_Model> home_work;
    SchoolTask_Adapter homework_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        home_work = new ArrayList<>();

        rv_newTask =findViewById(R.id.rv_newTask);
        rv_newTask.setHasFixedSize(true);
        rv_newTask.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        home_work.add(new SchoolTask_Model("Homework 1","By Sudeshna Lata","Maths","08-09-2020","10-09-2020"));
        home_work.add(new SchoolTask_Model("Homework 2","By Sudeshna Lata","Maths","08-09-2020","09-09-2020"));
        homework_adapter = new SchoolTask_Adapter(this, home_work);
        rv_newTask.setAdapter(homework_adapter);

    }
}