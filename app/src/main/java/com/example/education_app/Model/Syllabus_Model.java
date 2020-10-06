package com.example.education_app.Model;

public class Syllabus_Model {

    String text_title,img_sylbs;

    public Syllabus_Model(String text_title, String img_sylbs) {
        this.text_title = text_title;
        this.img_sylbs = img_sylbs;
    }

    public String getText_title() {
        return text_title;
    }

    public String getImg_sylbs() {
        return img_sylbs;
    }
}
