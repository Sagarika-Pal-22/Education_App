package com.example.education_app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Adapter.IssuedBooks_Adapter;
import com.example.education_app.Adapter.LbraryHistory_Model;
import com.example.education_app.Adapter.LibraryHistory_Adapter;
import com.example.education_app.Model.IssuedBooks_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;

public class Library_fragment extends Fragment {

    TextView history,issued_books,request;
    LinearLayout linear_request_form;
    RecyclerView rv_history,rv_issued_books,rv_request;
    List<IssuedBooks_Model> issuedBooks_models;
    List<LbraryHistory_Model> lbraryHistory_models;
    IssuedBooks_Adapter issuedBooks_adapter;
    LibraryHistory_Adapter libraryHistory_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library,container,false);

        history =view.findViewById(R.id.history);
        issued_books =view.findViewById(R.id.issued_books);
        request =view.findViewById(R.id.request);
        linear_request_form =view.findViewById(R.id.linear_request_form);

        issuedBooks_models = new ArrayList<>();
        lbraryHistory_models = new ArrayList<>();

        issued_books.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        issued_books.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                history.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                issued_books.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                issued_books.setTextColor(getResources().getColor(R.color.colorWhite));
                request.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                request.setTextColor(getResources().getColor(R.color.colorWhite));
                rv_issued_books.setVisibility(View.GONE);
                linear_request_form.setVisibility(View.GONE);
                rv_history.setVisibility(View.VISIBLE);
            }
        });
        issued_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                issued_books.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                issued_books.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                history.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                history.setTextColor(getResources().getColor(R.color.colorWhite));
                request.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                request.setTextColor(getResources().getColor(R.color.colorWhite));
                rv_issued_books.setVisibility(View.VISIBLE);
                rv_history.setVisibility(View.GONE);
                linear_request_form.setVisibility(View.GONE);
            }
        });
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                history.setTextColor(getResources().getColor(R.color.colorWhite));
                issued_books.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                issued_books.setTextColor(getResources().getColor(R.color.colorWhite));
                request.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                request.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                rv_issued_books.setVisibility(View.GONE);
                rv_history.setVisibility(View.GONE);
                linear_request_form.setVisibility(View.VISIBLE);
            }
        });
        rv_history =view.findViewById(R.id.rv_history);
        rv_history.setHasFixedSize(true);
        rv_history.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        lbraryHistory_models.add(new LbraryHistory_Model("","11001754464","English Literature","Eng-14500","12 Mar 2020"));
        lbraryHistory_models.add(new LbraryHistory_Model("","11001754464","Bengali Literature","Beng-14500","12 Mar 2020"));
        lbraryHistory_models.add(new LbraryHistory_Model("","11001754464","Applied Physics","Phy-14500","12 Mar 2020"));
        lbraryHistory_models.add(new LbraryHistory_Model("","11001754464","Science","Sci-14500","12 Mar 2020"));
        libraryHistory_adapter = new LibraryHistory_Adapter(getActivity(),lbraryHistory_models);
        rv_history.setAdapter(libraryHistory_adapter);

        rv_issued_books =view.findViewById(R.id.rv_issued_books);
        rv_issued_books.setHasFixedSize(true);
        rv_issued_books.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        issuedBooks_models.add(new IssuedBooks_Model("","11001754464","English Literature","Eng-14500","12 Mar 2020","16 Mar 2020"));
        issuedBooks_models.add(new IssuedBooks_Model("","11001754464","Bengali Literature","Beng-14500","12 Mar 2020","16 Mar 2020"));
        issuedBooks_models.add(new IssuedBooks_Model("","11001754464","Applied Physics","Phy-14500","12 Mar 2020","16 Mar 2020"));
        issuedBooks_models.add(new IssuedBooks_Model("","11001754464","Science","Sci-14500","12 Mar 2020","16 Mar 2020"));
        issuedBooks_adapter = new IssuedBooks_Adapter(getActivity(),issuedBooks_models);
        rv_issued_books.setAdapter(issuedBooks_adapter);

        return view;
    }
}
