package com.example.education_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Award_Model;
import com.example.education_app.R;

import java.util.List;

public class Award_Adapter extends RecyclerView.Adapter<Award_Adapter.MyViewHolder> {

    Context context;
    List<Award_Model> award_models;

    public Award_Adapter(Context context, List<Award_Model> award_models) {
        this.context = context;
        this.award_models = award_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_awards, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return award_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_awards;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_awards = itemView.findViewById(R.id.img_awards);
        }
    }
}
