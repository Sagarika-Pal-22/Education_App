package com.example.education_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.education_app.Model.Next_Model;
import com.example.education_app.R;

import java.util.List;

public class Next_Adapter extends RecyclerView.Adapter<Next_Adapter.MyViewHolder> {

    Context context;
    List<Next_Model> next_models;

    public Next_Adapter(Context context, List<Next_Model> next_models) {
        this.context = context;
        this.next_models = next_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_gallery, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Next_Model nextModel = next_models.get(position);



    }

    @Override
    public int getItemCount() {
        return next_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

//        VideoView videoView;
        ImageView img_glry;
        LinearLayout linear_photos;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            videoView = itemView.findViewById(R.id.videoView);
            img_glry = itemView.findViewById(R.id.img_glry);
            linear_photos = itemView.findViewById(R.id.linear_photos);

        }
    }
}
