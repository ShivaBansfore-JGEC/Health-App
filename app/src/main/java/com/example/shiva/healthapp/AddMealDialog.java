//package com.example.shiva.healthapp;
//
//import android.app.Activity;
//import android.app.Dialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.view.Window;
//import android.widget.AdapterView;
//import android.widget.ImageView;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
///**
// * Created by Shiva on 4/18/2018.
// */
//
//public class AddMealDialog extends Dialog {
//    private Activity activity;
//    TextView tv_cancel;
//    Spinner spinner_addMeal;
//    SpinnerAdapter spinnerAdapter_Meal;
//    public static String title;
//    ArrayList<SpinnerItem> list;
//    public AddMealDialog(Activity a)
//    {
//        super(a);
//        this.activity=a;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.add_meal_dialog);
//        setSpinner();
//       // tv_cancel=(TextView)findViewById(R.id.tv_cancel_addMeal);
//        spinner_addMeal=(Spinner)findViewById(R.id.spinner_addMeal);
//        spinnerAdapter_Meal=new SpinnerAdapter(activity,list);
//        spinner_addMeal.setAdapter(spinnerAdapter_Meal);
//        spinner_addMeal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                SpinnerItem clkItem=(SpinnerItem)adapterView.getItemAtPosition(i);
//                title=clkItem.getTitle();
////                Intent intent=new Intent(activity,CalorieTracker.class);
////                intent.putExtra("title",title);
////                activity.startActivity(intent);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
////        tv_cancel.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                dismiss();
////            }
////        });
//
//    }
//    public void setSpinner()
//    {
//        list=new ArrayList<>();
//        list.add(new SpinnerItem("Break Fast"));
//        list.add(new SpinnerItem("Tiffin"));
//        list.add(new SpinnerItem("Lunch"));
//        list.add(new SpinnerItem("Evening Tiffin"));
//        list.add(new SpinnerItem("Dinner"));
//
//    }
//}
