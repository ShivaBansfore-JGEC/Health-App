package com.example.shiva.healthapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class BodyParts extends AppCompatActivity {
RecyclerView recyclerView;
RvBodyPartsAdapter adapter;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
private ArrayList<BodyPartsData> list=new ArrayList<>();
private String title[]={"ABS","BACK","BICEPS","CALF","CHEST","FOREARMS","LEGS","SHOULDERS","TRICEPS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_parts);
        recyclerView=(RecyclerView)findViewById(R.id.rv_body_parts);
        adapter=new RvBodyPartsAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        init();
        toolbar=(Toolbar)findViewById(R.id.toolbar_body_parts);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_body_parts);
        navigationView=(NavigationView)findViewById(R.id.nav_view_body_parts);
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        adapter.setOnItemClickListener(new RvBodyPartsAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position)
                {
                    case 0:
                        String dv_area="leg";
                        Intent intent=getIntent();
                        int index=intent.getIntExtra("position",0);
                        Log.e("position:", String.valueOf(index));
                        Intent intent1=new Intent(BodyParts.this,ExcerciseList.class);
                        intent1.putExtra("position",index);
                        intent1.putExtra("development_area",dv_area);
                        startActivity(intent1);
                        break;
                    case 1:
                        Toast.makeText(BodyParts.this,"Pending work",Toast.LENGTH_SHORT).show();
                       // startActivity(new Intent(BodyParts.this,ExcerciseList.class));
                        break;
                    case 2:
                       // startActivity(new Intent(BodyParts.this,ExcerciseList.class));
                        Toast.makeText(BodyParts.this,"Pending work",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                      //  startActivity(new Intent(BodyParts.this,ExcerciseList.class));
                        Toast.makeText(BodyParts.this,"Pending work",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                       // startActivity(new Intent(BodyParts.this,ExcerciseList.class));
                        Toast.makeText(BodyParts.this,"Pending work",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                       // startActivity(new Intent(BodyParts.this,ExcerciseList.class));
                        Toast.makeText(BodyParts.this,"Pending work",Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                       // startActivity(new Intent(BodyParts.this,ExcerciseList.class));
                        Toast.makeText(BodyParts.this,"Pending work",Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                      //  startActivity(new Intent(BodyParts.this,ExcerciseList.class));
                        Toast.makeText(BodyParts.this,"Pending work",Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                      //  startActivity(new Intent(BodyParts.this,ExcerciseList.class));
                        Toast.makeText(BodyParts.this,"Pending work",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
    public void init()
    {
       for (int i=0;i<title.length;i++)
       {
           BodyPartsData data=new BodyPartsData(title[i]);
           list.add(data);
       }
    }
}
