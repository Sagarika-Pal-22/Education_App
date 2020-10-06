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

import com.example.education_app.Adapter.Favourite_Adapter;
import com.example.education_app.Model.Favourite_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class FavouriteFragment extends Fragment {

    RecyclerView rv_favourite;
    List<Favourite_Model> favourite_models;
    Favourite_Adapter favourite_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favourite,container,false);

        favourite_models = new ArrayList<>();

        rv_favourite =root.findViewById(R.id.rv_favourite);
        rv_favourite.setHasFixedSize(true);
        rv_favourite.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        favourite_models.add(new Favourite_Model("","Applied Biology","Ramesh Kantra","Publishers","913"));
        favourite_models.add(new Favourite_Model("","Applied Biology","Ramesh Kantra","Publishers","913"));
        favourite_models.add(new Favourite_Model("","Applied Biology","Ramesh Kantra","Publishers","913"));
        favourite_models.add(new Favourite_Model("","Applied Biology","Ramesh Kantra","Publishers","913"));
        favourite_models.add(new Favourite_Model("","Applied Biology","Ramesh Kantra","Publishers","913"));
        favourite_adapter =new Favourite_Adapter(getActivity(),favourite_models);
        rv_favourite.setAdapter(favourite_adapter);
        return root;


    }
}
