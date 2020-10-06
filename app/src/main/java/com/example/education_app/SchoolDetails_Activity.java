package com.example.education_app;

import android.content.Intent;
import android.os.Bundle;

import com.example.education_app.Adapter.Award_Adapter;
import com.example.education_app.Adapter.Cities_Adapter;
import com.example.education_app.Adapter.Facility_Adapter;
import com.example.education_app.Adapter.Faculty_Adapter;
import com.example.education_app.Adapter.Review_Adapter;
import com.example.education_app.Adapter.ViewPagerAdapter;
import com.example.education_app.Model.Award_Model;
import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Facility_Model;
import com.example.education_app.Model.Faculty_Model;
import com.example.education_app.Model.Review_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class SchoolDetails_Activity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int slideImages[];
    private static int currentPage=0;
    private static int numPages=0;

    TextView text_overview,text_facilities,text_reviews;
    View view_overview,view_facilities,view_reviews;
    LinearLayout linear_overview,linear_facilities,linear_reviews;
    Button btn_admission,aply_submit;
    EditText first_name,last_name,edit_mobile,email;
    CardView card_admission;

    RecyclerView rv_facility,rv_reviews,rv_awards,rv_faculty;
    List<Facility_Model> facility_models;
    List<Review_Model> review_models;
    List<Award_Model> award_models;
    List<Faculty_Model> faculty_models;
    Facility_Adapter facility_adapter;
    Review_Adapter review_adapter;
    Faculty_Adapter faculty_adapter;
    Award_Adapter award_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_details_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Narayana School");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPager);
        text_overview = findViewById(R.id.text_overview);
        text_facilities = findViewById(R.id.text_facilities);
        text_reviews = findViewById(R.id.text_reviews);
        view_overview = findViewById(R.id.view_overview);
        view_facilities = findViewById(R.id.view_facilities);
        view_reviews = findViewById(R.id.view_reviews);
        linear_overview = findViewById(R.id.linear_overview);
        linear_facilities = findViewById(R.id.linear_facilities);
        linear_reviews = findViewById(R.id.linear_reviews);
        btn_admission = findViewById(R.id.btn_admission);
        aply_submit = findViewById(R.id.aply_submit);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        edit_mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);
        card_admission = findViewById(R.id.card_admission);

        facility_models = new ArrayList<>();
        review_models = new ArrayList<>();
        award_models = new ArrayList<>();
        faculty_models =new ArrayList<>();

        slideImages = new int[]{R.drawable.schl_1, R.drawable.sch_2, R.drawable.sch_3, R.drawable.awards};
        viewPagerAdapter =new ViewPagerAdapter(this,slideImages);
        viewPager.setAdapter(viewPagerAdapter);

        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                        viewPager.setCurrentItem(pagecount - 1, false);
                    } else if (currentPage == pagecount - 1) {
                        viewPager.setCurrentItem(0, false);
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
                viewPager.setCurrentItem(currentPage++,true);
            }
        };
        Timer swipe = new Timer();
        swipe.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },1000,1000);

        text_overview.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        view_overview.setVisibility(View.VISIBLE);

        text_overview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_overview.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_overview.setVisibility(View.VISIBLE);
                text_facilities.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_facilities.setVisibility(View.GONE);
                text_reviews.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_reviews.setVisibility(View.GONE);
                linear_overview.setVisibility(View.VISIBLE);
                linear_facilities.setVisibility(View.GONE);
                linear_reviews.setVisibility(View.GONE);
            }
        });
        text_facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_facilities.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_facilities.setVisibility(View.VISIBLE);
                text_overview.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_overview.setVisibility(View.GONE);
                text_reviews.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_reviews.setVisibility(View.GONE);
                linear_overview.setVisibility(View.GONE);
                linear_reviews.setVisibility(View.GONE);
                linear_facilities.setVisibility(View.VISIBLE);

            }
        });
        text_reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_reviews.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_reviews.setVisibility(View.VISIBLE);
                text_overview.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_overview.setVisibility(View.GONE);
                text_facilities.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_facilities.setVisibility(View.GONE);
                linear_overview.setVisibility(View.GONE);
                linear_facilities.setVisibility(View.GONE);
                linear_reviews.setVisibility(View.VISIBLE);
            }
        });

        btn_admission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SchoolDetails_Activity.this,Admission_Activity.class));
            }
        });

        rv_facility =findViewById(R.id.rv_facility);
        rv_facility.setHasFixedSize(true);
        rv_facility.setLayoutManager(new GridLayoutManager(this,2));
        facility_models.add(new Facility_Model("Free Wifi"));
        facility_models.add(new Facility_Model("CCTV Cameras"));
        facility_models.add(new Facility_Model("Reception"));
        facility_models.add(new Facility_Model("School Bus"));
        facility_models.add(new Facility_Model("Computer Lab"));
        facility_models.add(new Facility_Model("First Aid"));
        facility_models.add(new Facility_Model("Security"));
        facility_models.add(new Facility_Model("Toilets"));
        facility_models.add(new Facility_Model("Fire Extinguisher"));
        facility_models.add(new Facility_Model("Fire Alarm"));
        facility_models.add(new Facility_Model("Air Conditioned classrooms"));
        facility_models.add(new Facility_Model("Water Purifier"));
        facility_models.add(new Facility_Model("Nice Sitting Arrangements"));
        facility_models.add(new Facility_Model("Playground"));
        facility_models.add(new Facility_Model("Library and Study rooms"));
        facility_models.add(new Facility_Model("Canteen"));
        facility_models.add(new Facility_Model("Hall rooms"));
        facility_adapter = new Facility_Adapter(this,facility_models);
        rv_facility.setAdapter(facility_adapter);

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

        rv_awards = findViewById(R.id.rv_awards);
        rv_awards.setHasFixedSize(true);
        rv_awards.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_adapter = new Award_Adapter(this,award_models);
        rv_awards.setAdapter(award_adapter);

        rv_faculty = findViewById(R.id.rv_faculty);
        rv_faculty.setHasFixedSize(true);
        rv_faculty.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_adapter = new Faculty_Adapter(this,faculty_models);
        rv_faculty.setAdapter(faculty_adapter);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(SchoolDetails_Activity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}