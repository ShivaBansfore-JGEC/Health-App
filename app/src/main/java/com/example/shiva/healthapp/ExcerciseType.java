package com.example.shiva.healthapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class ExcerciseType extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    CircleImageView iv_yoga,iv_free_hand,iv_gym;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_type);
        iv_yoga=(CircleImageView)findViewById(R.id.iv_yoga);
        iv_free_hand=(CircleImageView)findViewById(R.id.iv_free_hand);
        iv_gym=(CircleImageView)findViewById(R.id.iv_gym);
        BannerSlider bannerSlider = (BannerSlider) findViewById(R.id.banner_slider2);
        List<Banner> banners=new ArrayList<>();
        //add banner using image url
        banners.add(new RemoteBanner("Put banner image url here ..."));
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.exer_2));
        banners.add(new DrawableBanner(R.drawable.exer_3));
        banners.add(new DrawableBanner(R.drawable.yoga_img1));
        bannerSlider.setBanners(banners);
        iv_yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=1;
                Intent intent=new Intent(ExcerciseType.this,BodyParts.class);
                intent.putExtra("position",position);
              startActivity(intent);
            }
        });
        iv_free_hand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=1;
                Intent intent2=new Intent(ExcerciseType.this,BodyParts.class);
                intent2.putExtra("position",position);
                startActivity(intent2);

            }
        });
        iv_gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=1;
                Intent intent3=new Intent(ExcerciseType.this,BodyParts.class);
                intent3.putExtra("position",position);
                startActivity(intent3);
            }
        });
    }
}
