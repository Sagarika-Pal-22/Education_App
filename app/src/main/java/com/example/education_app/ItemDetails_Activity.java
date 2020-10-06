package com.example.education_app;

import android.content.Intent;
import android.os.Bundle;

import com.example.education_app.Adapter.Clothes_Adapter;
import com.example.education_app.Adapter.Review_Adapter;
import com.example.education_app.Adapter.ViewPagerAdapter;
import com.example.education_app.Model.Clothes_Model;
import com.example.education_app.Model.Review_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ItemDetails_Activity extends AppCompatActivity {

    ViewPager viewPager_product;
    ViewPagerAdapter viewPagerAdapter;
    int slideImages[];
    private static int currentPage=0;
    private static int numPages=0;

    TextView text_details,text_reviews,xs,s,m,l,xl;
    View view_details,view_reviews;
    LinearLayout linear_size_details,linear_details,linear_reviews;
    RecyclerView rv_may_also_like,rv_reviews;
    List<Clothes_Model> clothes_models;
    Clothes_Adapter clothes_adapter;
    List<Review_Model> review_models;
    Review_Adapter review_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager_product = findViewById(R.id.viewPager_product);
        text_details = findViewById(R.id.text_details);
        text_reviews = findViewById(R.id.text_reviews);
        view_details = findViewById(R.id.view_details);
        view_reviews = findViewById(R.id.view_reviews);
        xs = findViewById(R.id.xs);
        s = findViewById(R.id.s);
        m = findViewById(R.id.m);
        l = findViewById(R.id.l);
        xl = findViewById(R.id.xl);
        linear_size_details = findViewById(R.id.linear_size_details);
        linear_details = findViewById(R.id.linear_details);
        linear_reviews = findViewById(R.id.linear_reviews);

        clothes_models = new ArrayList<>();
        review_models = new ArrayList<>();

        slideImages = new int[]{R.drawable.cloth_4, R.drawable.cloth_2, R.drawable.cloth_4, R.drawable.cloth_2};
        viewPagerAdapter =new ViewPagerAdapter(this,slideImages);
        viewPager_product.setAdapter(viewPagerAdapter);

        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager_product);
        viewPager_product.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;

            }

            @Override
            public void onPageScrollStateChanged(int i) {

                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int pagecount = slideImages.length;
                    if (currentPage == 0) {
                        viewPager_product.setCurrentItem(pagecount - 1, false);
                    } else if (currentPage == pagecount - 1) {
                        viewPager_product.setCurrentItem(0, false);
                    }
                }
            }
        });
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage==numPages){
                    currentPage=0;
                }
                viewPager_product.setCurrentItem(currentPage++,true);
            }
        };
        view_details.setVisibility(View.VISIBLE);
        text_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_details.setVisibility(View.VISIBLE);
                view_reviews.setVisibility(View.GONE);
                linear_details.setVisibility(View.VISIBLE);
                linear_reviews.setVisibility(View.GONE);
            }
        });
        text_reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_reviews.setVisibility(View.VISIBLE);
                view_details.setVisibility(View.GONE);
                linear_details.setVisibility(View.GONE);
                linear_reviews.setVisibility(View.VISIBLE);
            }
        });

        xs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_size_details.setVisibility(View.VISIBLE);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_size_details.setVisibility(View.VISIBLE);
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_size_details.setVisibility(View.VISIBLE);
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_size_details.setVisibility(View.VISIBLE);
            }
        });
        xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_size_details.setVisibility(View.VISIBLE);
            }
        });

        rv_may_also_like = findViewById(R.id.rv_may_also_like);
        rv_may_also_like.setHasFixedSize(true);
        rv_may_also_like.setLayoutManager(new GridLayoutManager(ItemDetails_Activity.this,2));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_4,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_2,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_4,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_2,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_4,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_2,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_4,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_2,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        clothes_adapter = new Clothes_Adapter(ItemDetails_Activity.this,clothes_models);
        rv_may_also_like.setAdapter(clothes_adapter);

        rv_reviews = findViewById(R.id.rv_reviews);
        rv_reviews.setHasFixedSize(true);
        rv_reviews.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        review_models.add(new Review_Model("","Suraj Rathod", "Nice Product"));
        review_models.add(new Review_Model("","Suraj Rathod", "Good Material"));
        review_models.add(new Review_Model("","Suraj Rathod", "Nice..worth buying it"));
        review_models.add(new Review_Model("","Suraj Rathod", "Satisfied"));
        review_models.add(new Review_Model("","Suraj Rathod", "Recommend to buy everyone"));
        review_adapter = new Review_Adapter(this,review_models);
        rv_reviews.setAdapter(review_adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(ItemDetails_Activity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}