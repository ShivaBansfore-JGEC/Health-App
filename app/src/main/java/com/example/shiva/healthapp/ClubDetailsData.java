package com.example.shiva.healthapp;

/**
 * Created by Shiva on 3/27/2018.
 */

public class ClubDetailsData {
    String contacts;
    String phone;
    String email;
    String imageId;
    String contacts2;
    String phone2;
    String email2;
    int imageId2;
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }


    public String getContacts2() {
        return contacts2;
    }

    public void setContacts2(String contacts2) {
        this.contacts2 = contacts2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public int getImageId2() {
        return imageId2;
    }

    public void setImageId2(int imageId2) {
        this.imageId2 = imageId2;
    }

    public ClubDetailsData(String phone, String email, String contacts, String imageId, String phone2, String email2, String contacts2, int imageId2)
    {
        this.setPhone(phone);
        this.setEmail(email);
        this.setContacts(contacts);
        this.setImageId(imageId);
        this.setPhone2(phone2);
        this.setEmail2(email2);
        this.setContacts2(contacts2);
        this.setImageId2(imageId2);

    }
}
