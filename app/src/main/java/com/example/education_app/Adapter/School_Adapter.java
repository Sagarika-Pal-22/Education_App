package com.example.education_app.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.School_Model;
import com.example.education_app.R;
import com.example.education_app.SchoolDetails_Activity;

import java.util.List;

public class School_Adapter extends RecyclerView.Adapter<School_Adapter.MyViewHolder> {

    Context context;
    List<School_Model> school_models;

    public School_Adapter(Context context, List<School_Model> school_models) {
        this.context = context;
        this.school_models = school_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_rcmnd_school, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.text_review.setText(school_models.get(position).getText_review());
        holder.text_name.setText(school_models.get(position).getText_name());
        holder.text_adrss.setText(school_models.get(position).getText_adrss());

        holder.animBlink = AnimationUtils.loadAnimation(context, R.anim.blink);
        holder.btn_admission.setVisibility(View.VISIBLE);
        holder.btn_admission.startAnimation(holder.animBlink);

        holder.linear_school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SchoolDetails_Activity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,holder.schl_img, ViewCompat.getTransitionName(holder.schl_img));
                context.startActivity(intent,optionsCompat.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return school_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        Animation animBlink;
        ImageView schl_img;
        TextView text_review,text_name,text_adrss;
        LinearLayout linear_school;
        Button btn_admission;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            schl_img = itemView.findViewById(R.id.img_school);
            text_review = itemView.findViewById(R.id.text_review);
            text_name = itemView.findViewById(R.id.text_name);
            text_adrss = itemView.findViewById(R.id.text_adrss);
            btn_admission = itemView.findViewById(R.id.btn_admission);
            linear_school = itemView.findViewById(R.id.linear_school);
        }
    }
}
