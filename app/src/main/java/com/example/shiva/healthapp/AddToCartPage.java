package com.example.shiva.healthapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AddToCartPage extends AppCompatActivity {
RecyclerView recyclerView;
RvCartListAdapter adapter;
LinearLayout linearLayout;
//CartTable table=new CartTable(this);
    TempTable tempTable=new TempTable(this);
    AddToCartModel model=new AddToCartModel();
TextView test;
    TextView title;
    ImageView logo;
    TextView remove;
ArrayList<Integer> list=new ArrayList<>();
TextView tv;
Cursor res;
int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart_page);

//        test=(TextView)findViewById(R.id.tv_test);
//        recyclerView=(RecyclerView)findViewById(R.id.rv_cartPage);
//        adapter=new RvCartListAdapter(this,list);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        linearLayout=(LinearLayout)findViewById(R.id.cart_layout);
        tv=(TextView)findViewById(R.id.cartNotification);
      res=tempTable.getData1();
        if (res!=null && res.getCount()>0)
       {
            while (res.moveToNext())
            {
               // test.setText(res.getString(0));
                list.add(Integer.parseInt(res.getString(0)));

            }
     }

     for (int i=0;i<list.size();i++)
     {
          title=new TextView(this);
          logo=new ImageView(this);
         remove=new TextView(this);

         final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
         lp.setMargins(40, 20, 1, 0);
         final LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
         lp.setMargins(10, 20, 1, 0);
         title.setLayoutParams(lp);
         logo.setLayoutParams(lp1);
         title.setText(Shop.arrayList.get(list.get(i)).getTitle());
         logo.setImageResource(Shop.arrayList.get(list.get(i)).getImage());
         logo.setMaxHeight(R.dimen.ImageHeight);
         logo.setMaxHeight(R.dimen.ImageWidth);
         logo.setPadding(10,5,0,20);
         remove.setLayoutParams(lp);
         remove.setText("Remove");
         linearLayout.addView(title);
         linearLayout.addView(logo);
         linearLayout.addView(remove);

     }


    }
}
