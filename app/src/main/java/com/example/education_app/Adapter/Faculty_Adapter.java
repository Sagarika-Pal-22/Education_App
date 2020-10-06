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
import com.example.education_app.Model.Faculty_Model;
import com.example.education_app.R;

import java.util.List;

public class Faculty_Adapter extends RecyclerView.Adapter<Faculty_Adapter.MyViewHolder> {

    Context context;
    List<Faculty_Model> faculty_models;

    public Faculty_Adapter(Context context, List<Faculty_Model> faculty_models) {
        this.context = context;
        this.faculty_models = faculty_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_faculty, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_faculty.setText(faculty_models.get(position).getText_faculty());
        holder.img_faculty.setImageResource(faculty_models.get(position).getImg_faculty());

    }

    @Override
    public int getItemCount() {
        return faculty_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_faculty;
        TextView text_faculty;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_faculty = itemView.findViewById(R.id.img_faculty);
            text_faculty = itemView.findViewById(R.id.text_faculty);
        }
    }

}
