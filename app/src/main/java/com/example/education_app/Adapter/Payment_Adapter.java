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
import com.example.education_app.Model.Payment_Model;
import com.example.education_app.R;

import java.util.List;

public class Payment_Adapter extends RecyclerView.Adapter<Payment_Adapter.MyViewHolder> {

    Context context;
    List<Payment_Model> payment_models;

    public Payment_Adapter(Context context, List<Payment_Model> payment_models) {
        this.context = context;
        this.payment_models = payment_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_payment, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.date.setText(payment_models.get(position).getDate());
        holder.pymnt_mthd.setText(payment_models.get(position).getPymnt_mthd());
        holder.purpose.setText(payment_models.get(position).getPurpose());
        holder.paid_amnt.setText(payment_models.get(position).getPaid_amnt());

    }

    @Override
    public int getItemCount() {
        return payment_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date,pymnt_mthd,purpose,paid_amnt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            pymnt_mthd = itemView.findViewById(R.id.pymnt_mthd);
            purpose = itemView.findViewById(R.id.purpose);
            paid_amnt = itemView.findViewById(R.id.paid_amnt);
        }
    }

}
