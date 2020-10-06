package com.example.education_app.Model;

public class Previous_Model {

    String task_type,subj_tchr,subj_name,assgn_date,sbmsn_date;

    public Previous_Model(String task_type, String subj_tchr, String subj_name, String assgn_date) {
        this.task_type = task_type;
        this.subj_tchr = subj_tchr;
        this.subj_name = subj_name;
        this.assgn_date = assgn_date;
    }

    public String getTask_type() {
        return task_type;
    }

    public String getSubj_tchr() {
        return subj_tchr;
    }

    public String getSubj_name() {
        return subj_name;
    }

    public String getAssgn_date() {
        return assgn_date;
    }
}
