package com.example.education_app.Model;

public class Discussion_Model {

    String text_question,img_student,text_name,text_time,problem,comments;

    public Discussion_Model(String text_question, String img_student, String text_name, String text_time, String problem, String comments) {
        this.text_question = text_question;
        this.img_student = img_student;
        this.text_name = text_name;
        this.text_time = text_time;
        this.problem = problem;
        this.comments = comments;
    }

    public String getText_question() {
        return text_question;
    }

    public String getImg_student() {
        return img_student;
    }

    public String getText_name() {
        return text_name;
    }

    public String getText_time() {
        return text_time;
    }

    public String getProblem() {
        return problem;
    }

    public String getComments() {
        return comments;
    }
}
