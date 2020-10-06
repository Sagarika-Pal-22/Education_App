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

import com.example.education_app.Adapter.Timetable_Adapter;
import com.example.education_app.Model.Timetable_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class TimeTable_Fragment extends Fragment {

    RecyclerView rv_timetable;
    List<Timetable_Model> timetable_models;
    Timetable_Adapter timetable_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable,container,false);

        timetable_models = new ArrayList<>();

        rv_timetable = view.findViewById(R.id.rv_timetable);
        rv_timetable.setHasFixedSize(true);
        rv_timetable.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        timetable_models.add(new Timetable_Model("8:00am","8:45am","English Literature","by Anisha Tutlane"));
        timetable_models.add(new Timetable_Model("9:00am","9:45am","Hindi Literature","by Indrajeet Rana"));
        timetable_models.add(new Timetable_Model("10:00am","10:45am","Mathematics","by Anisha Tutlane"));
        timetable_models.add(new Timetable_Model("11:00am","12pm","BreakTime",""));
        timetable_models.add(new Timetable_Model("12:00pm","12:45pm","Social Study","by Indrajeet Rana"));
        timetable_models.add(new Timetable_Model("1:00pm","2:00am","Science","by Abc Sir"));
        timetable_adapter = new Timetable_Adapter(getActivity(),timetable_models);
        rv_timetable.setAdapter(timetable_adapter);
        return view;
    }
}
