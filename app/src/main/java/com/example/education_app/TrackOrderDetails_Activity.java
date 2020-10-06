package com.example.education_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TrackOrderDetails_Activity extends AppCompatActivity {

    LinearLayout linear_orderTrack,linear_orderDetails,linear_viewOrder,linear_cancel,linear_cancelOrder;
    Button btn_cancelItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_order_details_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        linear_viewOrder = findViewById(R.id.linear_viewOrder);
        linear_cancel = findViewById(R.id.linear_cancel);
        linear_orderTrack = findViewById(R.id.linear_orderTrack);
        linear_orderDetails = findViewById(R.id.linear_orderDetails);
        linear_cancelOrder = findViewById(R.id.linear_cancelOrder);
        btn_cancelItem = findViewById(R.id.btn_cancelItem);

        linear_viewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_orderTrack.setVisibility(View.GONE);
                linear_orderDetails.setVisibility(View.VISIBLE);
            }
        });
        linear_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_orderTrack.setVisibility(View.GONE);
                linear_orderDetails.setVisibility(View.GONE);
                linear_cancelOrder.setVisibility(View.VISIBLE);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(TrackOrderDetails_Activity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}