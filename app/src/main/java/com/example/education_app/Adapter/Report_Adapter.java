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
import com.example.education_app.Model.Report_Model;
import com.example.education_app.R;

import java.util.List;

public class Report_Adapter extends RecyclerView.Adapter<Report_Adapter.MyViewHolder> {

    Context context;
    List<Report_Model> report_models;

    public Report_Adapter(Context context, List<Report_Model> report_models) {
        this.context = context;
        this.report_models = report_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_report_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.subject.setText(report_models.get(position).getSubject());
        holder.written_mo.setText(report_models.get(position).getWritten_mo());
        holder.written_fm.setText(report_models.get(position).getWritten_fm());
        holder.oral_mo.setText(report_models.get(position).getOral_mo());
        holder.oral_fm.setText(report_models.get(position).getOral_fm());

    }

    @Override
    public int getItemCount() {
        return report_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView subject,written_mo,written_fm,oral_mo,oral_fm;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.subject);
            written_mo = itemView.findViewById(R.id.written_mo);
            written_fm = itemView.findViewById(R.id.written_fm);
            oral_mo = itemView.findViewById(R.id.oral_mo);
            oral_fm = itemView.findViewById(R.id.oral_fm);
        }
    }

}
