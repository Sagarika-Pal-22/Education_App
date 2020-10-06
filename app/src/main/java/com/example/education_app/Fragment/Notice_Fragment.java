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

import com.example.education_app.Adapter.Notice_Adapter;
import com.example.education_app.Model.Notice_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class Notice_Fragment extends Fragment {

    RecyclerView rv_notice;
    List<Notice_Model> notice_models;
    Notice_Adapter notice_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice,container,false);

        notice_models = new ArrayList<>();

        rv_notice = view.findViewById(R.id.rv_notice);
        rv_notice.setHasFixedSize(true);
        rv_notice.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        notice_models.add(new Notice_Model("Image","Hola School","2h ago","Dear Parents/Guardian as informed earlier the Annual Day function of the School will be held on 10th Sep 2020 for classes Pre-Nursery to X, at the School Premises",""));
        notice_models.add(new Notice_Model("","Hola School","2h ago","Parent Teacher Meeting will be held on this Friday",""));
        notice_models.add(new Notice_Model("","Hola School","1d ago","Plantation programme will be held on 22nd Sep",""));
        notice_adapter = new Notice_Adapter(getActivity(),notice_models);
        rv_notice.setAdapter(notice_adapter);
        return view;
    }
}
