package com.example.education_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.IssuedBooks_Model;
import com.example.education_app.R;

import java.util.List;

public class IssuedBooks_Adapter extends RecyclerView.Adapter<IssuedBooks_Adapter.MyViewHolder> {

    Context context;
    List<IssuedBooks_Model> issuedBooks_models;

    public IssuedBooks_Adapter(Context context, List<IssuedBooks_Model> issuedBooks_models) {
        this.context = context;
        this.issuedBooks_models = issuedBooks_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_issued_books, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.accesion.setText(issuedBooks_models.get(position).getAccesion());
        holder.book_name.setText(issuedBooks_models.get(position).getBook_name());
        holder.book_id.setText(issuedBooks_models.get(position).getBook_id());
        holder.issue_date.setText(issuedBooks_models.get(position).getIssue_date());
        holder.submsn_date.setText(issuedBooks_models.get(position).getSubmsn_date());

        int colorRes = 0;
        switch(position % 2) {
            case 0: colorRes = R.color.light_pink;
                break;
            case 1: colorRes = R.color.greyL;
                break;
        }
        holder.card_back.setBackgroundColor(ContextCompat.getColor(context, colorRes));

    }

    @Override
    public int getItemCount() {
        return issuedBooks_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_books;
        TextView accesion,book_name,book_id,issue_date,submsn_date;
        CardView card_back;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_books = itemView.findViewById(R.id.img_books);
            accesion = itemView.findViewById(R.id.accesion);
            book_name = itemView.findViewById(R.id.book_name);
            book_id = itemView.findViewById(R.id.book_id);
            issue_date = itemView.findViewById(R.id.issue_date);
            submsn_date = itemView.findViewById(R.id.submsn_date);
            card_back = itemView.findViewById(R.id.card_back);
        }
    }
}
