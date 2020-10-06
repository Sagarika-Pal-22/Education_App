package com.example.education_app.Model;

public class Solution_Model {

    String srl_no,question,solution;

    public Solution_Model(String srl_no, String question, String solution) {
        this.srl_no = srl_no;
        this.question = question;
        this.solution = solution;
    }

    public String getSrl_no() {
        return srl_no;
    }

    public String getQuestion() {
        return question;
    }

    public String getSolution() {
        return solution;
    }
}
