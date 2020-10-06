package com.example.education_app.Model;

public class Timetable_Model {

    String class_start,class_end,text_subj,text_tchr;

    public Timetable_Model(String class_start, String class_end, String text_subj, String text_tchr) {
        this.class_start = class_start;
        this.class_end = class_end;
        this.text_subj = text_subj;
        this.text_tchr = text_tchr;
    }

    public String getClass_start() {
        return class_start;
    }

    public String getClass_end() {
        return class_end;
    }

    public String getText_subj() {
        return text_subj;
    }

    public String getText_tchr() {
        return text_tchr;
    }
}
