package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.AssignProject_Adapter;
import com.example.education_app.Model.AssignProject_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AssignProject_Activity extends AppCompatActivity {

    RecyclerView rv_assignProject;
    List<AssignProject_Model> assignProject_models;
    AssignProject_Adapter assignProject_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_project_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        assignProject_models = new ArrayList<>();

        rv_assignProject = findViewById(R.id.rv_assignProject);
        rv_assignProject.setHasFixedSize(true);
        rv_assignProject.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        assignProject_models.add(new AssignProject_Model("Blog","by Sudeshna Chawhan","create blogs for literary characters or historical figures.  Create an actual blog for free at blogger.com or just have students write and organize articles on white printer paper if the internet is not available.",
                "10-09-2020"));
        assignProject_models.add(new AssignProject_Model("Crossword Puzzles","by Sudeshna Chawhan","create a crossword puzzle to review definitions of challenging vocabulary words.  Great for science, social studies, reading, and even math terms.",
                "10-09-2020"));
        assignProject_adapter = new AssignProject_Adapter(this,assignProject_models);
        rv_assignProject.setAdapter(assignProject_adapter);

    }
}