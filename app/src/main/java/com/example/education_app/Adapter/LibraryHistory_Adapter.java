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

public class LibraryHistory_Adapter extends RecyclerView.Adapter<LibraryHistory_Adapter.MyViewHolder> {

    Context context;
    List<LbraryHistory_Model> lbraryHistory_models;

    public LibraryHistory_Adapter(Context context, List<LbraryHistory_Model> lbraryHistory_models) {
        this.context = context;
        this.lbraryHistory_models = lbraryHistory_models ;
    }

    @NonNull
    @Override
    public LibraryHistory_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_library_history, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.accesion.setText(lbraryHistory_models.get(position).getAccesion());
        holder.book_name.setText(lbraryHistory_models.get(position).getBook_name());
        holder.book_id.setText(lbraryHistory_models.get(position).getBook_id());
        holder.issue_date.setText(lbraryHistory_models.get(position).getIssue_date());

    }

    @Override
    public int getItemCount() {
        return lbraryHistory_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_books;
        TextView accesion,book_name,book_id,issue_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            accesion = itemView.findViewById(R.id.accesion);
            book_name = itemView.findViewById(R.id.book_name);
            book_id = itemView.findViewById(R.id.book_id);
            issue_date = itemView.findViewById(R.id.issue_date);
        }
    }


}
