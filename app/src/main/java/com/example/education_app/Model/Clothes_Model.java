package com.example.education_app.Model;

public class Clothes_Model {

    int img_item;
    String text_title,text_rating,text_price,text_rs_cut,text_off;

    public Clothes_Model(int img_item, String text_title, String text_rating, String text_price, String text_rs_cut, String text_off) {
        this.img_item = img_item;
        this.text_title = text_title;
        this.text_rating = text_rating;
        this.text_price = text_price;
        this.text_rs_cut = text_rs_cut;
        this.text_off = text_off;
    }

    public int getImg_item() {
        return img_item;
    }

    public String getText_title() {
        return text_title;
    }

    public String getText_price() {
        return text_price;
    }

    public String getText_rs_cut() {
        return text_rs_cut;
    }

    public String getText_off() {
        return text_off;
    }

    public String getText_rating() {
        return text_rating;
    }
}
