package com.example.shiva.healthapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Shiva on 4/17/2018.
 */

public class AnimationUtil {
    public static void animate(RecyclerView.ViewHolder holder,boolean goasDown)
    {
        AnimatorSet animatorSet=new AnimatorSet();
        ObjectAnimator animatorTranslateY=ObjectAnimator.ofFloat(holder.itemView,"translationY",goasDown==true?200:-200,0);
   animatorTranslateY.setDuration(1000);
   animatorSet.playTogether(animatorTranslateY);
   animatorSet.start();
    }
}
