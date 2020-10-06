package com.example.education_app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Adapter.Book_Adapter;
import com.example.education_app.Model.Book_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class BooksFragment extends Fragment {

    RecyclerView rv_books;
    List<Book_Model> book_models;
    Book_Adapter book_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_books, container, false);

        book_models = new ArrayList<>();

        rv_books = root.findViewById(R.id.rv_books);
        rv_books.setHasFixedSize(true);
        rv_books.setLayoutManager(new GridLayoutManager(getActivity(),3));
        book_models.add(new Book_Model(R.drawable.book_1,"Nuclear Physics","by Priyanka Jangid","Publishers","750","4.6"));
        book_models.add(new Book_Model(R.drawable.book_2,"ISC Chemistry","by Sannkish Devo","Publishers","850","5.0"));
        book_models.add(new Book_Model(R.drawable.book_3,"Applied Biology","by Priyanka Jangid","Publishers","900","4.8"));
        book_models.add(new Book_Model(R.drawable.book_1,"Nuclear Physics","by Sannkish Devo","Publishers","850","4.2"));
        book_models.add(new Book_Model(R.drawable.book_1,"Nuclear Physics","by Priyanka Jangid","Publishers","750","4.6"));
        book_models.add(new Book_Model(R.drawable.book_2,"ISC Chemistry","by Sannkish Devo","Publishers","850","5.0"));
        book_models.add(new Book_Model(R.drawable.book_3,"Applied Biology","by Priyanka Jangid","Publishers","900","4.8"));
        book_models.add(new Book_Model(R.drawable.book_1,"Nuclear Physics","by Sannkish Devo","Publishers","850","4.2"));
        book_adapter = new Book_Adapter(getActivity(),book_models);
        rv_books.setAdapter(book_adapter);

        return root;
    }
}
