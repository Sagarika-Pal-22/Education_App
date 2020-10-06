package com.example.education_app.Model;

public class AdmissionDetails_Model {

    String academic_session,standard,admission_date,adimission_fees;

    public AdmissionDetails_Model(String academic_session, String standard, String admission_date, String adimission_fees) {
        this.academic_session = academic_session;
        this.standard = standard;
        this.admission_date = admission_date;
        this.adimission_fees = adimission_fees;
    }

    public String getAcademic_session() {
        return academic_session;
    }

    public String getStandard() {
        return standard;
    }

    public String getAdmission_date() {
        return admission_date;
    }

    public String getAdimission_fees() {
        return adimission_fees;
    }
}
