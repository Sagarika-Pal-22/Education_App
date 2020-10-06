package com.example.education_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Syllabus_Model;
import com.example.education_app.R;

import java.util.List;

public class Syllabus_Adapter extends RecyclerView.Adapter<Syllabus_Adapter.MyViewHolder> {

    Context context;
    List<Syllabus_Model> syllabus_models;

    public Syllabus_Adapter(Context context, List<Syllabus_Model> syllabus_models) {
        this.context = context;
        this.syllabus_models = syllabus_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_syllabus, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_title.setText(syllabus_models.get(position).getText_title());

        int colorRes = 0;
        switch(position % 6) {
            case 0: colorRes = R.color.colour_1;
                break;
            case 1: colorRes = R.color.colour_2;
                break;
            case 2: colorRes = R.color.colour_3;
                break;
            case 3: colorRes = R.color.light_pink;
                break;
            case 4: colorRes = R.color.colour_5;
                break;
            case 5: colorRes = R.color.colour_6;
                break;
        }
        holder.linear_sylbs.setBackgroundColor(ContextCompat.getColor(context, colorRes));


    }

    @Override
    public int getItemCount() {
        return syllabus_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_sylbs;
        TextView text_title;
        LinearLayout linear_sylbs;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_sylbs = itemView.findViewById(R.id.img_sylbs);
            text_title = itemView.findViewById(R.id.text_title);
            linear_sylbs = itemView.findViewById(R.id.linear_sylbs);
        }
    }

}
