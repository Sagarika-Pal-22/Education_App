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

import com.example.education_app.BookDetyails_Activity;
import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Favourite_Model;
import com.example.education_app.R;

import java.util.List;

public class Favourite_Adapter extends RecyclerView.Adapter<Favourite_Adapter.MyViewHolder> {

    Context context;
    List<Favourite_Model> favourite_models;

    public Favourite_Adapter(Context context, List<Favourite_Model> favourite_models) {
        this.context = context;
        this.favourite_models = favourite_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_favourite, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.book_name.setText(favourite_models.get(position).getBook_name());
        holder.writer.setText(favourite_models.get(position).getWriter());
        holder.publisher.setText(favourite_models.get(position).getPublisher());
        holder.price.setText(favourite_models.get(position).getPrice());

        holder.linear_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, BookDetyails_Activity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return favourite_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_fav;
        TextView book_name,writer,publisher,price;
        LinearLayout linear_fav;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_name = itemView.findViewById(R.id.book_name);
            writer = itemView.findViewById(R.id.writer);
            publisher = itemView.findViewById(R.id.publisher);
            price = itemView.findViewById(R.id.price);
            img_fav = itemView.findViewById(R.id.img_fav);
            linear_fav = itemView.findViewById(R.id.linear_fav);
        }
    }

}
