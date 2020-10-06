package com.example.education_app.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Adapter.AdmissionDetails_Adapter;
import com.example.education_app.Admission_Activity;
import com.example.education_app.Model.AdmissionDetails_Model;
import com.example.education_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AdmissionDetails_Fragment extends Fragment {

    RecyclerView rv_admission_details;
    List<AdmissionDetails_Model> admissionDetails_models;
    AdmissionDetails_Adapter admissionDetails_adapter;

    Button new_admsn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admission_details,container,false);

        new_admsn = view.findViewById(R.id.new_admsn);

        new_admsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                final View dialogView = inflater.inflate(R.layout.dialog_new_admission, null);
                final TextView date= dialogView.findViewById(R.id.date);
                final BetterSpinner spin_class = dialogView.findViewById(R.id.spin_class);
                Button btn_cancel= dialogView.findViewById(R.id.btn_cancel);
                builder.setView(dialogView);
                final AlertDialog alert = builder.create();
                alert.setCanceledOnTouchOutside(true);
                alert.show();

                String[] classes = {"Nursery","LKG","UKG","1","2","3","4","5","6","7","8","9","10","11","12"};
                ArrayAdapter<String> arrayAdapter_1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, classes);
                spin_class.setAdapter(arrayAdapter_1);

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
                        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
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

        admissionDetails_models = new ArrayList<>();
        rv_admission_details =view.findViewById(R.id.rv_admission_details);
        rv_admission_details.setHasFixedSize(true);
        rv_admission_details.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        admissionDetails_models.add(new AdmissionDetails_Model("2015-2017","8th Standard","06 Jul 2015","5000/-"));
        admissionDetails_models.add(new AdmissionDetails_Model("2017-2019","9th Standard","16 Jul 2017","6000/-"));
        admissionDetails_models.add(new AdmissionDetails_Model("2019-2021","10th Standard","08 Aug 2019","8000/-"));
        admissionDetails_adapter = new AdmissionDetails_Adapter(getActivity(),admissionDetails_models);
        rv_admission_details.setAdapter(admissionDetails_adapter);
        return view;

    }
}
