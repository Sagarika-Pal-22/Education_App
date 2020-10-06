package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.TransportFee_Adapter;
import com.example.education_app.Model.TransportFee_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TransportFeeDetails_Activity extends AppCompatActivity {

    RecyclerView rv_feeTransport;
    List<TransportFee_Model> transportFee_model;
    TransportFee_Adapter transportFee_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_fee_details_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        transportFee_model = new ArrayList<>();

        rv_feeTransport = findViewById(R.id.rv_feeTransport);
        rv_feeTransport.setHasFixedSize(true);
        rv_feeTransport.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        transportFee_model.add(new TransportFee_Model("1","Panar Path","15,00/-"));
        transportFee_model.add(new TransportFee_Model("2","Sec v","15,00/-"));
        transportFee_model.add(new TransportFee_Model("3","Panar Path","15,00/-"));
        transportFee_model.add(new TransportFee_Model("4","Garia MAin Rd","15,00/-"));
        transportFee_model.add(new TransportFee_Model("5","Belgachia","15,00/-"));
        transportFee_model.add(new TransportFee_Model("6","Dhakuria","15,00/-"));
        transportFee_adapter = new TransportFee_Adapter(this,transportFee_model);
        rv_feeTransport.setAdapter(transportFee_adapter);

    }
}