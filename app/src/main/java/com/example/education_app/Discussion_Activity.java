package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.Discussion_Adapter;
import com.example.education_app.Model.Discussion_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Discussion_Activity extends AppCompatActivity {

    RecyclerView rv_discussion;
    List<Discussion_Model> discussion_models;
    Discussion_Adapter discussion_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        discussion_models = new ArrayList<>();

        rv_discussion = findViewById(R.id.rv_discussion);
        rv_discussion.setHasFixedSize(true);
        rv_discussion.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        discussion_models.add(new Discussion_Model("How do I solve logical reasoning questions?","","Shantanu Nayek",
                "2h ago","t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                "50"));
        discussion_models.add(new Discussion_Model("How do I solve logical reasoning questions?","","Shantanu Nayek",
                "2h ago","t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                "50"));
        discussion_adapter = new Discussion_Adapter(this,discussion_models);
        rv_discussion.setAdapter(discussion_adapter);

    }
}