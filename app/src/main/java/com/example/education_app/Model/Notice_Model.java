package com.example.education_app.Model;

public class Notice_Model {

    String type,text_school,text_time,notice,image;

    public Notice_Model(String type, String text_school, String text_time, String notice, String image) {
        this.type = type;
        this.text_school = text_school;
        this.text_time = text_time;
        this.notice = notice;
        this.image = image;
    }

    public String getText_school() {
        return text_school;
    }

    public String getText_time() {
        return text_time;
    }

    public String getNotice() {
        return notice;
    }

    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }
}
