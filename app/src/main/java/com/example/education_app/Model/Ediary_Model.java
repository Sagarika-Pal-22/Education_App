package com.example.education_app.Model;

public class Ediary_Model {

    String text_subj,text_postBy,text_complaint,text_time;

    public Ediary_Model(String text_subj, String text_postBy, String text_complaint, String text_time) {
        this.text_subj = text_subj;
        this.text_postBy = text_postBy;
        this.text_complaint = text_complaint;
        this.text_time = text_time;
    }

    public String getText_subj() {
        return text_subj;
    }

    public String getText_postBy() {
        return text_postBy;
    }

    public String getText_complaint() {
        return text_complaint;
    }

    public String getText_time() {
        return text_time;
    }
}
