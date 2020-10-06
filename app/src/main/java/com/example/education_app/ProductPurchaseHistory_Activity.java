package com.example.education_app;

import android.os.Bundle;

import com.example.education_app.Adapter.Order_Adapter;
import com.example.education_app.Model.Order_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ProductPurchaseHistory_Activity extends AppCompatActivity {

    RecyclerView recycler_order;
    List<Order_Model> order_models;
    Order_Adapter order_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_purchase_history_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        order_models = new ArrayList<>();

        recycler_order = findViewById(R.id.recycler_order);
        recycler_order.setHasFixedSize(true);
        recycler_order.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        order_models.add(new Order_Model("","Applied Chemistry","19-Feb-2020"));
        order_models.add(new Order_Model("","Applied Chemistry","01-April-2020"));
        order_models.add(new Order_Model("","Applied Chemistry","05-July-2020"));
        order_adapter = new Order_Adapter(this,order_models);
        recycler_order.setAdapter(order_adapter);

    }
}