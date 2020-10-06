package com.example.education_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.SchoolTask_Model;
import com.example.education_app.NewTask_Activity;
import com.example.education_app.R;

import java.util.List;

public class SchoolTask_Adapter extends RecyclerView.Adapter<SchoolTask_Adapter.MyViewHolder> {

    Context context;
    List<SchoolTask_Model> schoolTask_models;

    public SchoolTask_Adapter(Context context, List<SchoolTask_Model> schoolTask_models) {
        this.context = context;
        this.schoolTask_models = schoolTask_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_new_task, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.task_type.setText(schoolTask_models.get(position).getTask_type());
        holder.subj_tchr.setText(schoolTask_models.get(position).getSubj_tchr());
        holder.subj_name.setText(schoolTask_models.get(position).getSubj_name());
//        holder.assgn_date.setText(schoolTask_models.get(position).getAssgn_date());
//        holder.sbmsn_date.setText(schoolTask_models.get(position).getSbmsn_date());

        holder.text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, NewTask_Activity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return schoolTask_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView task_type,subj_tchr,subj_name,assgn_date,sbmsn_date;
        TextView text_view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            task_type = itemView.findViewById(R.id.task_type);
            subj_tchr = itemView.findViewById(R.id.subj_tchr);
            subj_name = itemView.findViewById(R.id.subj_name);
//            assgn_date = itemView.findViewById(R.id.assgn_date);
//            sbmsn_date = itemView.findViewById(R.id.sbmsn_date);
            text_view = itemView.findViewById(R.id.text_view);
        }
    }
}
