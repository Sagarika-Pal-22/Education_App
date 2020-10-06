package com.example.education_app;

import android.content.Context;
import android.os.Bundle;

import com.example.education_app.Adapter.Exam_Adapter;
import com.example.education_app.Model.Exam_Model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExamSchedule_Activity extends AppCompatActivity {

    RecyclerView rv_upcoming;
    List<Exam_Model> upcoming_exam;
    Exam_Adapter exam_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_schedule_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        upcoming_exam = new ArrayList<>();

        rv_upcoming = findViewById(R.id.rv_upcoming);
        rv_upcoming.setHasFixedSize(true);
        rv_upcoming.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        upcoming_exam.add(new Exam_Model("All Subjects", "Starts on 5 Oct, 2020", "half yearly exam", "", "half yearly"));
        exam_adapter = new Exam_Adapter(this, upcoming_exam);
        rv_upcoming.setAdapter(exam_adapter);

    }

    public class Exam_Adapter extends RecyclerView.Adapter<Exam_Adapter.MyViewHolder> {

        Context context;
        List<Exam_Model> exam_models;

        public Exam_Adapter(Context context, List<Exam_Model> exam_models) {
            this.context = context;
            this.exam_models = exam_models;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_exam, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

            holder.subj_topic.setText(exam_models.get(position).getSubj_topic());
            holder.exam_date.setText(exam_models.get(position).getExam_date());
            holder.subj_name.setText(exam_models.get(position).getSubj_name());
            holder.test_type.setText(exam_models.get(position).getTest_type());

            int colorRes = 0;
            switch (position % 2) {
                case 0:
                    colorRes = R.color.green;
                    break;
                case 1:
                    colorRes = R.color.colour_1;
                    break;
            }
            holder.test_type.setBackgroundColor(ContextCompat.getColor(context, colorRes));

            holder.linear_schedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.card_routine.setVisibility(View.VISIBLE);

                }
            });

        }

        @Override
        public int getItemCount() {
            return exam_models.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView subj_name, exam_date, subj_topic, test_type;
            LinearLayout linear_schedule;
            CardView card_routine;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                subj_name = itemView.findViewById(R.id.subj_name);
                exam_date = itemView.findViewById(R.id.exam_date);
                subj_topic = itemView.findViewById(R.id.subj_topic);
                subj_name = itemView.findViewById(R.id.subj_name);
                test_type = itemView.findViewById(R.id.test_type);
                linear_schedule = itemView.findViewById(R.id.linear_schedule);
                card_routine = itemView.findViewById(R.id.card_routine);
            }
        }
    }
}