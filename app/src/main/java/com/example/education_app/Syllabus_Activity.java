package com.example.education_app;

import android.content.Context;
import android.os.Bundle;
import com.example.education_app.Model.Syllabus_Model;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Syllabus_Activity extends AppCompatActivity {

    RecyclerView rv_syllabus;
    List<Syllabus_Model> syllabus_models;
    Syllabus_Adapter syllabus_adapter;
    LinearLayout linear_syllabus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        linear_syllabus = findViewById(R.id.linear_syllabus);

        syllabus_models = new ArrayList<>();

        rv_syllabus = findViewById(R.id.rv_syllabus);
        rv_syllabus.setHasFixedSize(true);
        rv_syllabus.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        syllabus_models.add(new Syllabus_Model("English Literature",""));
        syllabus_models.add(new Syllabus_Model("Mathematics",""));
        syllabus_models.add(new Syllabus_Model("History",""));
        syllabus_models.add(new Syllabus_Model("Geography",""));
        syllabus_models.add(new Syllabus_Model("Social Science",""));
        syllabus_models.add(new Syllabus_Model("Physical Science",""));
        syllabus_models.add(new Syllabus_Model("Life Science",""));
        syllabus_adapter = new Syllabus_Adapter(this,syllabus_models);
        rv_syllabus.setAdapter(syllabus_adapter);
    }

    public class Syllabus_Adapter extends RecyclerView.Adapter<Syllabus_Adapter.MyViewHolder> {

        Context context;
        List<Syllabus_Model> syllabus_models;

        public Syllabus_Adapter(Context context, List<Syllabus_Model> syllabus_models) {
            this.context = context;
            this.syllabus_models = syllabus_models;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_syllabus, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

            holder.text_title.setText(syllabus_models.get(position).getText_title());

            holder.linear_sylbs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rv_syllabus.setVisibility(View.GONE);
                    linear_syllabus.setVisibility(View.VISIBLE);
                }
            });
            int colorRes = 0;
            switch(position % 6) {
                case 0: colorRes = R.color.colour_1;
                    break;
                case 1: colorRes = R.color.colour_2;
                    break;
                case 2: colorRes = R.color.colour_3;
                    break;
                case 3: colorRes = R.color.colorDGrey;
                    break;
                case 4: colorRes = R.color.colour_5;
                    break;
                case 5: colorRes = R.color.colour_6;
                    break;
            }
            holder.linear_sylbs.setBackgroundColor(ContextCompat.getColor(context, colorRes));

        }

        @Override
        public int getItemCount() {
            return syllabus_models.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView img_sylbs;
            TextView text_title;
            LinearLayout linear_sylbs;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                img_sylbs = itemView.findViewById(R.id.img_sylbs);
                text_title = itemView.findViewById(R.id.text_title);
                linear_sylbs = itemView.findViewById(R.id.linear_sylbs);
            }
        }
    }


}