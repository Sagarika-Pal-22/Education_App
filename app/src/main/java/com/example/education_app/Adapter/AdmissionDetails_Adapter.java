package com.example.education_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.AdmissionDetails_Model;
import com.example.education_app.Model.Cities_Model;
import com.example.education_app.R;

import java.util.List;

public class AdmissionDetails_Adapter extends RecyclerView.Adapter<AdmissionDetails_Adapter.MyViewHolder> {

    Context context;
    List<AdmissionDetails_Model> admissionDetails_models;

    public AdmissionDetails_Adapter(Context context, List<AdmissionDetails_Model> admissionDetails_models) {
        this.context = context;
        this.admissionDetails_models = admissionDetails_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_admission_details, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.academic_session.setText(admissionDetails_models.get(position).getAcademic_session());
        holder.standard.setText(admissionDetails_models.get(position).getStandard());
        holder.admission_date.setText(admissionDetails_models.get(position).getAdmission_date());
        holder.adimission_fees.setText(admissionDetails_models.get(position).getAdimission_fees());

    }

    @Override
    public int getItemCount() {
        return admissionDetails_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView academic_session,standard,admission_date,adimission_fees;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            academic_session = itemView.findViewById(R.id.academic_session);
            standard = itemView.findViewById(R.id.standard);
            admission_date = itemView.findViewById(R.id.admission_date);
            adimission_fees = itemView.findViewById(R.id.adimission_fees);
        }
    }
}
