package com.example.shiva.healthapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class MyAdapter extends FragmentStatePagerAdapter
{
   int tabCount;
   private String tabTitle[]=new String[]{"Details","Membership","Timing"};

    public MyAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
       switch (position)
       {
           case 0:
               fragment=new Details();
               break;
           case 1:
               fragment=new Membership();
               break;
               case 2:
              fragment=new MapView();
              break;
       }

return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}