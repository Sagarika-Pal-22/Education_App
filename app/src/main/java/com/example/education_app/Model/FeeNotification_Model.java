package com.example.education_app.Model;

public class FeeNotification_Model {
    String date,time,title,notification;

    public FeeNotification_Model(String date, String time, String title, String notification) {
        this.date = date;
        this.time = time;
        this.title = title;
        this.notification = notification;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getNotification() {
        return notification;
    }

    public String getTitle() {
        return title;
    }
}
