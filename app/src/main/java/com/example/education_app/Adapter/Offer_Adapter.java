package com.example.education_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Offer_Model;
import com.example.education_app.R;

import java.util.List;

public class Offer_Adapter extends RecyclerView.Adapter<Offer_Adapter.MyViewHolder> {

    Context context;
    List<Offer_Model> offer_models;

    public Offer_Adapter(Context context, List<Offer_Model> offer_models) {
        this.context = context;
        this.offer_models = offer_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_offer, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_name.setText(offer_models.get(position).getText_name());
        holder.price.setText(offer_models.get(position).getPrice());






    }

    @Override
    public int getItemCount() {
        return offer_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_ofr;
        TextView text_name,price;;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_ofr = itemView.findViewById(R.id.img_ofr);
            text_name = itemView.findViewById(R.id.text_name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
