package com.example.education_app.Model;

public class TrackOrder_Model {

    String img_track,arriving_date,track_status;

    public TrackOrder_Model(String img_track, String arriving_date, String track_status) {
        this.img_track = img_track;
        this.arriving_date = arriving_date;
        this.track_status = track_status;
    }

    public String getImg_track() {
        return img_track;
    }

    public String getArriving_date() {
        return arriving_date;
    }

    public String getTrack_status() {
        return track_status;
    }
}
