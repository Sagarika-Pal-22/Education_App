package com.example.education_app.Model;

public class OtherActivity_Model {

    String activity_name;
    int activity_points;

    public OtherActivity_Model(String activity_name, int activity_points) {
        this.activity_name = activity_name;
        this.activity_points = activity_points;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public int getActivity_points() {
        return activity_points;
    }
}
