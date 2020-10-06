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
import com.example.education_app.Model.FeeStructure_Model;
import com.example.education_app.R;

import java.util.List;

public class FeeStructure_Adapter extends RecyclerView.Adapter<FeeStructure_Adapter.MyViewHolder> {

    Context context;
    List<FeeStructure_Model> feeStructure_models;

    public FeeStructure_Adapter(Context context, List<FeeStructure_Model> feeStructure_models) {
        this.context = context;
        this.feeStructure_models = feeStructure_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_fee_structure, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_item.setText(feeStructure_models.get(position).getText_item());
        holder.text_amount.setText(feeStructure_models.get(position).getText_amount());
        holder.duration.setText(feeStructure_models.get(position).getDuration());

    }

    @Override
    public int getItemCount() {
        return feeStructure_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_item,text_amount,duration;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_item = itemView.findViewById(R.id.text_item);
            text_amount = itemView.findViewById(R.id.text_amount);
            duration = itemView.findViewById(R.id.duration);
        }
    }
}
