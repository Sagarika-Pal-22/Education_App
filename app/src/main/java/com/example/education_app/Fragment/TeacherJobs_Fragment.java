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

import com.example.education_app.Adapter.JobDetailsAdapter;
import com.example.education_app.Model.JobDetailsModel;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class TeacherJobs_Fragment extends Fragment {

    RecyclerView recycle_jobs_details;
    JobDetailsAdapter jobDetailsAdapter;
    List<JobDetailsModel> jobDetailsModels;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_jobs,container,false);

        jobDetailsModels=new ArrayList<>();

        recycle_jobs_details = view.findViewById(R.id.recycle_jobs_details);
        recycle_jobs_details.setHasFixedSize(true);
        recycle_jobs_details.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        jobDetailsModels.add(new JobDetailsModel("","","Home based Physics Coaching","20,000/-","Full Time","Mukundupur","Kolkata","700052","WB",""));
        jobDetailsModels.add(new JobDetailsModel("","","Home based Physics Coaching","20,000/-","Full Time","Mukundupur","Kolkata","700052","WB",""));
        jobDetailsModels.add(new JobDetailsModel("","","Home based Physics Coaching","20,000/-","Full Time","Mukundupur","Kolkata","700052","WB",""));
        jobDetailsModels.add(new JobDetailsModel("","","Home based Physics Coaching","20,000/-","Full Time","Mukundupur","Kolkata","700052","WB",""));
        jobDetailsAdapter = new JobDetailsAdapter(getActivity(),jobDetailsModels);
        recycle_jobs_details.setAdapter(jobDetailsAdapter);

        return view;
    }
}
