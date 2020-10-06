package com.example.education_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.CityWiseTutor_Model;
import com.example.education_app.Model.TeacherRating_Model;
import com.example.education_app.R;
import com.example.education_app.RateTeacher_Activity;

import java.util.List;

public class CityWiseTutor_Adapter extends RecyclerView.Adapter<CityWiseTutor_Adapter.MyViewHolder> {

    Context context;
    List<CityWiseTutor_Model> cityWiseTutor_models;

    public CityWiseTutor_Adapter(Context context, List<CityWiseTutor_Model> cityWiseTutor_models) {
        this.context = context;
        this.cityWiseTutor_models = cityWiseTutor_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_citywise_tutor, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tchr_name.setText(cityWiseTutor_models.get(position).getTchr_name());
        holder.subject.setText(cityWiseTutor_models.get(position).getSubject());
        holder.city.setText(cityWiseTutor_models.get(position).getCity());


//        holder.tchr_details.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, RateTeacher_Activity.class));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return cityWiseTutor_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_tutor;
        TextView tchr_name,city,subject;
        CardView tchr_details;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_tutor = itemView.findViewById(R.id.img_tutor);
            tchr_name = itemView.findViewById(R.id.tchr_name);
            subject = itemView.findViewById(R.id.subject);
            city = itemView.findViewById(R.id.city);
            tchr_details = itemView.findViewById(R.id.tchr_details);
        }
    }
}
