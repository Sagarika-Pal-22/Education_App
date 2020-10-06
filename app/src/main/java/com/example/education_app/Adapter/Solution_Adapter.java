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
import com.example.education_app.Model.Solution_Model;
import com.example.education_app.R;

import java.util.List;

public class Solution_Adapter extends RecyclerView.Adapter<Solution_Adapter.MyViewHolder> {

    Context context;
    List<Solution_Model> solution_models;

    public Solution_Adapter(Context context, List<Solution_Model> solution_models) {
        this.context = context;
        this.solution_models = solution_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_solutions, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.srl_no.setText(solution_models.get(position).getSrl_no());
        holder.question.setText(solution_models.get(position).getQuestion());
        holder.solution.setText(solution_models.get(position).getSolution());

    }

    @Override
    public int getItemCount() {
        return solution_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView srl_no,question,solution;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            srl_no = itemView.findViewById(R.id.srl_no);
            question = itemView.findViewById(R.id.question);
            solution = itemView.findViewById(R.id.solution);
        }
    }

}
