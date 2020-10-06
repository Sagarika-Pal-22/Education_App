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

import com.example.education_app.Adapter.Exam_Adapter;
import com.example.education_app.Model.Exam_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class ExamSchedule_Fragment extends Fragment {

    RecyclerView rv_upcoming;
    List<Exam_Model> upcoming_exam;
    Exam_Adapter exam_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exam_schedule,container,false);

        upcoming_exam = new ArrayList<>();

        rv_upcoming = view.findViewById(R.id.rv_upcoming);
        rv_upcoming.setHasFixedSize(true);
        rv_upcoming.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        upcoming_exam.add(new Exam_Model("English","Starts on 20 Sep, 2020","Comprehension","","class test"));
        upcoming_exam.add(new Exam_Model("Mathematics","Starts on 22 Sep, 2020","Algebra & Trigonometry","","class test"));
        exam_adapter = new Exam_Adapter(getActivity(),upcoming_exam);
        rv_upcoming.setAdapter(exam_adapter);

        return view;
    }
}
