package com.example.education_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Notification_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class Notification_Adapter extends RecyclerView.Adapter<Notification_Adapter.MyViewHolder> {

    Context context;
    List<Notification_Model> notice__models = new ArrayList<>();

    public Notification_Adapter(Context context, List<Notification_Model> notice__models) {
        this.context = context;
        this.notice__models = notice__models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_notification, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.text_date.setText(notice__models.get(position).getText_date());
        holder.text_time.setText(notice__models.get(position).getText_time());
        holder.notice_title.setText(notice__models.get(position).getNotice_title());
        holder.notice_des.setText(notice__models.get(position).getNotice_des());

    }

    @Override
    public int getItemCount() {
        return notice__models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_date,text_time,notice_title,notice_des;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text_date = itemView.findViewById(R.id.text_date);
            text_time = itemView.findViewById(R.id.text_time);
            notice_title = itemView.findViewById(R.id.notice_title);
            notice_des = itemView.findViewById(R.id.notice_des);

        }
    }
}
