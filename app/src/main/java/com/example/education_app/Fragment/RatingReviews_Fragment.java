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

import com.example.education_app.Adapter.TchrRating_Adapter;
import com.example.education_app.Model.TeacherRating_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class RatingReviews_Fragment extends Fragment {

    RecyclerView rv_tchr_rating;
    List<TeacherRating_Model> teacherRating_models;
    TchrRating_Adapter tchrRating_adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rating_review,container,false);

        teacherRating_models = new ArrayList<>();

        rv_tchr_rating = view.findViewById(R.id.rv_tchr_rating);
        rv_tchr_rating.setHasFixedSize(true);
        rv_tchr_rating.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        teacherRating_models.add(new TeacherRating_Model("","Ajay Dixit","English","4.3"));
        teacherRating_models.add(new TeacherRating_Model("","Rahul Jain","History","4.0"));
        teacherRating_models.add(new TeacherRating_Model("","Raima Kumari","Physics","4.5"));
        teacherRating_models.add(new TeacherRating_Model("","Rahul Jain","History","4.0"));
        teacherRating_models.add(new TeacherRating_Model("","Raima Kumari","Physics","4.5"));
        tchrRating_adapter = new TchrRating_Adapter(getActivity(),teacherRating_models);
        rv_tchr_rating.setAdapter(tchrRating_adapter);
        return view;
    }
}
