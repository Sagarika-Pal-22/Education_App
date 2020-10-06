package com.example.education_app;

import android.content.Intent;
import android.os.Bundle;

import com.example.education_app.Adapter.All_Live_Adapter;
import com.example.education_app.Model.Live_Model;
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

public class LiveClass_Activity extends AppCompatActivity {

    RecyclerView recycler_all_live;
    List<Live_Model> live_models = new ArrayList<>();
    All_Live_Adapter all_live_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_class_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler_all_live = findViewById(R.id.recycler_all_live);
        LinearLayoutManager linearLayoutManager_live = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recycler_all_live.setLayoutManager(linearLayoutManager_live);
        recycler_all_live.setHasFixedSize(true);
        live_models.add(new Live_Model("","English","English Literature Rev-I","Started at","7:50","Kalki Seth"));
        live_models.add(new Live_Model("","Science","Arrow of Time","Started at","7:50","Anuj Tiwary"));
        live_models.add(new Live_Model("","History","Ancient Period","Started at","7:50","Kalki Seth"));
        live_models.add(new Live_Model("","Hindi","literature I","Started at","7:50","Anuj Tiwary"));
        all_live_adapter = new All_Live_Adapter(LiveClass_Activity.this,live_models);
        recycler_all_live.setAdapter(all_live_adapter);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(LiveClass_Activity.this, MyTabsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}