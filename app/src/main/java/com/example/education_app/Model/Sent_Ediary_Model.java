package com.example.education_app.Model;

public class Sent_Ediary_Model {
    String ediary_reply,sent_time;

    public Sent_Ediary_Model(String ediary_reply, String sent_time) {
        this.ediary_reply = ediary_reply;
        this.sent_time = sent_time;
    }

    public String getEdiary_reply() {
        return ediary_reply;
    }

    public String getSent_time() {
        return sent_time;
    }
}
