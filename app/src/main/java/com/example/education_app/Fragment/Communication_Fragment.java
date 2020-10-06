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

import com.example.education_app.Adapter.Communication_Adapter;
import com.example.education_app.Model.Communication_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class Communication_Fragment extends Fragment {

    RecyclerView rv_communication;
    List<Communication_Model> communication_models;
    Communication_Adapter communication_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_communication,container,false);

        communication_models = new ArrayList<>();

        rv_communication = view.findViewById(R.id.rv_communication);
        rv_communication.setHasFixedSize(true);
        rv_communication.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        communication_models.add(new Communication_Model("","Principal","The parents are cordially..","01 Sep 2020"));
        communication_models.add(new Communication_Model("","Class Teacher","Dear Parents..Please find attached..","01 Sep 2020"));
        communication_models.add(new Communication_Model("","English Teacher","Dear Parents..Please find attached..","01 Sep 2020"));
        communication_models.add(new Communication_Model("","Principal","The parents are cordially..","01 Sep 2020"));
        communication_models.add(new Communication_Model("","Class Teacher","Dear Parents..Please find attached..","01 Sep 2020"));
        communication_models.add(new Communication_Model("","English Teacher","Dear Parents..Please find attached..","01 Sep 2020"));
        communication_adapter = new Communication_Adapter(getActivity(),communication_models);
        rv_communication.setAdapter(communication_adapter);

        return view;
    }
}
