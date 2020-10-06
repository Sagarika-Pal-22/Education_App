package com.example.education_app.Model;

public class Communication_Model {
    String img_fav,tchr_type,msg,date;

    public Communication_Model(String img_fav, String tchr_type, String msg, String date) {
        this.img_fav = img_fav;
        this.tchr_type = tchr_type;
        this.msg = msg;
        this.date = date;
    }

    public String getImg_fav() {
        return img_fav;
    }

    public String getTchr_type() {
        return tchr_type;
    }

    public String getMsg() {
        return msg;
    }

    public String getDate() {
        return date;
    }
}
