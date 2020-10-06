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

import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Tutors_Model;
import com.example.education_app.R;
import com.example.education_app.TutorDetails_Activity;

import java.util.List;

public class Tutors_Adapter extends RecyclerView.Adapter<Tutors_Adapter.MyViewHolder> {

    Context context;
    List<Tutors_Model> tutors_models;

    public Tutors_Adapter(Context context, List<Tutors_Model> tutors_models) {
        this.context = context;
        this.tutors_models = tutors_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_tutors, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_tutor.setText(tutors_models.get(position).getText_tutor());
        holder.text_adrss.setText(tutors_models.get(position).getText_adrss());
        holder.text_review.setText(tutors_models.get(position).getText_review());

        holder.linear_tuttors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, TutorDetails_Activity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return tutors_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_tutor;
        TextView  text_tutor,text_adrss,text_review;
        LinearLayout linear_tuttors;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_tutor = itemView.findViewById(R.id.img_tutor);
            text_tutor = itemView.findViewById(R.id.text_tutor);
            text_adrss = itemView.findViewById(R.id.text_adrss);
            text_review = itemView.findViewById(R.id.text_review);
            linear_tuttors = itemView.findViewById(R.id.linear_tuttors);
        }
    }

}
