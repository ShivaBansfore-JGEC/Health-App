package com.example.shiva.healthapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;

/**
 * Created by Shiva on 4/17/2018.
 */

public class DialogProduct extends Dialog {
    private Activity activity;
    TextView tv_low,tv_high;
    String shareBody="this a great app please try it.http://www.myapp.com";
    public DialogProduct(Activity a)
    {
        super(a);
        this.activity=a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_product_show);
        tv_low=(TextView)findViewById(R.id.tv_low);
        tv_high=(TextView)findViewById(R.id.tv_high);
        tv_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  sort();
                Shop.adapter.notifyDataSetChanged();
                  dismiss();
            }
        });
        tv_high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(Shop.arrayList,new Comparator2());
                Shop.adapter.notifyDataSetChanged();
                dismiss();

            }
        });
    }
    public void sort()
    {

            Collections.sort(Shop.arrayList,new MyComparator());

    }
}
