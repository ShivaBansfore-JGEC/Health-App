package com.example.shiva.healthapp;

import java.util.Comparator;

/**
 * Created by Shiva on 4/30/2018.
 */

public class Comparator2 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        ShopModelClass s1=(ShopModelClass) o1;
        ShopModelClass s2=(ShopModelClass) o2;
        int a=Integer.parseInt(s1.getAmount());
        int b=Integer.parseInt(s2.getAmount());
        if (s1.getAmount()==s2.getAmount())
        {
            return 0;
        }else if (a<b)
        {
            return 1;
        }else {
            return -1;
        }

    }
}
