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
import com.example.education_app.Model.Timetable_Model;
import com.example.education_app.R;

import java.util.List;

public class Timetable_Adapter extends RecyclerView.Adapter<Timetable_Adapter.MyViewHolder> {

    Context context;
    List<Timetable_Model> timetable_models;

    public Timetable_Adapter(Context context, List<Timetable_Model> timetable_models) {
        this.context = context;
        this.timetable_models = timetable_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_timetable, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.class_start.setText(timetable_models.get(position).getClass_start());
        holder.class_end.setText(timetable_models.get(position).getClass_end());
        holder.text_subj.setText(timetable_models.get(position).getText_subj());
        holder.text_tchr.setText(timetable_models.get(position).getText_tchr());

        int colorRes = 0;
        switch(position % 6) {
            case 0: colorRes = R.color.colour_1;
                break;
            case 1: colorRes = R.color.colour_2;
                break;
            case 2: colorRes = R.color.colour_3;
                break;
            case 3: colorRes = R.color.colorDGrey;
                break;
            case 4: colorRes = R.color.colour_5;
                break;
            case 5: colorRes = R.color.colour_6;
                break;
        }
        holder.linear_back.setBackgroundColor(ContextCompat.getColor(context, colorRes));
    }

    @Override
    public int getItemCount() {
        return timetable_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_day,class_start,class_end,text_subj,text_tchr;
        LinearLayout linear_back;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_day = itemView.findViewById(R.id.text_day);
            class_start = itemView.findViewById(R.id.class_start);
            class_end = itemView.findViewById(R.id.class_end);
            text_subj = itemView.findViewById(R.id.text_subj);
            text_tchr = itemView.findViewById(R.id.text_tchr);
            linear_back = itemView.findViewById(R.id.linear_back);
        }
    }
}
