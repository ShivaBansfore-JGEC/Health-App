package com.example.shiva.healthapp.enums;

public enum URL {


//    CATEGORY_LIST("category_list");
gymDetails("gymDetails"),Facebook("facebook"),Login("login"),UserDetails("userDetails"),
    Sign("signup"),Excercise("excercise");

   // public String BASE_URL = "http://ogmaconceptions.com/demo/grouper/android/";
   public String BASE_URL = "http://ogmaconceptions.com/demo/fitness_app/api/";


    public String mURL;

    URL(String mURL) {
        this.mURL = this.BASE_URL + mURL;
    }

    public String getURL() {
        return mURL;
    }

}