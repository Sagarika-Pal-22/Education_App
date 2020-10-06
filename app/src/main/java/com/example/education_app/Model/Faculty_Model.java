package com.example.education_app.Model;

public class Faculty_Model {

    int image;
    String text_faculty;

    public Faculty_Model(int image, String text_faculty) {
        this.image = image;
        this.text_faculty = text_faculty;
    }

    public int getImg_faculty() {
        return image;
    }

    public String getText_faculty() {
        return text_faculty;
    }
}
