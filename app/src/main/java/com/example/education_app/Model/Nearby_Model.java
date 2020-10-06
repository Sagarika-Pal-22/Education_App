package com.example.education_app.Model;

public class Nearby_Model {
    String img_nearby,text_name,text_adrss,text_review,distance;

    public Nearby_Model(String img_nearby, String text_name, String text_adrss, String text_review, String distance) {
        this.img_nearby = img_nearby;
        this.text_name = text_name;
        this.text_adrss = text_adrss;
        this.text_review = text_review;
        this.distance = distance;
    }

    public String getImg_nearby() {
        return img_nearby;
    }

    public String getText_name() {
        return text_name;
    }

    public String getText_adrss() {
        return text_adrss;
    }

    public String getText_review() {
        return text_review;
    }

    public String getDistance() {
        return distance;
    }
}
