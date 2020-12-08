package com.example.shiva.healthapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import de.hdodenhof.circleimageview.CircleImageView;

public class Shop extends AppCompatActivity implements SearchView.OnQueryTextListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
     RecyclerView recyclerView;
    public static RvShopAdapter adapter;
    public static RelativeLayout relativeLayout;
    TextView tv_sort,tv_filter;
    int index_rv;
    public static ArrayList<ShopModelClass> arrayList=new ArrayList<>();
 public static    String prodTitle[]={"Product1","Product2","Product3","Product4","Product5","Product6","Product7"};
    public static   String amount[]={"899","1299","999","2599","5000","850","1700"};
    public static   String desc[]={"Product1","Product2","Product3","Product4","Product5","Product6","Product7"};
    public static    int image[]={R.drawable.product1,R.drawable.product9,R.drawable.product3,R.drawable.product4,R.drawable.product5,R.drawable.product6,R.drawable.product7};
    TextView tv_title;
    CircleImageView profile;
    UserSession session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        session=new UserSession(this);
        tv_sort=(TextView)findViewById(R.id.tv_sort_shop);
        tv_filter=(TextView)findViewById(R.id.tv_filter_shop);
        relativeLayout=(RelativeLayout)findViewById(R.id.bottom_root);
        toolbar=(Toolbar)findViewById(R.id.toolbar_shop);
        setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_shop);
        navigationView=(NavigationView)findViewById(R.id.nav_view_shop);
        View headeView=navigationView.getHeaderView(0);
        tv_title=(TextView)headeView.findViewById(R.id.tv_header);
        tv_title.setText(session.getEmail());
        setDrawer();
        adapter=new RvShopAdapter(this,arrayList);
        recyclerView=(RecyclerView)findViewById(R.id.rv_shop);
        recyclerView.setAdapter(adapter);
        recyclerView.removeAllViews();
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        init();
        setAdapterListener();
        tv_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              DialogProduct dialogProduct=new DialogProduct(Shop.this);
              dialogProduct.show();
//              recyclerView.removeAllViews();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.cart)
                {
                    startActivity(new Intent(Shop.this,AddToCartPage.class));
                }
                return false;
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.item1:
                        startActivity(new Intent(Shop.this,DietChart.class));
                        break;
                    case R.id.item2:
                        startActivity(new Intent(Shop.this,AskExpert.class));
                        break;
                    case R.id.item3:
                        startActivity(new Intent(Shop.this,CalorieTracker.class));
                        break;
                    case R.id.item4:
                        startActivity(new Intent(Shop.this,ExcerciseType.class));
                        break;
                    case R.id.item5:
                        startActivity(new Intent(Shop.this,GymClubDetails.class));
                        break;
                    case R.id.item6:
                        startActivity(new Intent(Shop.this,Shop.class));
                        break;
                    case R.id.item7:
                        startActivity(new Intent(Shop.this,Professionals.class));
                        break;
                    case R.id.item8:
                        startActivity(new Intent(Shop.this,TrainerSignUp.class));
                        break;
                    case R.id.item9:
                        session.removeUser();
                        startActivity(new Intent(Shop.this,LoginPage.class));
                        finish();
                        break;
                }
                return false;
            }
        });

    }
    public void setDrawer()
    {
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
    public void setAdapterListener()
    {
        adapter.setOnItemClickListener(new RvShopAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch(position)
                {
                    case 0:
                        index_rv=0;
                        Intent intent=new Intent(Shop.this,ProductDetails.class);
                        intent.putExtra("index",index_rv);
                        startActivity(intent);
                        break;
                    case 1:
                        index_rv=1;
                        Intent intent1=new Intent(Shop.this,ProductDetails.class);
                        intent1.putExtra("index",index_rv);
                        startActivity(intent1);
                        break;
                }
            }
        });

    }

    public static void init()
    {
        for (int i=0;i<image.length;i++)
        {
            ShopModelClass shopModelClass=new ShopModelClass(prodTitle[i],amount[i],desc[i],image[i]);
            arrayList.add(shopModelClass);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shop_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<ShopModelClass> newList=new ArrayList<>();
        for (ShopModelClass shopModelClass:arrayList)
        {
            String name=shopModelClass.getTitle().toLowerCase();
            if (name.contains(newText))
            {
                newList.add(shopModelClass);
            }
        }
        adapter.setFilter(newList);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        arrayList.clear();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recyclerView.removeAllViews();
    }
}
