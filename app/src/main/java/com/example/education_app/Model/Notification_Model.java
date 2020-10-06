package com.example.education_app.Model;

public class Notification_Model {

    String text_date,text_time,notice_title,notice_des;

    public Notification_Model(String text_date, String text_time, String notice_title, String notice_des) {

        this.text_date = text_date;
        this.text_time = text_time;
        this.notice_title = notice_title;
        this.notice_des = notice_des;
    }

    public String getText_date() {
        return text_date;
    }

    public String getText_time() {
        return text_time;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public String getNotice_des() {
        return notice_des;
    }
}
