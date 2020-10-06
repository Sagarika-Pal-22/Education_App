package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.TchrRating_Adapter;
import com.example.education_app.Model.TeacherRating_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyTeacher_Activity extends AppCompatActivity {

    RecyclerView rv_teacher;
    List<TeacherRating_Model> teacherRating_models;
    TchrRating_Adapter tchrRating_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_teacher_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        teacherRating_models = new ArrayList<>();

        rv_teacher = findViewById(R.id.rv_teacher);
        rv_teacher.setHasFixedSize(true);
        rv_teacher.setLayoutManager(new GridLayoutManager(this,2));
        teacherRating_models.add(new TeacherRating_Model("","Ajay Dixit","English","4.3"));
        teacherRating_models.add(new TeacherRating_Model("","Rahul Jain","History","4.0"));
        teacherRating_models.add(new TeacherRating_Model("","Raima Kumari","Physics","4.5"));
        teacherRating_models.add(new TeacherRating_Model("","Rahul Jain","History","4.0"));
        teacherRating_models.add(new TeacherRating_Model("","Raima Kumari","Physics","4.5"));
        tchrRating_adapter = new TchrRating_Adapter(this,teacherRating_models);
        rv_teacher.setAdapter(tchrRating_adapter);

    }
}