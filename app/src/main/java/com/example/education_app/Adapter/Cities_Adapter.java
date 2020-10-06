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
import com.example.education_app.R;

import java.util.List;

public class Cities_Adapter extends RecyclerView.Adapter<Cities_Adapter.MyViewHolder> {

    Context context;
    List<Cities_Model> cities_models;

    public Cities_Adapter(Context context, List<Cities_Model> cities_models) {
        this.context = context;
        this.cities_models = cities_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_cities, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.image.setImageResource(cities_models.get(position).getImage());
        holder.text_cities.setText(cities_models.get(position).getText_cities());

    }

    @Override
    public int getItemCount() {
        return cities_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text_cities;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_cities);
            text_cities = itemView.findViewById(R.id.text_cities);
        }
    }

}
