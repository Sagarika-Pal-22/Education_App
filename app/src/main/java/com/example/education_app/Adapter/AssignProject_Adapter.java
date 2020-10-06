package com.example.education_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Attendance_Activity;
import com.example.education_app.BehaviorPattern_Activity;
import com.example.education_app.Model.AssignProject_Model;
import com.example.education_app.Model.Cities_Model;
import com.example.education_app.MyReportCard_Activity;
import com.example.education_app.OtherActivityGraph_Activity;
import com.example.education_app.R;
import com.example.education_app.StudentPerformanceGraph_Activity;

import java.util.List;

public class AssignProject_Adapter extends RecyclerView.Adapter<AssignProject_Adapter.MyViewHolder> {

    Context context;
    List<AssignProject_Model> assignProject_models;

    public AssignProject_Adapter(Context context, List<AssignProject_Model> assignProject_models) {
        this.context = context;
        this.assignProject_models = assignProject_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_assign_projects, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.project_name.setText(assignProject_models.get(position).getProject_name());
        holder.subj_tchr.setText(assignProject_models.get(position).getSubj_tchr());
        holder.description.setText(assignProject_models.get(position).getDescription());
        holder.sbmsn_date.setText(assignProject_models.get(position).getSbmsn_date());


    }

    @Override
    public int getItemCount() {
        return assignProject_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView project_name,subj_tchr,description,sbmsn_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            project_name = itemView.findViewById(R.id.project_name);
            subj_tchr = itemView.findViewById(R.id.subj_tchr);
            description = itemView.findViewById(R.id.description);
            sbmsn_date = itemView.findViewById(R.id.sbmsn_date);
        }
    }
}
