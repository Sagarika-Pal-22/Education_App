package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.Payment_Adapter;
import com.example.education_app.Model.Payment_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PaymentHistory_Activity extends AppCompatActivity {

    RecyclerView rv_pymnt_hstry;
    List<Payment_Model> payment_models;
    Payment_Adapter payment_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        payment_models = new ArrayList<>();

        rv_pymnt_hstry = findViewById(R.id.rv_pymnt_hstry);
        rv_pymnt_hstry.setHasFixedSize(true);
        rv_pymnt_hstry.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        payment_models.add(new Payment_Model("21 Apr,2015","by Cheque","2 Months Tuition Fees","15000"));
        payment_models.add(new Payment_Model("10 Feb,2015","by Cheque","2 Months Tuition Fees","15000"));
        payment_models.add(new Payment_Model("5 Dec,2014","by Cheque","2 Months Tuition Fees","15000"));
        payment_adapter = new Payment_Adapter(this,payment_models);
        rv_pymnt_hstry.setAdapter(payment_adapter);

    }
}