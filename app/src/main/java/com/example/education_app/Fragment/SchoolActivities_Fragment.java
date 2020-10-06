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

import com.example.education_app.Adapter.SchoolActivity_Adapter;
import com.example.education_app.Model.SchoolActivity_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class SchoolActivities_Fragment extends Fragment {

    RecyclerView rv_school_activity;
    List<SchoolActivity_Model> schoolActivity_modelList;
    SchoolActivity_Adapter schoolActivity_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_school_activties,container,false);

        schoolActivity_modelList = new ArrayList<>();

//        rv_school_activity = view.findViewById(R.id.rv_school_activity);
//        rv_school_activity.setHasFixedSize(true);
//        rv_school_activity.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
//        schoolActivity_modelList.add(new SchoolActivity_Model("","Karate","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));
//        schoolActivity_modelList.add(new SchoolActivity_Model("","Yoga","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));
//        schoolActivity_modelList.add(new SchoolActivity_Model("","Bharatnatyam","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));
//        schoolActivity_modelList.add(new SchoolActivity_Model("","Drawing","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));
//        schoolActivity_adapter = new SchoolActivity_Adapter(getActivity(),schoolActivity_modelList);
//        rv_school_activity.setAdapter(schoolActivity_adapter);

        return view;
    }
}
