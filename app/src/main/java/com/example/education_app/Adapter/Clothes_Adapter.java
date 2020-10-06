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

import com.example.education_app.ItemDetails_Activity;
import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Clothes_Model;
import com.example.education_app.R;

import java.util.List;

public class Clothes_Adapter extends RecyclerView.Adapter<Clothes_Adapter.MyViewHolder> {

    Context context;
    List<Clothes_Model> clothes_models;

    public Clothes_Adapter(Context context, List<Clothes_Model> clothes_models) {
        this.context = context;
        this.clothes_models = clothes_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_dress, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.img_item.setImageResource(clothes_models.get(position).getImg_item());
        holder.text_title.setText(clothes_models.get(position).getText_title());
        holder.text_rating.setText(clothes_models.get(position).getText_rating());
        holder.text_price.setText(clothes_models.get(position).getText_price());
        holder.text_rs_cut.setText(clothes_models.get(position).getText_rs_cut());
        holder.text_off.setText(clothes_models.get(position).getText_off());

        holder.linear_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ItemDetails_Activity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return clothes_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_item;
        TextView text_title,text_rating,text_price,text_rs_cut,text_off;
        LinearLayout linear_items;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_item = itemView.findViewById(R.id.img_item);
            text_title = itemView.findViewById(R.id.text_title);
            text_rating = itemView.findViewById(R.id.text_rating);
            text_price = itemView.findViewById(R.id.text_price);
            text_rs_cut = itemView.findViewById(R.id.text_rs_cut);
            text_off = itemView.findViewById(R.id.text_off);
            linear_items = itemView.findViewById(R.id.linear_items);
        }
    }

}
