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
import com.example.education_app.Model.PracticeTest_Model;
import com.example.education_app.R;

import java.util.List;

public class PracticeTest_Adapter extends RecyclerView.Adapter<PracticeTest_Adapter.MyViewHolder> {

    Context context;
    List<PracticeTest_Model> practiceTest_models;

    public PracticeTest_Adapter(Context context, List<PracticeTest_Model> practiceTest_models) {
        this.context = context;
        this.practiceTest_models = practiceTest_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_practice_test, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_subject.setText(practiceTest_models.get(position).getText_subject());

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
        holder.linear_practice.setBackgroundColor(ContextCompat.getColor(context, colorRes));
    }

    @Override
    public int getItemCount() {
        return practiceTest_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_subject;
        LinearLayout linear_practice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_subject = itemView.findViewById(R.id.text_subject);
            linear_practice = itemView.findViewById(R.id.linear_practice);
        }
    }
}
