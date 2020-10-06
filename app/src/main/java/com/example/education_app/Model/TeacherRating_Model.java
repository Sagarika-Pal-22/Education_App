package com.example.education_app.Model;

public class TeacherRating_Model {

    String img_faculty,tchr_name,subject,review;

    public TeacherRating_Model(String img_faculty, String tchr_name, String subject, String review) {
        this.img_faculty = img_faculty;
        this.tchr_name = tchr_name;
        this.subject = subject;
        this.review = review;
    }

    public String getImg_faculty() {
        return img_faculty;
    }

    public String getTchr_name() {
        return tchr_name;
    }

    public String getSubject() {
        return subject;
    }

    public String getReview() {
        return review;
    }
}
