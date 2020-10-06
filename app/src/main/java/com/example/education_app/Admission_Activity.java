package com.example.education_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

public class Admission_Activity extends AppCompatActivity {

    BetterSpinner spin_gender,spin_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spin_gender = findViewById(R.id.spin_gender);
        spin_class = findViewById(R.id.spin_class);

        String[] gender = {"Male","Female"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Admission_Activity.this, android.R.layout.simple_dropdown_item_1line, gender);
        spin_gender.setAdapter(arrayAdapter);

        String[] classes = {"Nursery","LKG","UKG","1","2","3","4","5","6","7","8","9","10","11","12"};
        ArrayAdapter<String> arrayAdapter_1 = new ArrayAdapter<String>(Admission_Activity.this, android.R.layout.simple_dropdown_item_1line, classes);
        spin_class.setAdapter(arrayAdapter_1);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(Admission_Activity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}