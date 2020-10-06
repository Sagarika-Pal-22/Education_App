package com.example.education_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.TeacherRating_Model;
import com.example.education_app.R;
import com.example.education_app.RateTeacher_Activity;

import java.util.List;

public class TchrRating_Adapter extends RecyclerView.Adapter<TchrRating_Adapter.MyViewHolder> {

    Context context;
    List<TeacherRating_Model> teacherRating_models;

    public TchrRating_Adapter(Context context, List<TeacherRating_Model> teacherRating_models) {
        this.context = context;
        this.teacherRating_models = teacherRating_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_rating_tchr, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tchr_name.setText(teacherRating_models.get(position).getTchr_name());
        holder.subject.setText(teacherRating_models.get(position).getSubject());
        holder.review.setText(teacherRating_models.get(position).getReview());

        holder.tchr_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, RateTeacher_Activity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return teacherRating_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_faculty;
        TextView tchr_name,subject,review;
        CardView tchr_details;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_faculty = itemView.findViewById(R.id.img_faculty);
            tchr_name = itemView.findViewById(R.id.tchr_name);
            subject = itemView.findViewById(R.id.subject);
            review = itemView.findViewById(R.id.review);
            tchr_details = itemView.findViewById(R.id.tchr_details);
        }
    }
}
