package com.example.education_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.LiveClass_Details_Activity;
import com.example.education_app.Model.Live_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class All_Live_Adapter extends RecyclerView.Adapter<All_Live_Adapter.MyViewHolder> {

    Context context;
    List<Live_Model> live_models = new ArrayList<>();

    public All_Live_Adapter(Context context, List<Live_Model> live_models) {
        this.context = context;
        this.live_models = live_models;
    }

    @NonNull
    @Override
    public All_Live_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_live_class, parent, false);
        return new All_Live_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull All_Live_Adapter.MyViewHolder holder, int position) {
        holder.text_course.setText(live_models.get(position).getText_course());
        holder.text_details.setText(live_models.get(position).getText_details());
        holder.start_on.setText(live_models.get(position).getStart_on());
        holder.text_time.setText(live_models.get(position).getText_time());
        holder.tchr_name.setText(live_models.get(position).getTchr_name());

        holder.linear_live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, LiveClass_Details_Activity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return live_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linear_live;
        ImageView img_View;
        TextView text_lang,text_course,text_details,start_on,text_time,tchr_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_View = itemView.findViewById(R.id.img_View);
            text_lang = itemView.findViewById(R.id.text_lang);
            text_course = itemView.findViewById(R.id.text_course);
            text_details = itemView.findViewById(R.id.text_details);
            start_on = itemView.findViewById(R.id.start_on);
            text_time = itemView.findViewById(R.id.text_time);
            tchr_name = itemView.findViewById(R.id.tchr_name);
            linear_live = itemView.findViewById(R.id.linear_live);

        }
    }
}
