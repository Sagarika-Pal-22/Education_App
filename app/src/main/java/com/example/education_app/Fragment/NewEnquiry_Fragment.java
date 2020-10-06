package com.example.education_app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Adapter.CityWiseTutor_Adapter;
import com.example.education_app.Model.CityWiseTutor_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class NewEnquiry_Fragment extends Fragment {

    RecyclerView rv_allStudents;
    List<CityWiseTutor_Model> cityWiseTutor_models;
    CityWiseTutor_Adapter cityWiseTutor_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_enquiry,container,false);

        cityWiseTutor_models = new ArrayList<>();

        rv_allStudents = view.findViewById(R.id.rv_allStudents);
        rv_allStudents.setHasFixedSize(true);
        rv_allStudents.setLayoutManager(new GridLayoutManager(getActivity(),2));
        cityWiseTutor_models.add(new CityWiseTutor_Model("","Ajay Dixit","Kolkata",""));
        cityWiseTutor_models.add(new CityWiseTutor_Model("","Rahul Jain","Kolkata",""));
        cityWiseTutor_models.add(new CityWiseTutor_Model("","Raima Kumari","Kolkata",""));
        cityWiseTutor_models.add(new CityWiseTutor_Model("","Rahul Jain","Kolkata",""));
        cityWiseTutor_adapter = new CityWiseTutor_Adapter(getActivity(),cityWiseTutor_models);
        rv_allStudents.setAdapter(cityWiseTutor_adapter);

        return view;
    }
}
