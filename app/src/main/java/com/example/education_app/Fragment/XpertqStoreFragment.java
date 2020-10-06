package com.example.education_app.Fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Adapter.Clothes_Adapter;
import com.example.education_app.Adapter.Facility_Adapter;
import com.example.education_app.Adapter.Faculty_Adapter;
import com.example.education_app.Adapter.Next_Adapter;
import com.example.education_app.Model.Clothes_Model;
import com.example.education_app.Model.Faculty_Model;
import com.example.education_app.Model.Next_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class XpertqStoreFragment extends Fragment{

    RecyclerView rv_dress,rv_category,rv_acssrs_cat,rv_acssrs,rv_foot_cat,rv_footwear;
    List<Clothes_Model> clothes_models;
    List<Clothes_Model> productList;
    List<Clothes_Model> footwear;
    List<Faculty_Model> clothesList;
    List<Faculty_Model> accsrsList;
    List<Faculty_Model> footwearList;
    Clothes_Adapter clothes_adapter;
    Faculty_Adapter faculty_adapter;

    TextView clothes,accessories,shoes;
    LinearLayout linear_clothes,linear_accessories,linear_footwear;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_xpertq_store,container,false);

        clothes = root.findViewById(R.id.clothes);
        accessories = root.findViewById(R.id.accessories);
        shoes = root.findViewById(R.id.shoes);
        linear_clothes = root.findViewById(R.id.linear_clothes);
        linear_accessories = root.findViewById(R.id.linear_accessories);
        linear_footwear = root.findViewById(R.id.linear_footwear);


        clothes_models = new ArrayList<>();
        clothesList = new ArrayList<>();
        accsrsList = new ArrayList<>();
        productList = new ArrayList<>();
        footwearList = new ArrayList<>();
        footwear = new ArrayList<>();

        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clothes.setBackground(getResources().getDrawable(R.drawable.gradient));
                clothes.setTextColor(getResources().getColor(R.color.colorWhite));
                accessories.setTextColor(getResources().getColor(R.color.colorPrimary));
                shoes.setTextColor(getResources().getColor(R.color.colorPrimary));
                accessories.setBackground(null);
                shoes.setBackground(null);
                linear_clothes.setVisibility(View.VISIBLE);
                linear_accessories.setVisibility(View.GONE);
                linear_footwear.setVisibility(View.GONE);
            }
        });
        accessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clothes.setBackground(null);
                shoes.setBackground(null);
                clothes.setTextColor(getResources().getColor(R.color.colorPrimary));
                shoes.setTextColor(getResources().getColor(R.color.colorPrimary));
                accessories.setBackground(getResources().getDrawable(R.drawable.gradient));
                accessories.setTextColor(getResources().getColor(R.color.colorWhite));
                linear_clothes.setVisibility(View.GONE);
                linear_accessories.setVisibility(View.VISIBLE);
                linear_footwear.setVisibility(View.GONE);
            }
        });
        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clothes.setBackground(null);
                accessories.setBackground(null);
                clothes.setTextColor(getResources().getColor(R.color.colorPrimary));
                accessories.setTextColor(getResources().getColor(R.color.colorPrimary));
                shoes.setBackground(getResources().getDrawable(R.drawable.gradient));
                shoes.setTextColor(getResources().getColor(R.color.colorWhite));
                linear_clothes.setVisibility(View.GONE);
                linear_accessories.setVisibility(View.GONE);
                linear_footwear.setVisibility(View.VISIBLE);

            }
        });

        rv_dress = root.findViewById(R.id.rv_dress);
        rv_dress.setHasFixedSize(true);
        rv_dress.setLayoutManager(new GridLayoutManager(getActivity(),2));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_4,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_2,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_4,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_2,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_4,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_2,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_4,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        clothes_models.add(new Clothes_Model(R.drawable.cloth_2,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        clothes_adapter = new Clothes_Adapter(getActivity(),clothes_models);
        rv_dress.setAdapter(clothes_adapter);

        rv_category = root.findViewById(R.id.rv_category);
        rv_category.setHasFixedSize(true);
        rv_category.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        clothesList.add(new Faculty_Model(R.drawable.men,"Men's Fashion"));
        clothesList.add(new Faculty_Model(R.drawable.women,"Women's Fashion"));
        clothesList.add(new Faculty_Model(R.drawable.kids,"Kid's Fashion"));
        clothesList.add(new Faculty_Model(R.drawable.cloth_4,"Others"));
        faculty_adapter = new Faculty_Adapter(getActivity(),clothesList);
        rv_category.setAdapter(faculty_adapter);

        rv_acssrs_cat = root.findViewById(R.id.rv_acssrs_cat);
        rv_acssrs_cat.setHasFixedSize(true);
        rv_acssrs_cat.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        accsrsList.add(new Faculty_Model(R.drawable.bag_2,"Bags"));
        accsrsList.add(new Faculty_Model(R.drawable.copy_3,"Notebook"));
        accsrsList.add(new Faculty_Model(R.drawable.pen_3,"Pens"));
        accsrsList.add(new Faculty_Model(R.drawable.case_1,"Pencil case"));
        accsrsList.add(new Faculty_Model(R.drawable.bottle_2,"Water Bottles"));
        accsrsList.add(new Faculty_Model(R.drawable.add,"Others"));
        faculty_adapter = new Faculty_Adapter(getActivity(),accsrsList);
        rv_acssrs_cat.setAdapter(faculty_adapter);

        rv_acssrs = root.findViewById(R.id.rv_acssrs);
        rv_acssrs.setHasFixedSize(true);
        rv_acssrs.setLayoutManager(new GridLayoutManager(getActivity(),2));
        productList.add(new Clothes_Model(R.drawable.bottle_1,"Set of 4 combo bottles","4.5","450","550","10% off"));
        productList.add(new Clothes_Model(R.drawable.bag_1,"Pink and Black ladies bag","4.2","500","600","10% off"));
        productList.add(new Clothes_Model(R.drawable.case_1,"All in one pencil case","4.5","450","550","10% off"));
        productList.add(new Clothes_Model(R.drawable.copy_1,"Set of 4 combo bottles","4.2","500","600","10% off"));
        productList.add(new Clothes_Model(R.drawable.bag_2,"Pink and Black ladies bag","4.5","450","550","10% off"));
        productList.add(new Clothes_Model(R.drawable.pen_2,"All in one pencil case","4.2","500","600","10% off"));
        productList.add(new Clothes_Model(R.drawable.scale_1,"Set of 4 combo bottles","4.5","450","550","10% off"));
        productList.add(new Clothes_Model(R.drawable.copy_2,"All in one pencil case","4.2","500","600","10% off"));
        productList.add(new Clothes_Model(R.drawable.pen_1,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        productList.add(new Clothes_Model(R.drawable.scale_2,"Pink and Black ladies bag","4.2","500","600","10% off"));
        productList.add(new Clothes_Model(R.drawable.bottle_2,"Set of 4 combo bottles","4.2","500","600","10% off"));
        clothes_adapter = new Clothes_Adapter(getActivity(),productList);
        rv_acssrs.setAdapter(clothes_adapter);

        rv_foot_cat = root.findViewById(R.id.rv_foot_cat);
        rv_foot_cat.setHasFixedSize(true);
        rv_foot_cat.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        footwearList.add(new Faculty_Model(R.drawable.shoe_1,"Shoes"));
        footwearList.add(new Faculty_Model(R.drawable.socks_1,"Socks"));
        footwearList.add(new Faculty_Model(R.drawable.socks_3,"Stockings"));
        footwearList.add(new Faculty_Model(R.drawable.shoe_3,"Cobb hills"));
        footwearList.add(new Faculty_Model(R.drawable.add,"Others"));
        faculty_adapter = new Faculty_Adapter(getActivity(),footwearList);
        rv_foot_cat.setAdapter(faculty_adapter);

        rv_footwear = root.findViewById(R.id.rv_footwear);
        rv_footwear.setHasFixedSize(true);
        rv_footwear.setLayoutManager(new GridLayoutManager(getActivity(),2));
        footwear.add(new Clothes_Model(R.drawable.shoe_2,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        footwear.add(new Clothes_Model(R.drawable.shoe_3,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        footwear.add(new Clothes_Model(R.drawable.socks_2,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        footwear.add(new Clothes_Model(R.drawable.socks_3,"Red skirt Gray coat Girls","4.2","500","600","10% off"));
        footwear.add(new Clothes_Model(R.drawable.shoe_1,"Gray and Blue Trouser School wear","4.5","450","550","10% off"));
        clothes_adapter = new Clothes_Adapter(getActivity(),footwear);
        rv_footwear.setAdapter(clothes_adapter);

        return root;
    }
}