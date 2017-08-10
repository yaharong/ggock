package com.king.togi.ggock.model;

/**
 * Created by Tacademy on 2017-08-03.
 */

public class TotalModel {
    private String imageUrl, name;

    public TotalModel(String imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
