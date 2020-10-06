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

import com.example.education_app.Adapter.TrackOrder_Adapter;
import com.example.education_app.Model.TrackOrder_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class TrackOrderFragment extends Fragment {

    RecyclerView rv_orderTrack;
    List<TrackOrder_Model> trackOrder_models;
    TrackOrder_Adapter trackOrder_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_track_order,container,false);

        trackOrder_models = new ArrayList<>();

        rv_orderTrack = root.findViewById(R.id.rv_orderTrack);
        rv_orderTrack.setHasFixedSize(true);
        rv_orderTrack.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        trackOrder_models.add(new TrackOrder_Model("","Arriving Thu, 10 Sep","Not yet dispatched"));
        trackOrder_models.add(new TrackOrder_Model("","ZEONELY MART Transparent Hand Gloves","Delivered 15-Aug-2020"));
        trackOrder_adapter = new TrackOrder_Adapter(getActivity(),trackOrder_models);
        rv_orderTrack.setAdapter(trackOrder_adapter);
        return  root;
    }
}
