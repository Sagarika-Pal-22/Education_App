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

import com.example.education_app.BookDetyails_Activity;
import com.example.education_app.Model.Book_Model;
import com.example.education_app.Model.Discussion_Model;
import com.example.education_app.R;

import java.util.List;

public class Discussion_Adapter extends RecyclerView.Adapter<Discussion_Adapter.MyViewHolder> {

    Context context;
    List<Discussion_Model> discussion_models;

    public Discussion_Adapter(Context context, List<Discussion_Model> discussion_models) {
        this.context = context;
        this.discussion_models = discussion_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_discussion, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_question.setText(discussion_models.get(position).getText_question());
        holder.text_name.setText(discussion_models.get(position).getText_name());
        holder.text_time.setText(discussion_models.get(position).getText_time());
        holder.problem.setText(discussion_models.get(position).getProblem());
        holder.comments.setText(discussion_models.get(position).getComments());


    }

    @Override
    public int getItemCount() {
        return discussion_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_student;
        TextView text_question,text_name,text_time,problem,comments;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_student = itemView.findViewById(R.id.img_student);
            text_question = itemView.findViewById(R.id.text_question);
            text_name = itemView.findViewById(R.id.text_name);
            text_time = itemView.findViewById(R.id.text_time);
            problem = itemView.findViewById(R.id.problem);
            comments = itemView.findViewById(R.id.comments);
        }
    }
}
