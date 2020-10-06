package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.JobDetailsAdapter;
import com.example.education_app.Model.JobDetailsModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TeacherJobs_Activity extends AppCompatActivity {

    RecyclerView recycle_jobs_details;
    JobDetailsAdapter jobDetailsAdapter;
    List<JobDetailsModel> jobDetailsModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_jobs_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        jobDetailsModels=new ArrayList<>();

        recycle_jobs_details=findViewById(R.id.recycle_jobs_details);
        recycle_jobs_details.setHasFixedSize(true);
        recycle_jobs_details.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        jobDetailsModels.add(new JobDetailsModel("","","Home based Physics Coaching","20,000/-","Full Time","Mukundupur","Kolkata","700052","WB",""));
        jobDetailsModels.add(new JobDetailsModel("","","Home based Physics Coaching","20,000/-","Full Time","Mukundupur","Kolkata","700052","WB",""));
        jobDetailsModels.add(new JobDetailsModel("","","Home based Physics Coaching","20,000/-","Full Time","Mukundupur","Kolkata","700052","WB",""));
        jobDetailsModels.add(new JobDetailsModel("","","Home based Physics Coaching","20,000/-","Full Time","Mukundupur","Kolkata","700052","WB",""));
        jobDetailsAdapter = new JobDetailsAdapter(this,jobDetailsModels);
        recycle_jobs_details.setAdapter(jobDetailsAdapter);

    }
}