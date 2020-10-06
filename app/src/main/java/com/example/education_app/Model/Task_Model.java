package com.example.education_app.Model;

public class Task_Model {

    String srl_no,text_question;

    public Task_Model(String srl_no, String text_question) {
        this.srl_no = srl_no;
        this.text_question = text_question;
    }

    public String getSrl_no() {
        return srl_no;
    }

    public String getText_question() {
        return text_question;
    }
}
