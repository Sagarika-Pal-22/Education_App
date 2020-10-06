package com.example.education_app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Adapter.Report_Adapter;
import com.example.education_app.Admission_Activity;
import com.example.education_app.Model.Report_Model;
import com.example.education_app.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.ArrayList;
import java.util.List;

public class ReportCard_Fragment extends Fragment {

    RecyclerView rv_half_yearly,rv_class_test,rv_final_test;
    List<Report_Model> class_test_models,half_yearly_model,final_model;
    Report_Adapter report_adapter;

    PieChart piechart;
    TextView class_test,half_yearly,final_exam;
    View view_class_test,view_half_yearly,view_final;
    LinearLayout linear_classTest,linear_halfYearly,linear_final;
    BetterSpinner spin_month;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report_card,container,false);

        class_test_models = new ArrayList<>();
        half_yearly_model = new ArrayList<>();
        final_model = new ArrayList<>();

        piechart = view.findViewById(R.id.piechart);
        class_test = view.findViewById(R.id.class_test);
        half_yearly = view.findViewById(R.id.half_yearly);
        final_exam = view.findViewById(R.id.final_exam);
        view_class_test = view.findViewById(R.id.view_class_test);
        view_half_yearly = view.findViewById(R.id.view_half_yearly);
        view_final = view.findViewById(R.id.view_final);
        spin_month = view.findViewById(R.id.spin_month);
        linear_classTest = view.findViewById(R.id.linear_classTest);
        linear_halfYearly = view.findViewById(R.id.linear_halfYearly);
        linear_final = view.findViewById(R.id.linear_final);

        piechart.setUsePercentValues(false);
        piechart.getDescription().setEnabled(false);
        piechart.setExtraOffsets(5,10,5,5);

        piechart.setDrawHoleEnabled(true);
        piechart.setHoleColor(Color.WHITE);
        piechart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(40f,"Physics"));
        yValues.add(new PieEntry(50f,"English"));
        yValues.add(new PieEntry(60f,"History"));
        yValues.add(new PieEntry(30f,"Geography"));
        yValues.add(new PieEntry(70f,"Mathematics"));
        yValues.add(new PieEntry(50f,"Social Study"));

        piechart.animateY(1000, Easing.EaseInOutCubic);

        PieDataSet dataSet = new PieDataSet(yValues,"(Marks)");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);
        piechart.setData(data);

        class_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                class_test.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_class_test.setVisibility(View.VISIBLE);
                half_yearly.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_half_yearly.setVisibility(View.GONE);
                final_exam.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_final.setVisibility(View.GONE);
                linear_classTest.setVisibility(View.VISIBLE);
                linear_halfYearly.setVisibility(View.GONE);
                linear_final.setVisibility(View.GONE);
            }
        });
        half_yearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                half_yearly.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_half_yearly.setVisibility(View.VISIBLE);
                class_test.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_class_test.setVisibility(View.GONE);
                final_exam.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_final.setVisibility(View.GONE);
                linear_classTest.setVisibility(View.GONE);
                linear_final.setVisibility(View.GONE);
                linear_halfYearly.setVisibility(View.VISIBLE);

            }
        });
        final_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final_exam.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                view_final.setVisibility(View.VISIBLE);
                class_test.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_class_test.setVisibility(View.GONE);
                half_yearly.setTextColor(getResources().getColor(R.color.colorDGrey));
                view_half_yearly.setVisibility(View.GONE);
                linear_halfYearly.setVisibility(View.GONE);
                linear_classTest.setVisibility(View.GONE);
                linear_final.setVisibility(View.VISIBLE);
            }
        });

        String[] month = {"January","February","March","April","May","June"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, month);
        spin_month.setAdapter(arrayAdapter);

        rv_class_test = view.findViewById(R.id.rv_class_test);
        rv_class_test.setHasFixedSize(true);
        rv_class_test.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        class_test_models.add(new Report_Model("Bengali","55","60","9","10"));
        class_test_models.add(new Report_Model("English","58","60","10","10"));
        class_test_models.add(new Report_Model("Mathematics","50","60","10","10"));
        class_test_models.add(new Report_Model("Geography","55","60","9","10"));
        class_test_models.add(new Report_Model("Hindi","35","60","9","10"));
        class_test_models.add(new Report_Model("General Knowledge","55","60","9","10"));
        class_test_models.add(new Report_Model("Conversation","18","30","0","0"));
        class_test_models.add(new Report_Model("Computer","55","60","0","0"));
        class_test_models.add(new Report_Model("Drawing","15","20","0","0"));
        class_test_models.add(new Report_Model("Extra Curricular Activities","10","30","0","0"));
        class_test_models.add(new Report_Model("Bratchary","22","25","0","0"));
        report_adapter = new Report_Adapter(getActivity(),class_test_models);
        rv_class_test.setAdapter(report_adapter);

        rv_half_yearly = view.findViewById(R.id.rv_half_yearly);
        rv_half_yearly.setHasFixedSize(true);
        rv_half_yearly.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        half_yearly_model.add(new Report_Model("Bengali","55","60","9","10"));
        half_yearly_model.add(new Report_Model("English","58","60","10","10"));
        half_yearly_model.add(new Report_Model("Mathematics","50","60","10","10"));
        half_yearly_model.add(new Report_Model("Geography","55","60","9","10"));
        half_yearly_model.add(new Report_Model("Hindi","35","60","9","10"));
        half_yearly_model.add(new Report_Model("General Knowledge","55","60","9","10"));
        half_yearly_model.add(new Report_Model("Conversation","18","30","0","0"));
        half_yearly_model.add(new Report_Model("Computer","55","60","0","0"));
        half_yearly_model.add(new Report_Model("Drawing","15","20","0","0"));
        half_yearly_model.add(new Report_Model("Extra Curricular Activities","10","30","0","0"));
        half_yearly_model.add(new Report_Model("Bratchary","22","25","0","0"));
        report_adapter = new Report_Adapter(getActivity(),half_yearly_model);
        rv_half_yearly.setAdapter(report_adapter);

        rv_final_test = view.findViewById(R.id.rv_final_test);
        rv_final_test.setHasFixedSize(true);
        rv_final_test.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        final_model.add(new Report_Model("Bengali","55","60","9","10"));
        final_model.add(new Report_Model("English","58","60","10","10"));
        final_model.add(new Report_Model("Mathematics","50","60","10","10"));
        final_model.add(new Report_Model("Geography","55","60","9","10"));
        final_model.add(new Report_Model("Hindi","35","60","9","10"));
        final_model.add(new Report_Model("General Knowledge","55","60","9","10"));
        final_model.add(new Report_Model("Conversation","18","30","0","0"));
        final_model.add(new Report_Model("Computer","55","60","0","0"));
        final_model.add(new Report_Model("Drawing","15","20","0","0"));
        final_model.add(new Report_Model("Extra Curricular Activities","10","30","0","0"));
        final_model.add(new Report_Model("Bratchary","22","25","0","0"));
        report_adapter = new Report_Adapter(getActivity(),final_model);
        rv_final_test.setAdapter(report_adapter);

        return view;
    }

}
