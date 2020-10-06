package com.example.education_app.Model;

public class SchoolActivity_Model {

    int image;
    String activity_name;

    public SchoolActivity_Model(int image, String activity_name) {
        this.image = image;
        this.activity_name = activity_name;
    }

    public int getImage() {
        return image;
    }

    public String getActivity_name() {
        return activity_name;
    }
}
