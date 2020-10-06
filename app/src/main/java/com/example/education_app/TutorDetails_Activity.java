package com.example.education_app;

import android.content.Intent;
import android.os.Bundle;

import com.example.education_app.Adapter.Award_Adapter;
import com.example.education_app.Adapter.Facility_Adapter;
import com.example.education_app.Adapter.Review_Adapter;
import com.example.education_app.Model.Award_Model;
import com.example.education_app.Model.Facility_Model;
import com.example.education_app.Model.Review_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TutorDetails_Activity extends AppCompatActivity {

    RecyclerView rv_speciality,rv_achievement,rv_reviews;
    List<Award_Model> award_models;
    List<Facility_Model> facility_models;
    List<Review_Model> review_models;
    Award_Adapter award_adapter;
    Facility_Adapter facility_adapter;
    Review_Adapter review_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_details_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Debjit Mukherjee");


        award_models = new ArrayList<>();
        facility_models = new ArrayList<>();
        review_models = new ArrayList<>();

        rv_speciality = findViewById(R.id.rv_speciality);
        rv_speciality.setHasFixedSize(true);
        rv_speciality.setLayoutManager(new GridLayoutManager(this,2));
        facility_models.add(new Facility_Model("Science"));
        facility_models.add(new Facility_Model("Physics"));
        facility_models.add(new Facility_Model("Mathematics"));
        facility_adapter = new Facility_Adapter(this,facility_models);
        rv_speciality.setAdapter(facility_adapter);

        rv_achievement = findViewById(R.id.rv_achievement);
        rv_achievement.setHasFixedSize(true);
        rv_achievement.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_adapter = new Award_Adapter(this,award_models);
        rv_achievement.setAdapter(award_adapter);

        rv_reviews = findViewById(R.id.rv_reviews);
        rv_reviews.setHasFixedSize(true);
        rv_reviews.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        review_models.add(new Review_Model("","Jay Irani","Good Teacher"));
        review_models.add(new Review_Model("","Vijay Sri","He is a good teacher..explains great"));
        review_models.add(new Review_Model("","Jay Irani","Good Teacher"));
        review_models.add(new Review_Model("","Vijay Sri","He is a good teacher..explains great"));
        review_adapter = new Review_Adapter(this,review_models);
        rv_reviews.setAdapter(review_adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(TutorDetails_Activity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}