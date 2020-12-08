package com.example.shiva.healthapp;

/**
 * Created by Shiva on 3/27/2018.
 */

public class DashboardData {
    String title;
    int imageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public DashboardData(String title, int imgId)
    {
        this.setTitle(title);
        this.setImageId(imgId);
    }
}
