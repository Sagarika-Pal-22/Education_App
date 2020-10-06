package com.example.education_app.Model;

public class School_Model {
    String schl_img;
    String text_review,text_name,text_adrss,price,original_price,discount;

    public School_Model(String schl_img, String text_review, String text_name, String text_adrss, String price, String original_price, String discount) {
        this.schl_img = schl_img;
        this.text_review = text_review;
        this.text_name = text_name;
        this.text_adrss = text_adrss;
        this.price = price;
        this.original_price = original_price;
        this.discount = discount;
    }

    public String getSchl_img() {
        return schl_img;
    }

    public String getText_review() {
        return text_review;
    }

    public String getText_name() {
        return text_name;
    }

    public String getText_adrss() {
        return text_adrss;
    }

    public String getPrice() {
        return price;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public String getDiscount() {
        return discount;
    }
}
