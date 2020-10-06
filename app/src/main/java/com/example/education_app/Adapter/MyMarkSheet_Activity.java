package com.example.education_app.Adapter;

import android.os.Bundle;

import com.example.education_app.Model.Report_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.education_app.R;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.ArrayList;
import java.util.List;

public class MyMarkSheet_Activity extends AppCompatActivity {

    RecyclerView rv_half_yearly,rv_class_test,rv_final_test;
    List<Report_Model> class_test_models,half_yearly_model,final_model;
    Report_Adapter report_adapter;

    TextView class_test,half_yearly,final_exam;
    View view_class_test,view_half_yearly,view_final;
    LinearLayout linear_classTest,linear_halfYearly,linear_final;
    BetterSpinner spin_month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_mark_sheet_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        class_test_models = new ArrayList<>();
        half_yearly_model = new ArrayList<>();
        final_model = new ArrayList<>();

        class_test = findViewById(R.id.class_test);
        half_yearly = findViewById(R.id.half_yearly);
        final_exam = findViewById(R.id.final_exam);
        view_class_test = findViewById(R.id.view_class_test);
        view_half_yearly = findViewById(R.id.view_half_yearly);
        view_final = findViewById(R.id.view_final);
        spin_month = findViewById(R.id.spin_month);
        linear_classTest = findViewById(R.id.linear_classTest);
        linear_halfYearly = findViewById(R.id.linear_halfYearly);
        linear_final = findViewById(R.id.linear_final);

        class_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                class_test.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_class_test.setVisibility(View.VISIBLE);
                half_yearly.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_half_yearly.setVisibility(View.GONE);
                final_exam.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_final.setVisibility(View.GONE);
                linear_classTest.setVisibility(View.VISIBLE);
                linear_halfYearly.setVisibility(View.GONE);
                linear_final.setVisibility(View.GONE);
            }
        });
        half_yearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                half_yearly.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_half_yearly.setVisibility(View.VISIBLE);
                class_test.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_class_test.setVisibility(View.GONE);
                final_exam.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_final.setVisibility(View.GONE);
                linear_classTest.setVisibility(View.GONE);
                linear_final.setVisibility(View.GONE);
                linear_halfYearly.setVisibility(View.VISIBLE);

            }
        });
        final_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final_exam.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_final.setVisibility(View.VISIBLE);
                class_test.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_class_test.setVisibility(View.GONE);
                half_yearly.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_half_yearly.setVisibility(View.GONE);
                linear_halfYearly.setVisibility(View.GONE);
                linear_classTest.setVisibility(View.GONE);
                linear_final.setVisibility(View.VISIBLE);
            }
        });

        String[] month = {"January","February","March","April","May","June"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MyMarkSheet_Activity.this, android.R.layout.simple_dropdown_item_1line, month);
        spin_month.setAdapter(arrayAdapter);

        rv_class_test = findViewById(R.id.rv_class_test);
        rv_class_test.setHasFixedSize(true);
        rv_class_test.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        class_test_models.add(new Report_Model("Bengali","55","60","9","10"));
        class_test_models.add(new Report_Model("English","58","60","10","10"));
        class_test_models.add(new Report_Model("Mathematics","50","60","10","10"));
        class_test_models.add(new Report_Model("Geography","55","60","9","10"));
        class_test_models.add(new Report_Model("Hindi","35","60","9","10"));
        class_test_models.add(new Report_Model("General Knowledge","55","60","9","10"));
        class_test_models.add(new Report_Model("Conversation","18","30","0","0"));
        class_test_models.add(new Report_Model("Computer","55","60","0","0"));
        class_test_models.add(new Report_Model("Drawing","15","20","0","0"));
        class_test_models.add(new Report_Model("Extra Curricular Activities","10","30","0","0"));
        class_test_models.add(new Report_Model("Bratchary","22","25","0","0"));
        report_adapter = new Report_Adapter(this,class_test_models);
        rv_class_test.setAdapter(report_adapter);

        rv_half_yearly = findViewById(R.id.rv_half_yearly);
        rv_half_yearly.setHasFixedSize(true);
        rv_half_yearly.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        half_yearly_model.add(new Report_Model("Bengali","55","60","9","10"));
        half_yearly_model.add(new Report_Model("English","58","60","10","10"));
        half_yearly_model.add(new Report_Model("Mathematics","50","60","10","10"));
        half_yearly_model.add(new Report_Model("Geography","55","60","9","10"));
        half_yearly_model.add(new Report_Model("Hindi","35","60","9","10"));
        half_yearly_model.add(new Report_Model("General Knowledge","55","60","9","10"));
        half_yearly_model.add(new Report_Model("Conversation","18","30","0","0"));
        half_yearly_model.add(new Report_Model("Computer","55","60","0","0"));
        half_yearly_model.add(new Report_Model("Drawing","15","20","0","0"));
        half_yearly_model.add(new Report_Model("Extra Curricular Activities","10","30","0","0"));
        half_yearly_model.add(new Report_Model("Bratchary","22","25","0","0"));
        report_adapter = new Report_Adapter(this,half_yearly_model);
        rv_half_yearly.setAdapter(report_adapter);

        rv_final_test = findViewById(R.id.rv_final_test);
        rv_final_test.setHasFixedSize(true);
        rv_final_test.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        final_model.add(new Report_Model("Bengali","55","60","9","10"));
        final_model.add(new Report_Model("English","58","60","10","10"));
        final_model.add(new Report_Model("Mathematics","50","60","10","10"));
        final_model.add(new Report_Model("Geography","55","60","9","10"));
        final_model.add(new Report_Model("Hindi","35","60","9","10"));
        final_model.add(new Report_Model("General Knowledge","55","60","9","10"));
        final_model.add(new Report_Model("Conversation","18","30","0","0"));
        final_model.add(new Report_Model("Computer","55","60","0","0"));
        final_model.add(new Report_Model("Drawing","15","20","0","0"));
        final_model.add(new Report_Model("Extra Curricular Activities","10","30","0","0"));
        final_model.add(new Report_Model("Bratchary","22","25","0","0"));
        report_adapter = new Report_Adapter(this,final_model);
        rv_final_test.setAdapter(report_adapter);
    }
}