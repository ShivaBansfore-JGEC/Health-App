package com.example.shiva.healthapp;

/**
 * Created by Shiva on 4/25/2018.
 */

public class ProffesionalModel {
    int profile_img;
    String name;
    String city;
    public ProffesionalModel(int profile_img, String name, String field, String city) {
        this.setProfile_img(profile_img);
        this.setName(name);
        this.setField(field);
        this.setCity(city);
    }

    public void setProfile_img(int profile_img) {
        this.profile_img = profile_img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String field;

    public int getProfile_img() {
        return profile_img;
    }

    public String getName() {
        return name;
    }

    public String getField() {
        return field;
    }

    public String getCity() {
        return city;
    }





}
