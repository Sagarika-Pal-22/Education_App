package com.example.education_app.Model;

public class Offer_Model {

    String text_name,price;

    public Offer_Model(String text_name, String price) {
        this.text_name = text_name;
        this.price = price;
    }

    public String getText_name() {
        return text_name;
    }

    public String getPrice() {
        return price;
    }
}
