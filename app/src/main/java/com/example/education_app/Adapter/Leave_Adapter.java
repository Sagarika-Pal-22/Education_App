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
import com.example.education_app.Model.Leave_Model;
import com.example.education_app.R;

import java.util.List;

public class Leave_Adapter extends RecyclerView.Adapter<Leave_Adapter.MyViewHolder> {

    Context context;
    List<Leave_Model> leave_models;

    public Leave_Adapter(Context context, List<Leave_Model> leave_models) {
        this.context = context;
        this.leave_models = leave_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_leaves, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_from.setText(leave_models.get(position).getText_from());
        holder.text_to.setText(leave_models.get(position).getText_to());
        holder.text_reason.setText(leave_models.get(position).getText_reason());

    }

    @Override
    public int getItemCount() {
        return leave_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_dlt;
        TextView text_from,text_to,text_reason;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_dlt = itemView.findViewById(R.id.img_dlt);
            text_from = itemView.findViewById(R.id.text_from);
            text_to = itemView.findViewById(R.id.text_to);
            text_reason = itemView.findViewById(R.id.text_reason);
        }
    }

}
