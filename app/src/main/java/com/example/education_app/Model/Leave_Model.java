package com.example.education_app.Model;

public class Leave_Model {

    String text_from,text_to,text_reason;

    public Leave_Model(String text_from, String text_to, String text_reason) {
        this.text_from = text_from;
        this.text_to = text_to;
        this.text_reason = text_reason;
    }

    public String getText_from() {
        return text_from;
    }

    public String getText_to() {
        return text_to;
    }

    public String getText_reason() {
        return text_reason;
    }
}
