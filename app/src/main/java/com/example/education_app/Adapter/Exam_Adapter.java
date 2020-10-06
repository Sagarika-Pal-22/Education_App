package com.example.education_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Exam_Model;
import com.example.education_app.R;

import java.util.List;

public class Exam_Adapter extends RecyclerView.Adapter<Exam_Adapter.MyViewHolder> {

    Context context;
    List<Exam_Model> exam_models;

    public Exam_Adapter(Context context, List<Exam_Model> exam_models) {
        this.context = context;
        this.exam_models = exam_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_exam, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.subj_topic.setText(exam_models.get(position).getSubj_topic());
        holder.exam_date.setText(exam_models.get(position).getExam_date());
        holder.subj_name.setText(exam_models.get(position).getSubj_name());
        holder.test_type.setText(exam_models.get(position).getTest_type());

        int colorRes = 0;
        switch(position % 2) {
            case 0: colorRes = R.color.green;
                break;
            case 1: colorRes = R.color.colour_1;
                break;
        }
        holder.test_type.setBackgroundColor(ContextCompat.getColor(context, colorRes));

    }

    @Override
    public int getItemCount() {
        return exam_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView subj_name,exam_date,subj_topic,test_type;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            subj_name = itemView.findViewById(R.id.subj_name);
            exam_date = itemView.findViewById(R.id.exam_date);
            subj_topic = itemView.findViewById(R.id.subj_topic);
            subj_name = itemView.findViewById(R.id.subj_name);
            test_type = itemView.findViewById(R.id.test_type);
        }
    }
}
