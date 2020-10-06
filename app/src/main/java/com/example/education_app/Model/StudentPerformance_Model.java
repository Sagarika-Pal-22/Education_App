package com.example.education_app.Model;

public class StudentPerformance_Model {

    String subject;
    int numbers;

    public StudentPerformance_Model(String subject, int numbers) {
        this.subject = subject;
        this.numbers = numbers;
    }

    public String getSubject() {
        return subject;
    }

    public int getNumbers() {
        return numbers;
    }
}
