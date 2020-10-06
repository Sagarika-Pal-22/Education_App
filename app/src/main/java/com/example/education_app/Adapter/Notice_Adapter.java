package com.example.education_app.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Notice_Model;
import com.example.education_app.R;

import java.util.List;

public class Notice_Adapter extends RecyclerView.Adapter<Notice_Adapter.MyViewHolder> {

    Context context;
    List<Notice_Model> notice_models;

    public Notice_Adapter(Context context, List<Notice_Model> notice_models) {
        this.context = context;
        this.notice_models = notice_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_notice, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_school.setText(notice_models.get(position).getText_school());
        holder.text_time.setText(notice_models.get(position).getText_time());
        holder.notice.setText(notice_models.get(position).getNotice());

        if (notice_models.get(position).getType().equals("Image")) {
            holder.image.setVisibility(View.VISIBLE);
        }else {
            holder.image.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return notice_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text_school,text_time,notice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text_school = itemView.findViewById(R.id.text_school);
            text_time = itemView.findViewById(R.id.text_time);
            notice = itemView.findViewById(R.id.notice);
        }
    }
}
