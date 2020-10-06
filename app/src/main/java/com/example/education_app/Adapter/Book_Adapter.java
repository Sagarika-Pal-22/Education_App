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


import com.example.education_app.BookDetyails_Activity;
import com.example.education_app.Model.Book_Model;
import com.example.education_app.R;

import java.util.List;

public class Book_Adapter extends RecyclerView.Adapter<Book_Adapter.MyViewHolder> {

    Context context;
    List<Book_Model> book_models;

    public Book_Adapter(Context context, List<Book_Model> book_models) {
        this.context = context;
        this.book_models = book_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_books, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.img_book.setImageResource(book_models.get(position).getImg_book());
        holder.book_name.setText(book_models.get(position).getBook_name());
        holder.witer.setText(book_models.get(position).getWiter());
        holder.publisher.setText(book_models.get(position).getPublisher());
        holder.price.setText(book_models.get(position).getPrice());
        holder.text_review.setText(book_models.get(position).getText_review());

        holder.linear_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, BookDetyails_Activity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return book_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_book;
        TextView book_name,witer,publisher,price,text_review;
        LinearLayout linear_books;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_book = itemView.findViewById(R.id.img_book);
            book_name = itemView.findViewById(R.id.book_name);
            witer = itemView.findViewById(R.id.witer);
            publisher = itemView.findViewById(R.id.publisher);
            price = itemView.findViewById(R.id.price);
            text_review = itemView.findViewById(R.id.text_review);
            linear_books = itemView.findViewById(R.id.linear_books);
        }
    }
}
