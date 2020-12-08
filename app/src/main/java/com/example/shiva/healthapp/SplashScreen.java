package com.example.shiva.healthapp;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT>=19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_splash_screen);
        Thread timer=new Thread()
        {
          public void run()
          {
              try {
                  sleep(2000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }finally {
                  startActivity(new Intent(SplashScreen.this,WelcomePage.class));
                  finish();
              }
          }
        };
        timer.start();
    }
}
