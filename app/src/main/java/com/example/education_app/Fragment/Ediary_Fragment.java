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

import com.example.education_app.Adapter.Received_Ediary_Adapter;
import com.example.education_app.Model.Ediary_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class Ediary_Fragment extends Fragment {

    RecyclerView rv_received;
    List<Ediary_Model> ediary_models;
    Received_Ediary_Adapter received_ediary_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edairy,container,false);

        ediary_models = new ArrayList<>();
        rv_received =view.findViewById(R.id.rv_received);
        rv_received.setHasFixedSize(true);
        rv_received.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        ediary_models.add(new Ediary_Model("Complaint against Student","Tuhina Das (English teacher)","It’s the conversation we all dread: telling a parent their child a) is failing a subject, b) needs to be tested for a disability, c) doesn’t have any friends. So you are requested to have a lookin this matter for the sake of your daughter's future...Thank you.","12:05pm"));
        ediary_models.add(new Ediary_Model("Complaint against Student","Tuhina Das (English teacher)"," So you are requested to have a lookin this matter for the sake of your daughter's future...Thank you.","12:05pm"));
        received_ediary_adapter = new Received_Ediary_Adapter(getActivity(),ediary_models);
        rv_received.setAdapter(received_ediary_adapter);
        return view;
    }
}
