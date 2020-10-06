package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.FeeNotification_Adapter;
import com.example.education_app.Model.FeeNotification_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FeeNotification_Activity extends AppCompatActivity {

    RecyclerView rv_feeNotification;
    List<FeeNotification_Model> feeNotification_models;
    FeeNotification_Adapter feeNotification_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_notification_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        feeNotification_models = new ArrayList<>();

        rv_feeNotification = findViewById(R.id.rv_feeNotification);
        rv_feeNotification.setHasFixedSize(true);
        rv_feeNotification.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        feeNotification_models.add(new FeeNotification_Model("7-9-2020","8:30 PM","Tuition Fee Pending","Parents are requested to pay the pending fees for the next Tuition session immediately within the given time."));
        feeNotification_models.add(new FeeNotification_Model("7-9-2020","8:30 PM","Medical Fee Pending","Parents are requested to pay the pending fees for the next Tuition session immediately within the given time."));
        feeNotification_adapter = new FeeNotification_Adapter(this,feeNotification_models);
        rv_feeNotification.setAdapter(feeNotification_adapter);

    }
}