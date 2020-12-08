package com.example.shiva.healthapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
*/
public class WelcomePage extends AppCompatActivity implements View.OnClickListener {
    ViewPager pager;
    MyPagerAdapter adapter;
    private LinearLayout dots_layout;
    private ImageView[] dots;
    private Button bnNext,bnSkip;
    private int[] layouts={R.layout.slide_splash,R.layout.slide1,R.layout.slide2,R.layout.slide3};
   UserSession userSession;
 //  AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT>=19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_welcome_page);
        pager=(ViewPager)findViewById(R.id.my_pager);
        adapter=new MyPagerAdapter(layouts,this);
        pager.setAdapter(adapter);
        dots_layout=(LinearLayout)findViewById(R.id.dots_layout);
        bnNext=(Button)findViewById(R.id.btn_next);
        bnSkip=(Button)findViewById(R.id.btn_skip);
        bnNext.setOnClickListener(this);
        bnSkip.setOnClickListener(this);
        bnNext.setVisibility(View.GONE);
        bnSkip.setVisibility(View.GONE);
        createDots(0);
        userSession=new UserSession(WelcomePage.this);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
               if (position==0)
                {
//                    bnNext.setText("Start");
                 //  bnSkip.setVisibility(View.GONE);
                    bnNext.setVisibility(View.GONE);
                    bnSkip.setVisibility(View.GONE);


               }else if (position==layouts.length-1)
               {
                   bnNext.setBackgroundResource(R.color.bottomNavColor);

               }
            else {
               bnNext.setBackgroundResource(R.color.dot_active);
                   bnNext.setVisibility(View.VISIBLE);
                   bnSkip.setVisibility(View.VISIBLE);
                  //bnSkip.setVisibility(View.VISIBLE);
              }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
//        View view=inflater.inflate(R.layout.slide3,null);
//        Button btn_log=(Button)view.findViewById(R.id.btn_skip_lst);
//        Button btn_sign=(Button)view.findViewById(R.id.btn_next_lst);
//        btn_log.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(WelcomePage.this,LoginPage.class));
//            }
//        });
//        btn_sign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(WelcomePage.this,UserRegistrationPage.class));
//            }
//        });
    }
    private void createDots(int current_position)
    {
        if (dots_layout!=null)
        {
            dots_layout.removeAllViews();
        }
        dots=new ImageView[layouts.length];
        for (int i=0;i<layouts.length;i++)
        {
            dots[i]=new ImageView(this);
            if (i==current_position)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
            }else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.inactive_dots));
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);
            dots_layout.addView(dots[i],params);
        }
    }

    @Override
    public void onClick(View view) {
       switch (view.getId())
        {
            case R.id.btn_next:
                startActivity(new Intent(WelcomePage.this,UserRegistrationPage.class));
                finish();
                // loadNextSlide();
               break;
           case R.id.btn_skip:

               startActivity(new Intent(WelcomePage.this,LoginPage.class));
//                if (userSession.getEmail()!=""|| userSession.getFacebookId()!="")
//                {
//                   startActivity(new Intent(WelcomePage.this,DashBoard.class));
//                }else {
//                    loadHome();
//                }

              //  new PreferenceManager(this).writePreference();
                break;
       }
    }
    private void loadHome()
    {
        startActivity(new Intent(this,LoginPage.class));
        finish();
    }
//    private void loadNextSlide()
//    {
//        int next_slide=pager.getCurrentItem()+1;
//        if (next_slide<layouts.length)
//        {
//            pager.setCurrentItem(next_slide);
//        }else {
//            loadHome();
//          //  new PreferenceManager(this).writePreference();
//        }
//    }

}

