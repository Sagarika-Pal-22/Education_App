package com.example.education_app.Model;

public class Exam_Model {

    String subj_name,exam_date,subj_topic,exam_status,test_type;

    public Exam_Model(String subj_name, String exam_date, String subj_topic, String exam_status, String test_type) {
        this.subj_name = subj_name;
        this.exam_date = exam_date;
        this.subj_topic = subj_topic;
        this.exam_status = exam_status;
        this.test_type = test_type;
    }

    public String getSubj_name() {
        return subj_name;
    }

    public String getExam_date() {
        return exam_date;
    }

    public String getSubj_topic() {
        return subj_topic;
    }

    public String getExam_status() {
        return exam_status;
    }

    public String getTest_type() {
        return test_type;
    }
}
