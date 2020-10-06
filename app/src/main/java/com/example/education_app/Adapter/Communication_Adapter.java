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

import com.example.education_app.Communication_Activity;
import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Communication_Model;
import com.example.education_app.R;

import java.util.List;

public class Communication_Adapter extends RecyclerView.Adapter<Communication_Adapter.MyViewHolder> {

    Context context;
    List<Communication_Model> communication_models;

    public Communication_Adapter(Context context, List<Communication_Model> communication_models) {
        this.context = context;
        this.communication_models = communication_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_communication, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tchr_type.setText(communication_models.get(position).getTchr_type());
        holder.msg.setText(communication_models.get(position).getMsg());
        holder.date.setText(communication_models.get(position).getDate());

        holder.linear_communication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, Communication_Activity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return communication_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_fav;
        TextView tchr_type,msg,date;
        LinearLayout linear_communication;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_fav = itemView.findViewById(R.id.img_fav);
            tchr_type = itemView.findViewById(R.id.tchr_type);
            msg = itemView.findViewById(R.id.msg);
            date = itemView.findViewById(R.id.date);
            linear_communication = itemView.findViewById(R.id.linear_communication);
        }
    }
}
