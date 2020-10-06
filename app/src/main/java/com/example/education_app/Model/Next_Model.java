package com.example.education_app.Model;

public class Next_Model {

    String previewUrl;
//    private String videoUrl;

    public Next_Model(String previewUrl) {
//        this.videoUrl = videoUrl;
        this.previewUrl = previewUrl;
    }

//    public String getVideoUrl() {
//        return videoUrl;
//    }
//
//    public void setVideoUrl(String videoUrl) {
//        this.videoUrl = videoUrl;
//    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }
}
