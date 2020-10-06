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
import com.example.education_app.Model.Sent_Ediary_Model;
import com.example.education_app.R;

import java.util.List;

public class Sent_Ediary_Adapter extends RecyclerView.Adapter<Sent_Ediary_Adapter.MyViewHolder> {

    Context context;
    List<Sent_Ediary_Model> sent_ediary_models;

    public Sent_Ediary_Adapter(Context context, List<Sent_Ediary_Model> sent_ediary_models) {
        this.context = context;
        this.sent_ediary_models = sent_ediary_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_ediary_sent, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.ediary_reply.setText(sent_ediary_models.get(position).getEdiary_reply());
        holder.sent_time.setText(sent_ediary_models.get(position).getSent_time());

    }

    @Override
    public int getItemCount() {
        return sent_ediary_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ediary_reply,sent_time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ediary_reply = itemView.findViewById(R.id.ediary_reply);
            sent_time = itemView.findViewById(R.id.sent_time);
        }
    }
}
