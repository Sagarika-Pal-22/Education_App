package com.example.education_app.Model;

public class JobDetailsModel {
    String id;
    String image;
    String job_name;
    String salary;
    String position_type;
    String adress;
    String city, pin;
    String state;
    String description;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public JobDetailsModel(String id, String image, String job_name, String salary, String position_type, String adress, String city, String pin, String state, String description) {
        this.id = id;
        this.image = image;
        this.job_name = job_name;
        this.salary = salary;
        this.position_type = position_type;
        this.adress = adress;
        this.city = city;
        this.pin = pin;
        this.state = state;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPosition_type() {
        return position_type;
    }

    public void setPosition_type(String position_type) {
        this.position_type = position_type;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
