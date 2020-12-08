package com.example.shiva.healthapp;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Shiva on 4/16/2018.
 */

public class DialogSort extends Dialog{
    private Activity activity;
    public DialogSort(Activity a)
    {
        super(a);
        this.activity=a;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_sort_dialog);

    }
}
