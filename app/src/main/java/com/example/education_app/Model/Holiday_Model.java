package com.example.education_app.Model;

public class Holiday_Model {
    String text_date,holiday;

    public Holiday_Model(String text_date, String holiday) {
        this.text_date = text_date;
        this.holiday = holiday;
    }

    public String getText_date() {
        return text_date;
    }

    public String getHoliday() {
        return holiday;
    }
}
