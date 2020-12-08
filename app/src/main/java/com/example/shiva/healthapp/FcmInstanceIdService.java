package com.example.shiva.healthapp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


public class FcmInstanceIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
      String recent_token= FirebaseInstanceId.getInstance().getToken();
      UserSession session=new UserSession(this);
      session.setToken(recent_token);
    }
}
