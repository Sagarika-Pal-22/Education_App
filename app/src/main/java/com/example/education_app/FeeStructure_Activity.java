package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.FeeStructure_Adapter;
import com.example.education_app.Model.FeeStructure_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FeeStructure_Activity extends AppCompatActivity {

    RecyclerView rv_feeStructure;
    List<FeeStructure_Model> feeStructure_models;
    FeeStructure_Adapter feeStructure_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_structure_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        feeStructure_models = new ArrayList<>();

        rv_feeStructure = findViewById(R.id.rv_feeStructure);
        rv_feeStructure.setHasFixedSize(true);
        rv_feeStructure.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        feeStructure_models.add(new FeeStructure_Model("Tuition","4,144.00","25th Oct"));
        feeStructure_models.add(new FeeStructure_Model("Medical","2,000.00","25th Oct"));
        feeStructure_models.add(new FeeStructure_Model("Activity","1500.00","25th Oct"));
        feeStructure_models.add(new FeeStructure_Model("Maintanance & Improvement","5,000.00","25th Oct"));
        feeStructure_models.add(new FeeStructure_Model("Accessories","3,000.00","25th Oct"));
        feeStructure_adapter = new FeeStructure_Adapter(this,feeStructure_models);
        rv_feeStructure.setAdapter(feeStructure_adapter);
    }
}