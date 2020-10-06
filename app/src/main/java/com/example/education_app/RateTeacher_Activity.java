package com.example.education_app;

import android.graphics.Color;
import android.os.Bundle;
import com.example.education_app.Adapter.Award_Adapter;
import com.example.education_app.Adapter.Review_Adapter;
import com.example.education_app.Model.Award_Model;
import com.example.education_app.Model.Review_Model;
import com.taufiqrahman.reviewratings.BarLabels;
import com.taufiqrahman.reviewratings.RatingReviews;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RateTeacher_Activity extends AppCompatActivity {

    TextView teacher_info,reviews;
    View view_info,view_review;
    LinearLayout linear_info,linear_review;
    RecyclerView rv_reviews,rv_certificate;
    List<Review_Model> review_models;
    List<Award_Model> award_models;
    Review_Adapter review_adapter;
    Award_Adapter award_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_teacher_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        review_models = new ArrayList<>();
        award_models = new ArrayList<>();

        teacher_info = findViewById(R.id.teacher_info);
        reviews = findViewById(R.id.reviews);
        linear_info = findViewById(R.id.linear_info);
        linear_review = findViewById(R.id.linear_review);
        view_info = findViewById(R.id.view_info);
        view_review = findViewById(R.id.view_review);

        RatingReviews ratingReviews = (RatingReviews) findViewById(R.id.rating_reviews);

        int colors[] = new int[]{
                Color.parseColor("#0e9d58"),
                Color.parseColor("#bfd047"),
                Color.parseColor("#ffc105"),
                Color.parseColor("#ef7e14"),
                Color.parseColor("#d36259")};

        int raters[] = new int[]{
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100)
        };

        ratingReviews.createRatingBars(100, BarLabels.STYPE1, colors, raters);

        teacher_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher_info.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_info.setVisibility(View.VISIBLE);
                reviews.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_review.setVisibility(View.GONE);
                linear_info.setVisibility(View.VISIBLE);
                linear_review.setVisibility(View.GONE);
            }
        });

        reviews.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           reviews.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                                           view_review.setVisibility(View.VISIBLE);
                                           teacher_info.setTextColor(getResources().getColor(R.color.colorDGrey));
                                           view_info.setVisibility(View.GONE);
                                           linear_info.setVisibility(View.GONE);
                                           linear_review.setVisibility(View.VISIBLE);
                                       }
                                   });

        rv_reviews = findViewById(R.id.rv_reviews);
        rv_reviews.setHasFixedSize(true);
        rv_reviews.setLayoutManager(new LinearLayoutManager(RateTeacher_Activity.this,LinearLayoutManager.VERTICAL,false));
        review_models.add(new Review_Model("","Suraj Rathod", "The presentation is not well organized"));
        review_models.add(new Review_Model("","Abc bio", "Asked useless questions in the class"));
        review_models.add(new Review_Model("","Suraj Rathod", "The presentation is not well organized"));
        review_models.add(new Review_Model("","Abc bio", "Asked useless questions in the class"));
        review_models.add(new Review_Model("","Suraj Rathod", "The presentation is not well organized"));
        review_adapter = new Review_Adapter(RateTeacher_Activity.this,review_models);
        rv_reviews.setAdapter(review_adapter);

        rv_certificate = findViewById(R.id.rv_certificate);
        rv_certificate.setHasFixedSize(true);
        rv_certificate.setLayoutManager(new LinearLayoutManager(RateTeacher_Activity.this,LinearLayoutManager.HORIZONTAL,false));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_adapter = new Award_Adapter(RateTeacher_Activity.this,award_models);
        rv_certificate.setAdapter(award_adapter);

    }

}