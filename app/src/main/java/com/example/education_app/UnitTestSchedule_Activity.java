package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.Exam_Adapter;
import com.example.education_app.Model.Exam_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class UnitTestSchedule_Activity extends AppCompatActivity {

    RecyclerView rv_upcoming;
    List<Exam_Model> upcoming_exam;
    Exam_Adapter exam_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_test_schedule_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        upcoming_exam = new ArrayList<>();

        rv_upcoming = findViewById(R.id.rv_upcoming);
        rv_upcoming.setHasFixedSize(true);
        rv_upcoming.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        upcoming_exam.add(new Exam_Model("English","Starts on 20 Sep, 2020","Comprehension","","class test"));
        upcoming_exam.add(new Exam_Model("Mathematics","Starts on 22 Sep, 2020","Algebra & Trigonometry","","class test"));
        exam_adapter = new Exam_Adapter(this,upcoming_exam);
        rv_upcoming.setAdapter(exam_adapter);
    }
}