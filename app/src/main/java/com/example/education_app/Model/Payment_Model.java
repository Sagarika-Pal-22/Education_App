package com.example.education_app.Model;

public class Payment_Model {

    String date,pymnt_mthd,purpose,paid_amnt;

    public Payment_Model(String date, String pymnt_mthd, String purpose, String paid_amnt) {
        this.date = date;
        this.pymnt_mthd = pymnt_mthd;
        this.purpose = purpose;
        this.paid_amnt = paid_amnt;
    }

    public String getDate() {
        return date;
    }

    public String getPymnt_mthd() {
        return pymnt_mthd;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getPaid_amnt() {
        return paid_amnt;
    }
}
