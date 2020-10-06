package com.example.education_app.Model;

public class FeeStructure_Model {
    String text_item,text_amount,duration;

    public FeeStructure_Model(String text_item, String text_amount, String duration) {
        this.text_item = text_item;
        this.text_amount = text_amount;
        this.duration = duration;
    }

    public String getText_item() {
        return text_item;
    }

    public String getText_amount() {
        return text_amount;
    }

    public String getDuration() {
        return duration;
    }
}
