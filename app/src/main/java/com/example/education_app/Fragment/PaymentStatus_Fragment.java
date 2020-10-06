package com.example.education_app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Adapter.Payment_Adapter;
import com.example.education_app.Model.Payment_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class PaymentStatus_Fragment extends Fragment {

    RecyclerView rv_pymnt_hstry;
    List<Payment_Model> payment_models;
    Payment_Adapter payment_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_status,container,false);

        payment_models = new ArrayList<>();

        rv_pymnt_hstry = view.findViewById(R.id.rv_pymnt_hstry);
        rv_pymnt_hstry.setHasFixedSize(true);
        rv_pymnt_hstry.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        payment_models.add(new Payment_Model("21 Apr,2015","Cheque","2 Months Tuition Fees","15000"));
        payment_models.add(new Payment_Model("10 Feb,2015","Cheque","2 Months Tuition Fees","15000"));
        payment_models.add(new Payment_Model("5 Dec,2014","Cheque","2 Months Tuition Fees","15000"));
        payment_adapter = new Payment_Adapter(getActivity(),payment_models);
        rv_pymnt_hstry.setAdapter(payment_adapter);
        return view;
    }
}
