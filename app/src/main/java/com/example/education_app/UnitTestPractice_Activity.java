package com.example.education_app;

import android.content.Context;
import android.os.Bundle;

import com.example.education_app.Adapter.PracticeTest_Adapter;
import com.example.education_app.Adapter.Task_Adapter;
import com.example.education_app.Model.PracticeTest_Model;
import com.example.education_app.Model.Task_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UnitTestPractice_Activity extends AppCompatActivity {

    RecyclerView rv_examPractice, rv_examPaper;
    List<PracticeTest_Model> practiceTest_models;
    PracticeTest_Adapter practiceTest_adapter;
    List<Task_Model> task_models;
    Task_Adapter task_adapter;

    LinearLayout linear_subject,linear_papers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_test_practice_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        linear_papers = findViewById(R.id.linear_papers);
        linear_subject = findViewById(R.id.linear_subject);

        practiceTest_models = new ArrayList<>();

        rv_examPractice = findViewById(R.id.rv_examPractice);
        rv_examPractice.setHasFixedSize(true);
        rv_examPractice.setLayoutManager(new GridLayoutManager(this, 2));
        practiceTest_models.add(new PracticeTest_Model("English"));
        practiceTest_models.add(new PracticeTest_Model("Mathematics"));
        practiceTest_models.add(new PracticeTest_Model("Science"));
        practiceTest_models.add(new PracticeTest_Model("Social Study"));
        practiceTest_models.add(new PracticeTest_Model("History"));
        practiceTest_models.add(new PracticeTest_Model("Geography"));
        practiceTest_models.add(new PracticeTest_Model("General Knowledge"));
        practiceTest_models.add(new PracticeTest_Model("Hindi"));
        practiceTest_adapter = new PracticeTest_Adapter(this, practiceTest_models);
        rv_examPractice.setAdapter(practiceTest_adapter);

        task_models = new ArrayList<>();
        rv_examPaper = findViewById(R.id.rv_examPaper);
        rv_examPaper.setHasFixedSize(true);
        rv_examPaper.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        task_models.add(new Task_Model("1", "Copy and Complete the crossword puzzle from WS 23 in your notebook"));
        task_models.add(new Task_Model("2", "Recite your poem infront of a family member and take feedback."));
        task_models.add(new Task_Model("3", "Watch the youtube video http://youtube.com"));
        task_models.add(new Task_Model("4", "Copy and Complete the crossword puzzle from WS 23 in your notebook"));
        task_models.add(new Task_Model("5", "Recite your poem infront of a family member and take feedback."));
        task_models.add(new Task_Model("6", "Watch the youtube video http://youtube.com"));
        task_models.add(new Task_Model("7", "Copy and Complete the crossword puzzle from WS 23 in your notebook"));
        task_models.add(new Task_Model("8", "Recite your poem infront of a family member and take feedback."));
        task_models.add(new Task_Model("9", "Watch the youtube video http://youtube.com"));
        task_models.add(new Task_Model("10", "Copy and Complete the crossword puzzle from WS 23 in your notebook"));
        task_models.add(new Task_Model("11", "Recite your poem infront of a family member and take feedback."));
        task_models.add(new Task_Model("12", "Watch the youtube video http://youtube.com"));
        task_adapter = new Task_Adapter(this, task_models);
        rv_examPaper.setAdapter(task_adapter);
    }

    public class PracticeTest_Adapter extends RecyclerView.Adapter<PracticeTest_Adapter.MyViewHolder> {

        Context context;
        List<PracticeTest_Model> practiceTest_models;

        public PracticeTest_Adapter(Context context, List<PracticeTest_Model> practiceTest_models) {
            this.context = context;
            this.practiceTest_models = practiceTest_models;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_practice_test, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

            holder.text_subject.setText(practiceTest_models.get(position).getText_subject());

            int colorRes = 0;
            switch (position % 6) {
                case 0:
                    colorRes = R.color.colour_1;
                    break;
                case 1:
                    colorRes = R.color.colour_2;
                    break;
                case 2:
                    colorRes = R.color.colour_3;
                    break;
                case 3:
                    colorRes = R.color.light_pink;
                    break;
                case 4:
                    colorRes = R.color.colour_5;
                    break;
                case 5:
                    colorRes = R.color.colour_6;
                    break;
            }
            holder.linear_practice.setBackgroundColor(ContextCompat.getColor(context, colorRes));

            holder.linear_practice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    linear_papers.setVisibility(View.VISIBLE);
                    linear_subject.setVisibility(View.GONE);
                }
            });
        }

        @Override
        public int getItemCount() {
            return practiceTest_models.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView text_subject;
            LinearLayout linear_practice;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                text_subject = itemView.findViewById(R.id.text_subject);
                linear_practice = itemView.findViewById(R.id.linear_practice);
            }
        }
    }
}