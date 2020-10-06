package com.example.education_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Ediary_Model;
import com.example.education_app.Model.Sent_Ediary_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class Received_Ediary_Adapter extends RecyclerView.Adapter<Received_Ediary_Adapter.MyViewHolder> {

    Context context;
    List<Ediary_Model> ediary_models;

    public Received_Ediary_Adapter(Context context, List<Ediary_Model> ediary_models) {
        this.context = context;
        this.ediary_models = ediary_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_ediary_received, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_complaint.setText(ediary_models.get(position).getText_complaint());
        holder.text_time.setText(ediary_models.get(position).getText_time());

        holder.sent_ediary_models = new ArrayList<>();

        holder.rv_sent.setHasFixedSize(true);
        holder.rv_sent.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        holder.sent_ediary_models.add(new Sent_Ediary_Model("Thank you for your concern Maam. I will try to make her understand and tell to keep her attentive during the class.","02:10pm"));
        holder.sent_ediary_adapter = new Sent_Ediary_Adapter(context,holder.sent_ediary_models);
        holder.rv_sent.setAdapter(holder.sent_ediary_adapter);


    }

    @Override
    public int getItemCount() {
        return ediary_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_subj,text_postBy,text_complaint,text_time;
        RecyclerView rv_sent;
        List<Sent_Ediary_Model> sent_ediary_models;
        Sent_Ediary_Adapter sent_ediary_adapter;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_complaint = itemView.findViewById(R.id.text_complaint);
            text_time = itemView.findViewById(R.id.text_time);
            rv_sent = itemView.findViewById(R.id.rv_sent);
        }
    }
}
