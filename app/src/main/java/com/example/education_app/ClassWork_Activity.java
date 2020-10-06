package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.SchoolTask_Adapter;
import com.example.education_app.Model.SchoolTask_Model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClassWork_Activity extends AppCompatActivity {

    RecyclerView rv_newTask;
    List<SchoolTask_Model> class_work;
    SchoolTask_Adapter classwork_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        class_work = new ArrayList<>();

        rv_newTask =findViewById(R.id.rv_newTask);
        rv_newTask.setHasFixedSize(true);
        rv_newTask.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        class_work.add(new SchoolTask_Model("Classwork 1","By Sudeshna Lata","Maths","08-09-2020","10-09-2020"));
        class_work.add(new SchoolTask_Model("Classwork 2","By Sudeshna Lata","Maths","08-09-2020","09-09-2020"));
        classwork_adapter = new SchoolTask_Adapter(this, class_work);
        rv_newTask.setAdapter(classwork_adapter);


    }
}