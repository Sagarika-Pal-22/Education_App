package com.example.education_app.Model;

public class Review_Model {
    String img_person,text_person,text_review;

    public Review_Model(String img_person, String text_person, String text_review) {
        this.img_person = img_person;
        this.text_person = text_person;
        this.text_review = text_review;
    }

    public String getImg_person() {
        return img_person;
    }

    public String getText_person() {
        return text_person;
    }

    public String getText_review() {
        return text_review;
    }
}
