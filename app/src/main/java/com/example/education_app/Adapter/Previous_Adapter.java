package com.example.education_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Previous_Model;
import com.example.education_app.R;
import com.example.education_app.Solution_Activity;

import java.util.List;

public class Previous_Adapter extends RecyclerView.Adapter<Previous_Adapter.MyViewHolder> {

    Context context;
    List<Previous_Model> previous_models;

    public Previous_Adapter(Context context, List<Previous_Model> previous_models) {
        this.context = context;
        this.previous_models = previous_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_previous_task, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.task_type.setText(previous_models.get(position).getTask_type());
        holder.subj_tchr.setText(previous_models.get(position).getSubj_tchr());
        holder.subj_name.setText(previous_models.get(position).getSubj_name());
        holder.assgn_date.setText(previous_models.get(position).getAssgn_date());

        holder.solution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, Solution_Activity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return previous_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView task_type,subj_tchr,subj_name,assgn_date;
        TextView solution;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            task_type = itemView.findViewById(R.id.task_type);
            subj_tchr = itemView.findViewById(R.id.subj_tchr);
            subj_name = itemView.findViewById(R.id.subj_name);
            assgn_date = itemView.findViewById(R.id.assgn_date);
            solution = itemView.findViewById(R.id.solution);

        }
    }
}
