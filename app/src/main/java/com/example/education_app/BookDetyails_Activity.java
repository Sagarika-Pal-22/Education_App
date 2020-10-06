package com.example.education_app;

import android.content.Intent;
import android.os.Bundle;

import com.example.education_app.Adapter.Book_Adapter;
import com.example.education_app.Adapter.Review_Adapter;
import com.example.education_app.Model.Book_Model;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookDetyails_Activity extends AppCompatActivity {

    ImageView img_book;
    TextView text_details,text_reviews,text_related;
    View view_details,view_reviews,view_related;
    LinearLayout linear_details,linear_related,linear_reviews;
    RecyclerView rv_reviews,rv_books;
    List<Review_Model> review_models;
    Review_Adapter review_adapter;
    List<Book_Model> book_models;
    Book_Adapter book_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detyails_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        img_book = findViewById(R.id.img_book);
        text_details = findViewById(R.id.text_details);
        text_reviews = findViewById(R.id.text_reviews);
        text_related = findViewById(R.id.text_related);
        view_details = findViewById(R.id.view_details);
        view_reviews = findViewById(R.id.view_reviews);
        view_related = findViewById(R.id.view_related);
        linear_details = findViewById(R.id.linear_details);
        linear_related = findViewById(R.id.linear_related);
        linear_reviews = findViewById(R.id.linear_reviews);

        view_details.setVisibility(View.VISIBLE);
        text_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_details.setVisibility(View.VISIBLE);
                view_related.setVisibility(View.GONE);
                view_reviews.setVisibility(View.GONE);
                linear_details.setVisibility(View.VISIBLE);
                linear_related.setVisibility(View.GONE);
                linear_reviews.setVisibility(View.GONE);
            }
        });
        text_reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_reviews.setVisibility(View.VISIBLE);
                view_details.setVisibility(View.GONE);
                view_related.setVisibility(View.GONE);
                linear_details.setVisibility(View.GONE);
                linear_related.setVisibility(View.GONE);
                linear_reviews.setVisibility(View.VISIBLE);
            }
        });
        text_related.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_related.setVisibility(View.VISIBLE);
                view_details.setVisibility(View.GONE);
                view_reviews.setVisibility(View.GONE);
                linear_details.setVisibility(View.GONE);
                linear_related.setVisibility(View.VISIBLE);
                linear_reviews.setVisibility(View.GONE);

            }
        });

        review_models = new ArrayList<>();
        book_models = new ArrayList<>();

        rv_reviews = findViewById(R.id.rv_reviews);
        rv_reviews.setHasFixedSize(true);
        rv_reviews.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        review_models.add(new Review_Model("","Suraj Rathod", "Nice Ambience...great school to get admission"));
        review_models.add(new Review_Model("","Suraj Rathod", "Nice Ambience...great school to get admission"));
        review_models.add(new Review_Model("","Suraj Rathod", "Nice Ambience...great school to get admission"));
        review_models.add(new Review_Model("","Suraj Rathod", "Nice Ambience...great school to get admission"));
        review_models.add(new Review_Model("","Suraj Rathod", "Nice Ambience...great school to get admission"));
        review_adapter = new Review_Adapter(this,review_models);
        rv_reviews.setAdapter(review_adapter);

        rv_books = findViewById(R.id.rv_books);
        rv_books.setHasFixedSize(true);
        rv_books.setLayoutManager(new GridLayoutManager(BookDetyails_Activity.this,3));
        book_models.add(new Book_Model(R.drawable.book_1,"Nuclear Physics","by Priyanka Jangid","Publishers","750","4.6"));
        book_models.add(new Book_Model(R.drawable.book_2,"ISC Chemistry","by Sannkish Devo","Publishers","850","5.0"));
        book_models.add(new Book_Model(R.drawable.book_3,"Applied Biology","by Priyanka Jangid","Publishers","900","4.8"));
        book_models.add(new Book_Model(R.drawable.book_1,"Nuclear Physics","by Sannkish Devo","Publishers","850","4.2"));
        book_models.add(new Book_Model(R.drawable.book_1,"Nuclear Physics","by Priyanka Jangid","Publishers","750","4.6"));
        book_models.add(new Book_Model(R.drawable.book_2,"ISC Chemistry","by Sannkish Devo","Publishers","850","5.0"));
        book_models.add(new Book_Model(R.drawable.book_3,"Applied Biology","by Priyanka Jangid","Publishers","900","4.8"));
        book_models.add(new Book_Model(R.drawable.book_1,"Nuclear Physics","by Sannkish Devo","Publishers","850","4.2"));
        book_adapter = new Book_Adapter(BookDetyails_Activity.this,book_models);
        rv_books.setAdapter(book_adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(BookDetyails_Activity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}