package com.example.shiva.healthapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class ClubDetailsView extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
ViewPager viewPager;
TabLayout tabLayout;
Toolbar toolbar;
ImageView logo;
TextView gym_title;
LinearLayout layout;
private ImageLoader imageLoader;

ImageView iv_back_cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT>=19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_club_details_view);
        layout=(LinearLayout)findViewById(R.id.layout_discount);
        iv_back_cv=(ImageView)findViewById(R.id.iv_back_cv);
        DisplayImageOptions imageOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(imageOptions).build();
        ImageLoader.getInstance().init(imageLoaderConfiguration);
        BannerSlider bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);
        List<Banner> banners=new ArrayList<>();
        //add banner using image url
        banners.add(new RemoteBanner("Put banner image url here ..."));
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.banner2));
        banners.add(new DrawableBanner(R.drawable.banner3));
        bannerSlider.setBanners(banners);
        toolbar=(Toolbar)findViewById(R.id.toolbar_cdv);
        viewPager=(ViewPager)findViewById(R.id.viewpager_cdv);
        tabLayout=(TabLayout)findViewById(R.id.tablayout_cdv);
        MyAdapter adapter=new MyAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        logo=(ImageView)findViewById(R.id.iv_cdv);
        gym_title=(TextView)findViewById(R.id.tv_gymNmae_cdv);
        Intent intent=getIntent();
        imageLoader=ImageLoader.getInstance();
        int position=intent.getIntExtra("position",0);
        String url = null;
        try {
            url = GymClubDetails.jArr.getJSONObject(position).optString("logo");
        } catch (JSONException e) {
            e.printStackTrace();
        }
      gym_title.setText(GymClubDetails.jArr.optJSONObject(position).optString("name"));
        imageLoader.displayImage(url,logo);

    }
    public void goBack(View view)
    {
        startActivity(new Intent(this,GymClubDetails.class));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    public void getDiscount(View view)
    {
        CustomDialog dialog=new CustomDialog(ClubDetailsView.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();
    }
}
