package com.example.education_app.Model;

public class TransportFee_Model {

    String sl_No,location,fees;

    public TransportFee_Model(String sl_No, String location, String fees) {
        this.sl_No = sl_No;
        this.location = location;
        this.fees = fees;
    }

    public String getSl_No() {
        return sl_No;
    }

    public String getLocation() {
        return location;
    }

    public String getFees() {
        return fees;
    }
}
