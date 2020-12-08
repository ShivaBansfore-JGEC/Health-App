package com.example.shiva.healthapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Shiva on 3/28/2018.
 */

public class MyImageSlider extends PagerAdapter {
    int[] img={R.drawable.banner,R.drawable.banner2,R.drawable.banner3};
    Context ctx;
    public MyImageSlider(Context ctxt)
    {
        this.ctx=ctxt;
    }
    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.layout_image_slider,container,false);
        ImageView imageView=(ImageView)view.findViewById(R.id.iv_club_view);
        imageView.setImageResource(img[position]);
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
