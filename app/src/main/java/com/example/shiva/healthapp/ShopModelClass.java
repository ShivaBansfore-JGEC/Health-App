package com.example.shiva.healthapp;

/**
 * Created by Shiva on 4/16/2018.
 */

public class ShopModelClass  {
    String Title;
    String amount;
    String desc;
    int image;
    public ShopModelClass(String title,String amount,String desc,int image)
    {
        this.setTitle(title);
        this.setAmount(amount);
        this.setDesc(desc);
        this.setImage(image);
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
