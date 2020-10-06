package com.example.education_app;

import android.content.Intent;
import android.os.Bundle;

import com.example.education_app.Adapter.History_Adapter;
import com.example.education_app.Adapter.MyClass_Adapter;
import com.example.education_app.Adapter.MyExams_Adapter;
import com.example.education_app.Adapter.MyFees_Adapter;
import com.example.education_app.Adapter.MyPerformance_Adapter;
import com.example.education_app.Adapter.MyProfile_Adapter;
import com.example.education_app.Adapter.TransportSystem_Adapter;
import com.example.education_app.Model.Cities_Model;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyTabsActivity extends AppCompatActivity {

    TextView btn_class,btn_perfomance,btn_exams,btn_fees,btn_transport,btn_profile,btn_history;

    RecyclerView rv_myClass,rv_myPerformance,rv_myExams,rv_myFees,rv_transport,rv_myProfile,rv_history;
    List<Cities_Model> myClass_models;
    List<Cities_Model> performance_models;
    List<Cities_Model> myExams_models;
    List<Cities_Model> myFees_models;
    List<Cities_Model> transport_models;
    List<Cities_Model> myProfile_models;
    List<Cities_Model> history_models;
    MyClass_Adapter myClass_adapter;
    MyPerformance_Adapter myPerformance_adapter;
    MyExams_Adapter myExams_adapter;
    MyFees_Adapter myFees_adapter;
    TransportSystem_Adapter transportSystem_adapter;
    MyProfile_Adapter myProfile_adapter;
    History_Adapter history_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_class=findViewById(R.id.btn_class);
        btn_perfomance=findViewById(R.id.btn_perfomance);
        btn_exams=findViewById(R.id.btn_exams);
        btn_fees=findViewById(R.id.btn_fees);
        btn_transport=findViewById(R.id.btn_transport);
        btn_profile=findViewById(R.id.btn_profile);
        btn_history=findViewById(R.id.btn_history);

        myClass_models = new ArrayList<>();
        performance_models = new ArrayList<>();
        myExams_models = new ArrayList<>();
        myFees_models = new ArrayList<>();
        transport_models = new ArrayList<>();
        myProfile_models = new ArrayList<>();
        history_models = new ArrayList<>();

        rv_myClass=findViewById(R.id.rv_myClass);
        rv_myClass.setHasFixedSize(true);
        rv_myClass.setLayoutManager(new GridLayoutManager(MyTabsActivity.this,3));
        myClass_models.add(new Cities_Model(R.drawable.library,"Syllabus"));
        myClass_models.add(new Cities_Model(R.drawable.person,"My Teacher"));
        myClass_models.add(new Cities_Model(R.drawable.rate_tchr,"Class Work"));
        myClass_models.add(new Cities_Model(R.drawable.homework,"Home Work"));
        myClass_models.add(new Cities_Model(R.drawable.e_diary,"Assigned projects"));
        myClass_models.add(new Cities_Model(R.drawable.activities,"Assigned activities"));
        myClass_models.add(new Cities_Model(R.drawable.leaves,"Leaves"));
        myClass_models.add(new Cities_Model(R.drawable.holiday,"Holiday List"));
        myClass_models.add(new Cities_Model(R.drawable.message,"Messages"));
        myClass_models.add(new Cities_Model(R.drawable.notification,"Notification"));
        myClass_models.add(new Cities_Model(R.drawable.notice,"My discussion board"));
        myClass_models.add(new Cities_Model(R.drawable.e_diary,"E-Diary"));
        myClass_models.add(new Cities_Model(R.drawable.live,"LIVE class"));
        myClass_adapter = new MyClass_Adapter(this,myClass_models);
        rv_myClass.setAdapter(myClass_adapter);

        rv_myPerformance = findViewById(R.id.rv_myPerformance);
        rv_myPerformance.setHasFixedSize(true);
        rv_myPerformance.setLayoutManager(new GridLayoutManager(MyTabsActivity.this,3));
        performance_models.add(new Cities_Model(R.drawable.performance_graph,"Students's Performance Graph"));
        performance_models.add(new Cities_Model(R.drawable.other_graph,"Other Activities Graph"));
        performance_models.add(new Cities_Model(R.drawable.progress,"Behavior Pattern"));
        performance_models.add(new Cities_Model(R.drawable.homework,"My Report Card"));
        performance_models.add(new Cities_Model(R.drawable.marksheet,"My Marksheet"));
        performance_models.add(new Cities_Model(R.drawable.leaves,"Attendance"));
        myPerformance_adapter = new MyPerformance_Adapter(this,performance_models);
        rv_myPerformance.setAdapter(myPerformance_adapter);

        rv_myExams = findViewById(R.id.rv_myExams);
        rv_myExams.setHasFixedSize(true);
        rv_myExams.setLayoutManager(new GridLayoutManager(MyTabsActivity.this,3));
        myExams_models.add(new Cities_Model(R.drawable.marksheet,"Exam Schedule"));
        myExams_models.add(new Cities_Model(R.drawable.rate_tchr,"Exam Practice Test"));
        myExams_models.add(new Cities_Model(R.drawable.marksheet,"Unit Test Schedule"));
        myExams_models.add(new Cities_Model(R.drawable.rate_tchr,"Unit Test Practice Paper"));
        myExams_adapter = new MyExams_Adapter(this,myExams_models);
        rv_myExams.setAdapter(myExams_adapter);

        rv_myFees = findViewById(R.id.rv_myFees);
        rv_myFees.setHasFixedSize(true);
        rv_myFees.setLayoutManager(new GridLayoutManager(MyTabsActivity.this,3));
        myFees_models.add(new Cities_Model(R.drawable.fee_structure,"Fee Structure Schedule"));
        myFees_models.add(new Cities_Model(R.drawable.notification,"Fee Notification"));
        myFees_models.add(new Cities_Model(R.drawable.payment,"Online Payment"));
        myFees_models.add(new Cities_Model(R.drawable.leaves,"Payment History"));
        myFees_adapter = new MyFees_Adapter(this,myFees_models);
        rv_myFees.setAdapter(myFees_adapter);

        rv_transport = findViewById(R.id.rv_transport);
        rv_transport.setHasFixedSize(true);
        rv_transport.setLayoutManager(new GridLayoutManager(MyTabsActivity.this,3));
        transport_models.add(new Cities_Model(R.drawable.location,"My Route Details"));
        transport_models.add(new Cities_Model(R.drawable.fee_structure,"Transportation Fee Details"));
        transport_models.add(new Cities_Model(R.drawable.bus_details,"Bus Details"));
        transport_models.add(new Cities_Model(R.drawable.live_track,"LIVE Track my bus"));
        transport_models.add(new Cities_Model(R.drawable.help,"Hit SOS"));
        transportSystem_adapter = new TransportSystem_Adapter(this,transport_models);
        rv_transport.setAdapter(transportSystem_adapter);

        rv_myProfile = findViewById(R.id.rv_myProfile);
        rv_myProfile.setHasFixedSize(true);
        rv_myProfile.setLayoutManager(new GridLayoutManager(MyTabsActivity.this,3));
        myProfile_models.add(new Cities_Model(R.drawable.parents ,"My Parent details"));
        myProfile_models.add(new Cities_Model(R.drawable.person,"My Bio"));
        myProfile_adapter = new MyProfile_Adapter(this,myProfile_models);
        rv_myProfile.setAdapter(myProfile_adapter);

        rv_history = findViewById(R.id.rv_history);
        rv_history.setHasFixedSize(true);
        rv_history.setLayoutManager(new GridLayoutManager(MyTabsActivity.this,3));
        history_models.add(new Cities_Model(R.drawable.payment,"All Payment History"));
        history_models.add(new Cities_Model(R.drawable.timetable,"Product Purchase History"));
        history_models.add(new Cities_Model(R.drawable.payment,"School Payment History"));
        history_models.add(new Cities_Model(R.drawable.help,"Report"));
        history_adapter = new History_Adapter(this,history_models);
        rv_history.setAdapter(history_adapter);

        btn_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_class.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                btn_class.setTextColor(getResources().getColor(R.color.colorWhite));
                btn_perfomance.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_perfomance.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_exams.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_exams.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_history.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_history.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_profile.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_profile.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_fees.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_fees.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_transport.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_transport.setTextColor(getResources().getColor(R.color.colorBlack));
                rv_myClass.setVisibility(View.VISIBLE);
                rv_myPerformance.setVisibility(View.GONE);
                rv_myExams.setVisibility(View.GONE);
                rv_myFees.setVisibility(View.GONE);
                rv_transport.setVisibility(View.GONE);
                rv_myProfile.setVisibility(View.GONE);
                rv_history.setVisibility(View.GONE);
            }
        });
        btn_perfomance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_perfomance.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                btn_perfomance.setTextColor(getResources().getColor(R.color.colorWhite));
                btn_class.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_class.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_history.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_history.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_profile.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_profile.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_fees.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_fees.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_transport.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_transport.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_exams.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_exams.setTextColor(getResources().getColor(R.color.colorBlack));
                rv_myClass.setVisibility(View.GONE);
                rv_myPerformance.setVisibility(View.VISIBLE);
                rv_myExams.setVisibility(View.GONE);
                rv_myFees.setVisibility(View.GONE);
                rv_transport.setVisibility(View.GONE);
                rv_myProfile.setVisibility(View.GONE);
                rv_history.setVisibility(View.GONE);

            }
        });
        btn_exams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_exams.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                btn_exams.setTextColor(getResources().getColor(R.color.colorWhite));
                btn_class.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_class.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_perfomance.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_perfomance.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_history.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_history.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_profile.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_profile.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_fees.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_fees.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_transport.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_transport.setTextColor(getResources().getColor(R.color.colorBlack));
                rv_myClass.setVisibility(View.GONE);
                rv_myPerformance.setVisibility(View.GONE);
                rv_myExams.setVisibility(View.VISIBLE);
                rv_myFees.setVisibility(View.GONE);
                rv_transport.setVisibility(View.GONE);
                rv_myProfile.setVisibility(View.GONE);
                rv_history.setVisibility(View.GONE);
            }
        });
        btn_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_fees.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                btn_fees.setTextColor(getResources().getColor(R.color.colorWhite));
                btn_class.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_class.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_perfomance.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_perfomance.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_history.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_history.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_profile.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_profile.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_transport.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_transport.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_exams.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_exams.setTextColor(getResources().getColor(R.color.colorBlack));
                rv_myClass.setVisibility(View.GONE);
                rv_myPerformance.setVisibility(View.GONE);
                rv_myExams.setVisibility(View.GONE);
                rv_myFees.setVisibility(View.VISIBLE);
                rv_transport.setVisibility(View.GONE);
                rv_myProfile.setVisibility(View.GONE);
                rv_history.setVisibility(View.GONE);
            }
        });
        btn_transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_transport.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                btn_transport.setTextColor(getResources().getColor(R.color.colorWhite));
                btn_class.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_class.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_perfomance.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_perfomance.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_history.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_history.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_profile.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_profile.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_fees.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_fees.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_exams.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_exams.setTextColor(getResources().getColor(R.color.colorBlack));
                rv_myClass.setVisibility(View.GONE);
                rv_myPerformance.setVisibility(View.GONE);
                rv_myExams.setVisibility(View.GONE);
                rv_myFees.setVisibility(View.GONE);
                rv_transport.setVisibility(View.VISIBLE);
                rv_myProfile.setVisibility(View.GONE);
                rv_history.setVisibility(View.GONE);
            }
        });
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_profile.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                btn_profile.setTextColor(getResources().getColor(R.color.colorWhite));
                btn_class.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_class.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_perfomance.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_perfomance.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_history.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_history.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_fees.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_fees.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_transport.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_transport.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_exams.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_exams.setTextColor(getResources().getColor(R.color.colorBlack));
                rv_myClass.setVisibility(View.GONE);
                rv_myPerformance.setVisibility(View.GONE);
                rv_myExams.setVisibility(View.GONE);
                rv_myFees.setVisibility(View.GONE);
                rv_transport.setVisibility(View.GONE);
                rv_myProfile.setVisibility(View.VISIBLE);
                rv_history.setVisibility(View.GONE);
            }
        });
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_history.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                btn_history.setTextColor(getResources().getColor(R.color.colorWhite));
                btn_class.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_class.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_perfomance.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_perfomance.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_profile.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_profile.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_fees.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_fees.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_transport.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_transport.setTextColor(getResources().getColor(R.color.colorBlack));
                btn_exams.setBackgroundColor(getResources().getColor(R.color.greyL));
                btn_exams.setTextColor(getResources().getColor(R.color.colorBlack));
                rv_myClass.setVisibility(View.GONE);
                rv_myPerformance.setVisibility(View.GONE);
                rv_myExams.setVisibility(View.GONE);
                rv_myFees.setVisibility(View.GONE);
                rv_transport.setVisibility(View.GONE);
                rv_myProfile.setVisibility(View.GONE);
                rv_history.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(MyTabsActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}