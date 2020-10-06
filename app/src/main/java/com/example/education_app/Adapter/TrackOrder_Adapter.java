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

import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.TrackOrder_Model;
import com.example.education_app.R;
import com.example.education_app.TrackOrderDetails_Activity;

import java.util.List;

public class TrackOrder_Adapter extends RecyclerView.Adapter<TrackOrder_Adapter.MyViewHolder> {

    Context context;
    List<TrackOrder_Model> trackOrder_models;

    public TrackOrder_Adapter(Context context, List<TrackOrder_Model> trackOrder_models) {
        this.context = context;
        this.trackOrder_models = trackOrder_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_track_order, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.arriving_date.setText(trackOrder_models.get(position).getArriving_date());
        holder.track_status.setText(trackOrder_models.get(position).getTrack_status());
        holder.linear_singleTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, TrackOrderDetails_Activity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return trackOrder_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_track;
        TextView arriving_date,track_status;
        LinearLayout linear_singleTrack;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_track = itemView.findViewById(R.id.img_track);
            arriving_date = itemView.findViewById(R.id.arriving_date);
            track_status = itemView.findViewById(R.id.track_status);
            linear_singleTrack = itemView.findViewById(R.id.linear_singleTrack);
        }
    }

}
