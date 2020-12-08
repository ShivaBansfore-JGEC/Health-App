package com.example.shiva.healthapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Professionals extends AppCompatActivity {
    int profile_img[]={R.drawable.proff1,R.drawable.proff2,R.drawable.proff3,R.drawable.proff4,R.drawable.proff5,R.drawable.proff6,R.drawable.proff7,R.drawable.proff8};
    String name[]={"David","Alex john","John martial","Sherlock Homes","Alex john","John martial","Sherlock Homes","Amon Ale"};
    String field[]={"Boxing Trainer","Gym Trainer","Gym Trainer","Gym Trainer","Gym Trainer","Martial Art Trainer","Gym Trainer","Gym Trainer"};
    String city[]={"Kolkata","Delhi","Chennai","Mumbai","Hyderabad","Banglore","Mysore","Siliguri"};
RecyclerView recyclerView;
RvProffessionalAdapter adapter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView tv_title;
    CircleImageView profile;
     UserSession session;
ArrayList<ProffesionalModel> list2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professionals);
        session=new UserSession(this);
        recyclerView=(RecyclerView)findViewById(R.id.rv_professional);
        initData();
        adapter=new RvProffessionalAdapter(this,list2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter.setOnClickListenerListener(new RvProffessionalAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(Professionals.this,ProffessionalsDetails.class));
                        break;
                }
            }
        });
        toolbar=(Toolbar)findViewById(R.id.toolbar_professionals);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_professional);
        navigationView=(NavigationView)findViewById(R.id.nav_view_professional);
        View headeView=navigationView.getHeaderView(0);
        tv_title=(TextView)headeView.findViewById(R.id.tv_header);
       tv_title.setText(session.getEmail());
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.item1:
                        startActivity(new Intent(Professionals.this,DietChart.class));
                        break;
                    case R.id.item2:
                        startActivity(new Intent(Professionals.this,AskExpert.class));
                        finish();
                        break;
                    case R.id.item3:
                        startActivity(new Intent(Professionals.this,CalorieTracker.class));
                        finish();
                        break;
                    case R.id.item4:
                        startActivity(new Intent(Professionals.this,ExcerciseType.class));
                        finish();
                        break;
                    case R.id.item5:
                        startActivity(new Intent(Professionals.this,GymClubDetails.class));
                        finish();
                        break;
                    case R.id.item6:
                        startActivity(new Intent(Professionals.this,Shop.class));
                        finish();
                        break;
                    case R.id.item7:
                        startActivity(new Intent(Professionals.this,Professionals.class));
                        finish();
                        break;
                    case R.id.item8:
                        startActivity(new Intent(Professionals.this,TrainerSignUp.class));
                        finish();
                        break;
                    case R.id.item9:
                        session.removeUser();
                        startActivity(new Intent(Professionals.this,LoginPage.class));
                        finish();
                        break;
                }
                return false;
            }
        });


    }

    private void initData() {
        for (int i=0;i<profile_img.length;i++)
        {
            ProffesionalModel proffesionalModel=new ProffesionalModel(profile_img[i],name[i],field[i],city[i]);
            list2.add(proffesionalModel);
        }
    }

}
