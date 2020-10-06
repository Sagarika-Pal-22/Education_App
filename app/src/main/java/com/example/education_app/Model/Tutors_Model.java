package com.example.education_app.Model;

public class Tutors_Model {

    String img_tutor,text_tutor,text_adrss,text_review;

    public Tutors_Model(String img_tutor, String text_tutor, String text_adrss, String text_review) {
        this.img_tutor = img_tutor;
        this.text_tutor = text_tutor;
        this.text_adrss = text_adrss;
        this.text_review = text_review;
    }

    public String getImg_tutor() {
        return img_tutor;
    }

    public String getText_tutor() {
        return text_tutor;
    }

    public String getText_adrss() {
        return text_adrss;
    }

    public String getText_review() {
        return text_review;
    }
}
