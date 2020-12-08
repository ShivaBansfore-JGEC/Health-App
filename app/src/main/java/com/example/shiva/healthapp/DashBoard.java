package com.example.shiva.healthapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import maes.tech.intentanim.CustomIntent;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class DashBoard extends AppCompatActivity {
 String title[]={"Customize Chart","Ask Experts?","Calorie Tracker","Exercise","Gym Club","Shop","Professionals"};
 RecyclerView recyclerView;
 Toolbar toolbar;
 DrawerLayout drawerLayout;
 NavigationView navigationView;
 ArrayList<DashboardData> list=new ArrayList<>();
   private InterstitialAd mInterstitialAd;
   ImageView iv_ask;
   ImageView iv_close;
 int img[]={R.drawable.dash1,R.drawable.calorei,R.drawable.askex,R.drawable.exer1,R.drawable.gym1,R.drawable.shop1,R.drawable.engineering};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        toolbar=(Toolbar)findViewById(R.id.toolbar_dashboard);
        iv_ask=(ImageView)findViewById(R.id.iv_ask);
      //  iv_close=(ImageView)findViewById(R.id.iv_close_view);
        recyclerView=(RecyclerView)findViewById(R.id.rv_dashboard);
        intializeData();
        recyclerView.setAdapter(new DashbordRvAdapter(this,list));
        GridLayoutManager  gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        iv_ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AskExpert.class));
            }
        });
//        iv_close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),LyaoutDialog.class));
//            }
//        });

//        AnimationDrawable animationDrawable=(AnimationDrawable) drawerLayout.getBackground();
//        animationDrawable.setEnterFadeDuration(2000);
//        animationDrawable.setExitFadeDuration(4000);
//        animationDrawable.start();

    }

    private void showInterstial() {
        if (mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
        }
    }

    @Override
    public void finish() {
        super.finish();
       // CustomIntent.customType(this,"up-to-bottom");
    }

    public void intializeData()
    {
        for (int i=0;i<title.length;i++)
        {
            DashboardData dashboardData=new DashboardData(title[i],img[i]);
            list.add(dashboardData);
        }
    }
}
