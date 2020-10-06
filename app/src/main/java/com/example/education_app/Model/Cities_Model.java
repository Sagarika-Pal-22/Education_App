package com.example.education_app.Model;

public class Cities_Model {
    int image;
    String text_cities;

    public Cities_Model(int image, String text_cities) {
        this.image = image;
        this.text_cities = text_cities;
    }

    public int getImage() {
        return image;
    }

    public String getText_cities() {
        return text_cities;
    }
}
