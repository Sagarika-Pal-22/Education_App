package com.example.education_app.Model;

public class CityWiseTutor_Model {

    String img_tutor,tchr_name,city,subject;

    public CityWiseTutor_Model(String img_tutor, String tchr_name, String city, String subject) {
        this.img_tutor = img_tutor;
        this.tchr_name = tchr_name;
        this.city = city;
        this.subject = subject;
    }

    public String getImg_tutor() {
        return img_tutor;
    }

    public String getTchr_name() {
        return tchr_name;
    }

    public String getCity() {
        return city;
    }

    public String getSubject() {
        return subject;
    }
}
