package com.example.education_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.SchoolActivity_Model;
import com.example.education_app.R;

import java.util.List;

public class SchoolActivity_Adapter extends RecyclerView.Adapter<SchoolActivity_Adapter.MyViewHolder> {

    Context context;
    List<SchoolActivity_Model> schoolActivity_models;

    public SchoolActivity_Adapter(Context context, List<SchoolActivity_Model> schoolActivity_models) {
        this.context = context;
        this.schoolActivity_models = schoolActivity_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_school_activity, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.activity_name.setText(schoolActivity_models.get(position).getActivity_name());
        holder.img_activity.setImageResource(schoolActivity_models.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return schoolActivity_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_activity;
        TextView activity_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_activity = itemView.findViewById(R.id.img_activity);
            activity_name = itemView.findViewById(R.id.activity_name);

        }
    }
}
