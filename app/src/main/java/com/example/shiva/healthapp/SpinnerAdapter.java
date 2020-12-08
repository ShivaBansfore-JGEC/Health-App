package com.example.shiva.healthapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shiva on 4/14/2018.
 */

public class SpinnerAdapter extends ArrayAdapter<SpinnerItem> {
    public  SpinnerAdapter(Context context, ArrayList<SpinnerItem> item)
    {
        super(context,0,item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initview(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initview(position,convertView,parent);
    }
    private View initview(int position,View convertview,ViewGroup parent)
    {
        if (convertview==null)
        {
            convertview= LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout,parent,false);

        }
        TextView textView=convertview.findViewById(R.id.tv_spinner_layout);
         SpinnerItem spinnerItem=getItem(position);
         if (spinnerItem!=null)
         {
             textView.setText(spinnerItem.getTitle());
         }
         return convertview;
    }
}
