package com.example.education_app;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;

import com.example.education_app.Adapter.Communication_Adapter;
import com.example.education_app.Model.Communication_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EDiary_Activity extends AppCompatActivity {

    RecyclerView rv_communication;
    List<Communication_Model> communication_models;
    Communication_Adapter communication_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_diary_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EDiary_Activity.this);
                LayoutInflater inflater = LayoutInflater.from(EDiary_Activity.this);
                final View dialogView = inflater.inflate(R.layout.dialog_write_message, null);
                final BetterSpinner spin_teacher = dialogView.findViewById(R.id.spin_teacher);
                String[] teacher = {"Principal","Class Teacher","Rounik Adhikary","Kumush Gupta","Rani Mam"};
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(EDiary_Activity.this, android.R.layout.simple_dropdown_item_1line, teacher);
                spin_teacher.setAdapter(arrayAdapter);
                final EditText edit_message= dialogView.findViewById(R.id.edit_message);
                final TextView date= dialogView.findViewById(R.id.date);
                Button btn_submit= dialogView.findViewById(R.id.btn_submit);
                Button btn_cancel= dialogView.findViewById(R.id.btn_cancel);
                builder.setView(dialogView);
                final AlertDialog alert = builder.create();
                alert.setCanceledOnTouchOutside(true);
                alert.show();
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();

                    }
                });
                date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar mcurrentDate = Calendar.getInstance();

                        int mDay   = mcurrentDate.get(Calendar.DAY_OF_MONTH);
                        int mMonth = mcurrentDate.get(Calendar.MONTH);
                        int mYear  = mcurrentDate.get(Calendar.YEAR);
                        DatePickerDialog datePickerDialog = new DatePickerDialog(EDiary_Activity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                String fmonth, fDate;
                                try {
                                    if (month < 10 && dayOfMonth < 10) {

                                        fmonth = "0" + month;
                                        month = Integer.parseInt(fmonth) + 1;
                                        fDate = "0" + dayOfMonth;
                                        String paddedMonth = String.format("%02d", month);
                                        date.setText(year + "-" + paddedMonth + "-" + fDate);

                                    } else {

                                        fmonth = "0" + month;
                                        month = Integer.parseInt(fmonth) + 1;
                                        String paddedMonth = String.format("%02d", month);
                                        date.setText(year + "-" + paddedMonth + "-" + dayOfMonth);
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, mYear, mMonth, mDay);
                        datePickerDialog.show();
                    }
                });
            }
        });

        communication_models = new ArrayList<>();

        rv_communication = findViewById(R.id.rv_communication);
        rv_communication.setHasFixedSize(true);
        rv_communication.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        communication_models.add(new Communication_Model("","Principal","The parents are cordially..","01 Sep 2020"));
        communication_models.add(new Communication_Model("","Class Teacher","Dear Parents..Please find attached..","01 Sep 2020"));
        communication_adapter = new Communication_Adapter(this,communication_models);
        rv_communication.setAdapter(communication_adapter);
    }
}