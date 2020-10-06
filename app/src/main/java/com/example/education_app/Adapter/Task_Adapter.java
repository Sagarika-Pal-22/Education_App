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
import com.example.education_app.Model.Task_Model;
import com.example.education_app.R;

import java.util.List;

public class Task_Adapter extends RecyclerView.Adapter<Task_Adapter.MyViewHolder> {

    Context context;
    List<Task_Model> task_models;

    public Task_Adapter(Context context, List<Task_Model> task_models) {
        this.context = context;
        this.task_models = task_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_task, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.srl_no.setText(task_models.get(position).getSrl_no());
        holder.text_question.setText(task_models.get(position).getText_question());

    }

    @Override
    public int getItemCount() {
        return task_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView srl_no,text_question;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            srl_no = itemView.findViewById(R.id.srl_no);
            text_question = itemView.findViewById(R.id.text_question);
        }
    }

}
