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
import com.example.education_app.Model.FeeNotification_Model;
import com.example.education_app.R;

import java.util.List;

public class FeeNotification_Adapter extends RecyclerView.Adapter<FeeNotification_Adapter.MyViewHolder> {

    Context context;
    List<FeeNotification_Model> feeNotification_models;

    public FeeNotification_Adapter(Context context, List<FeeNotification_Model> feeNotification_models) {
        this.context = context;
        this.feeNotification_models = feeNotification_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_fee_notification, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.date.setText(feeNotification_models.get(position).getDate());
        holder.time.setText(feeNotification_models.get(position).getTime());
        holder.title.setText(feeNotification_models.get(position).getTitle());
        holder.notification.setText(feeNotification_models.get(position).getNotification());

    }

    @Override
    public int getItemCount() {
        return feeNotification_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date,time,title,notification;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            title = itemView.findViewById(R.id.title);
            notification = itemView.findViewById(R.id.notification);
        }
    }
}
