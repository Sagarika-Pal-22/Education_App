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

import com.example.education_app.Adapter.Order_Adapter;
import com.example.education_app.Model.Order_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {

    RecyclerView recycler_order;
    List<Order_Model> order_models;
    Order_Adapter order_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_order,container,false);

        order_models = new ArrayList<>();

        recycler_order = root.findViewById(R.id.recycler_order);
        recycler_order.setHasFixedSize(true);
        recycler_order.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        order_models.add(new Order_Model("","Applied Chemistry","19-Feb-2020"));
        order_models.add(new Order_Model("","Applied Chemistry","01-April-2020"));
        order_models.add(new Order_Model("","Applied Chemistry","05-July-2020"));
        order_adapter = new Order_Adapter(getActivity(),order_models);
        recycler_order.setAdapter(order_adapter);
        return root;
    }
}
