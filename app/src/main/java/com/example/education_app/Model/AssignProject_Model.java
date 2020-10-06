package com.example.education_app.Model;

public class AssignProject_Model {

    String project_name,subj_tchr,description,sbmsn_date;

    public AssignProject_Model(String project_name, String subj_tchr, String description, String sbmsn_date) {
        this.project_name = project_name;
        this.subj_tchr = subj_tchr;
        this.description = description;
        this.sbmsn_date = sbmsn_date;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getSubj_tchr() {
        return subj_tchr;
    }

    public String getDescription() {
        return description;
    }

    public String getSbmsn_date() {
        return sbmsn_date;
    }
}
