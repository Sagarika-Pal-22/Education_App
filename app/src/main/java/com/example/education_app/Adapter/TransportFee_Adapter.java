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
import com.example.education_app.Model.TransportFee_Model;
import com.example.education_app.R;

import java.util.List;

public class TransportFee_Adapter extends RecyclerView.Adapter<TransportFee_Adapter.MyViewHolder> {

    Context context;
    List<TransportFee_Model> transportFee_models;

    public TransportFee_Adapter(Context context, List<TransportFee_Model> transportFee_models) {
        this.context = context;
        this.transportFee_models = transportFee_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_transport_fee, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.sl_No.setText(transportFee_models.get(position).getSl_No());
        holder.location.setText(transportFee_models.get(position).getLocation());
        holder.fees.setText(transportFee_models.get(position).getFees());

    }

    @Override
    public int getItemCount() {
        return transportFee_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView sl_No,location,fees;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sl_No = itemView.findViewById(R.id.sl_No);
            location = itemView.findViewById(R.id.location);
            fees = itemView.findViewById(R.id.fees);
        }
    }
}
