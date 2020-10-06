package com.example.education_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.JobDescriptionActivity;
import com.example.education_app.Model.JobDetailsModel;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class JobDetailsAdapter extends RecyclerView.Adapter<JobDetailsAdapter.MyViewHolder> {

    Context context;
    List<JobDetailsModel> jobDetailsModels = new ArrayList<>();

    public JobDetailsAdapter(Context context, List<JobDetailsModel> jobDetailsModels) {
        this.context = context;
        this.jobDetailsModels = jobDetailsModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.job_details_items, parent,false);
        return new JobDetailsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_name.setText(jobDetailsModels.get(position).getJob_name());
        holder.text_salary.setText(jobDetailsModels.get(position).getSalary());
        holder.job_type.setText(jobDetailsModels.get(position).getPosition_type());
        holder.location.setText(jobDetailsModels.get(position).getAdress()+" ,"+jobDetailsModels.get(position).getCity()+" "
                                           +jobDetailsModels.get(position).getPin());
        holder.text_state.setText(jobDetailsModels.get(position).getState());
        holder.linear_job_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               context.startActivity(new Intent(context, JobDescriptionActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobDetailsModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text_name,text_salary,job_type,location,text_address,text_city,pin,text_state;
        LinearLayout linear_job_details;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text_name = itemView.findViewById(R.id.text_name);
            text_salary = itemView.findViewById(R.id.text_salary);
            job_type = itemView.findViewById(R.id.job_type);
            location = itemView.findViewById(R.id.location);
            text_address = itemView.findViewById(R.id.text_address);
            text_city = itemView.findViewById(R.id.text_city);
            pin = itemView.findViewById(R.id.pin);
            text_state = itemView.findViewById(R.id.text_state);
            linear_job_details = itemView.findViewById(R.id.linear_job_details);
        }
    }
}
