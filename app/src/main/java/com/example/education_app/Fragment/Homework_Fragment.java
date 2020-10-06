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

import com.example.education_app.Adapter.SchoolTask_Adapter;
import com.example.education_app.Model.SchoolTask_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class Homework_Fragment extends Fragment {

    RecyclerView rv_newTask;
    List<SchoolTask_Model> schoolTask_models;
    SchoolTask_Adapter schoolTask_adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homework,container,false);

        schoolTask_models = new ArrayList<>();

        rv_newTask =view.findViewById(R.id.rv_newTask);
        rv_newTask.setHasFixedSize(true);
        rv_newTask.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        schoolTask_models.add(new SchoolTask_Model("Assignment 2","By Sudeshna Lata","Maths","08-09-2020","10-09-2020"));
        schoolTask_models.add(new SchoolTask_Model("Homework 3","By Sudeshna Lata","Maths","08-09-2020","09-09-2020"));
        schoolTask_adapter = new SchoolTask_Adapter(getActivity(), schoolTask_models);
        rv_newTask.setAdapter(schoolTask_adapter);

        return view;
    }

}
