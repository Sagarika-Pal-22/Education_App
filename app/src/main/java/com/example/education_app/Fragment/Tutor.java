package com.example.education_app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.education_app.Adapter.CityWiseTutor_Adapter;
import com.example.education_app.Adapter.Faculty_Adapter;
import com.example.education_app.ApplyTutor_Activity;
import com.example.education_app.Model.CityWiseTutor_Model;
import com.example.education_app.Model.Faculty_Model;
import com.example.education_app.R;
import java.util.ArrayList;
import java.util.List;

public class Tutor extends Fragment {

    RecyclerView rv_faculty,rv_cityWise;
    List<Faculty_Model> faculty_models;
    Faculty_Adapter faculty_adapter;
    List<CityWiseTutor_Model> cityWiseTutor_models;
    CityWiseTutor_Adapter cityWiseTutor_adapter;

    CardView apply_tutor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutor,container,false);

        apply_tutor = view.findViewById(R.id.apply_tutor);

        faculty_models =new ArrayList<>();
        cityWiseTutor_models = new ArrayList<>();

        apply_tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ApplyTutor_Activity.class));
            }
        });

        rv_faculty = view.findViewById(R.id.rv_faculty);
        rv_faculty.setHasFixedSize(true);
        rv_faculty.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_adapter = new Faculty_Adapter(getActivity(),faculty_models);
        rv_faculty.setAdapter(faculty_adapter);

        rv_cityWise = view.findViewById(R.id.rv_cityWise);
        rv_cityWise.setHasFixedSize(true);
        rv_cityWise.setLayoutManager(new GridLayoutManager(getActivity(),2));
        cityWiseTutor_models.add(new CityWiseTutor_Model("","Ajay Dixit","Kolkata","English"));
        cityWiseTutor_models.add(new CityWiseTutor_Model("","Rahul Jain","Kolkata","History"));
        cityWiseTutor_models.add(new CityWiseTutor_Model("","Raima Kumari","Kolkata","Physics"));
        cityWiseTutor_models.add(new CityWiseTutor_Model("","Rahul Jain","Kolkata","History"));
        cityWiseTutor_adapter = new CityWiseTutor_Adapter(getActivity(),cityWiseTutor_models);
        rv_cityWise.setAdapter(cityWiseTutor_adapter);


        return view;
    }
}
