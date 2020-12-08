package com.example.shiva.healthapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shiva on 4/6/2018.
 */

public class UserSession {
    SharedPreferences preferences;
    Context context;
    private String email;
    private String password;
    private String facebookId;
    private String userId;
    private String token;

    public String getToken() {
        token=preferences.getString("token","");
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        preferences.edit().putString("token",token).commit();
    }


    public String getUserId() {
        userId=preferences.getString("userId","");
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        preferences.edit().putString("userId",userId).commit();
    }


    public String getEmail() {
        email=preferences.getString("email","");
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        preferences.edit().putString("email",email).commit();
    }


    public String getFacebookId() {
        facebookId=preferences.getString("facebookId","");
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
        preferences.edit().putString("facebookId",facebookId).commit();
    }


    public UserSession(Context context)
    {
        this.context=context;
        preferences=context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);
    }
    public void removeUser()
    {
        preferences.edit().clear().commit();
    }
}
