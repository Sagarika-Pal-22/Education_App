package com.example.education_app.Model;

public class Order_Model {

    String image, text_title_order, text_dlvrd_date;

    public Order_Model(String image, String text_title_order, String text_dlvrd_date) {
        this.image = image;
        this.text_title_order = text_title_order;
        this.text_dlvrd_date = text_dlvrd_date;
    }

    public String getImage() {
        return image;
    }

    public String getText_title_order() {
        return text_title_order;
    }

    public String getText_dlvrd_date() {
        return text_dlvrd_date;
    }
}
