package com.example.education_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Facility_Model;
import com.example.education_app.R;

import java.util.List;

public class Facility_Adapter extends RecyclerView.Adapter<Facility_Adapter.MyViewHolder> {

    Context context;
    List<Facility_Model> facility_models;

    public Facility_Adapter(Context context, List<Facility_Model> facility_models) {
        this.context = context;
        this.facility_models = facility_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_facility, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_facilities.setText(facility_models.get(position).getText_facilities());
    }

    @Override
    public int getItemCount() {
        return facility_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_facilities;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_facilities = itemView.findViewById(R.id.text_facilities);
        }
    }
}
