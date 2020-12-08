package com.example.shiva.healthapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Shiva on 3/23/2018.
 */

public class MyPagerAdapter extends PagerAdapter {
    private int[] layouts;
    private LayoutInflater inflater;
    Context context;
    public MyPagerAdapter(int [] layouts,Context context) {
         this.context=context;
         this.layouts=layouts;
         inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=inflater.inflate(layouts[position],container,false);
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
