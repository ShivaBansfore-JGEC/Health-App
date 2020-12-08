package com.example.shiva.healthapp;

/**
 * Created by Shiva on 4/13/2018.
 */

public class BodyPartsData {
    int image;
    String title;
    public BodyPartsData(String title)
    {
        this.setTitle(title);
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
