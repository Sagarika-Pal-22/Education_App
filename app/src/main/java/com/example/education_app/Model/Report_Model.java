package com.example.education_app.Model;

public class Report_Model {

    String subject,written_mo,written_fm,oral_mo,oral_fm;

    public Report_Model(String subject, String written_mo, String written_fm, String oral_mo, String oral_fm) {
        this.subject = subject;
        this.written_mo = written_mo;
        this.written_fm = written_fm;
        this.oral_mo = oral_mo;
        this.oral_fm = oral_fm;
    }

    public String getSubject() {
        return subject;
    }

    public String getWritten_mo() {
        return written_mo;
    }

    public String getWritten_fm() {
        return written_fm;
    }

    public String getOral_mo() {
        return oral_mo;
    }

    public String getOral_fm() {
        return oral_fm;
    }
}
