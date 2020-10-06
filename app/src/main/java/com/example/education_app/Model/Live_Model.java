package com.example.education_app.Model;

public class Live_Model {

    String img_View,text_course,text_details,start_on,text_time,tchr_name;

    public Live_Model(String img_View,  String text_course, String text_details, String start_on, String text_time, String tchr_name) {
        this.img_View = img_View;
        this.text_course = text_course;
        this.text_details = text_details;
        this.start_on = start_on;
        this.text_time = text_time;
        this.tchr_name = tchr_name;
    }

    public String getImg_View() {
        return img_View;
    }

    public String getText_course() {
        return text_course;
    }

    public String getText_details() {
        return text_details;
    }

    public String getStart_on() {
        return start_on;
    }

    public String getText_time() {
        return text_time;
    }

    public String getTchr_name() {
        return tchr_name;
    }
}
