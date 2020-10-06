package com.example.education_app;

import android.content.Intent;
import android.os.Bundle;

import com.example.education_app.Adapter.Task_Adapter;
import com.example.education_app.Model.Task_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class NewTask_Activity extends AppCompatActivity {

    RecyclerView rv_newTask;
    List<Task_Model> task_models;
    Task_Adapter task_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        task_models = new ArrayList<>();
        rv_newTask = findViewById(R.id.rv_newTask);
        rv_newTask.setHasFixedSize(true);
        rv_newTask.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        task_models.add(new Task_Model("1","Copy and Complete the crossword puzzle from WS 23 in your notebook"));
        task_models.add(new Task_Model("2","Recite your poem infront of a family member and take feedback."));
        task_models.add(new Task_Model("3","Watch the youtube video http://youtube.com"));
        task_models.add(new Task_Model("4","Copy and Complete the crossword puzzle from WS 23 in your notebook"));
        task_models.add(new Task_Model("5","Recite your poem infront of a family member and take feedback."));
        task_models.add(new Task_Model("6","Watch the youtube video http://youtube.com"));
        task_adapter = new Task_Adapter(this,task_models);
        rv_newTask.setAdapter(task_adapter);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(NewTask_Activity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}