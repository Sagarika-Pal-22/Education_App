package com.example.education_app;

import android.content.Intent;
import android.os.Bundle;

import com.example.education_app.Adapter.Notice_Adapter;
import com.example.education_app.Adapter.Notification_Adapter;
import com.example.education_app.Model.Notice_Model;
import com.example.education_app.Model.Notification_Model;
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

public class MyNotification_Activity extends AppCompatActivity {

    RecyclerView rv_notice;
    List<Notice_Model> notice_models;
    Notice_Adapter notice_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        notice_models = new ArrayList<>();

        rv_notice = findViewById(R.id.rv_notice);
        rv_notice.setHasFixedSize(true);
        rv_notice.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        notice_models.add(new Notice_Model("Image","Hola School","2h ago","Dear Parents/Guardian as informed earlier the Annual Day function of the School will be held on 10th Sep 2020 for classes Pre-Nursery to X, at the School Premises",""));
        notice_models.add(new Notice_Model("","Hola School","2h ago","Parent Teacher Meeting will be held on this Friday",""));
        notice_models.add(new Notice_Model("","Hola School","1d ago","Plantation programme will be held on 22nd Sep",""));
        notice_adapter = new Notice_Adapter(this,notice_models);
        rv_notice.setAdapter(notice_adapter);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(MyNotification_Activity.this, MyTabsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}