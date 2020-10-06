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
import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Holiday_Model;
import com.example.education_app.MyReportCard_Activity;
import com.example.education_app.OtherActivityGraph_Activity;
import com.example.education_app.R;
import com.example.education_app.StudentPerformanceGraph_Activity;

import java.util.List;

public class Holiday_Adapter extends RecyclerView.Adapter<Holiday_Adapter.MyViewHolder> {

    Context context;
    List<Holiday_Model> holiday_models;

    public Holiday_Adapter(Context context, List<Holiday_Model> holiday_models) {
        this.context = context;
        this.holiday_models = holiday_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_holidays, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_date.setText(holiday_models.get(position).getText_date());
        holder.holiday.setText(holiday_models.get(position).getHoliday());


    }

    @Override
    public int getItemCount() {
        return holiday_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_date,holiday;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_date = itemView.findViewById(R.id.text_date);
            holiday = itemView.findViewById(R.id.holiday);
        }
    }
}
