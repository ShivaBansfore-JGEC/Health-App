package com.example.shiva.healthapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalorieTracker extends AppCompatActivity {
ImageView iv;
TextView tv;
String title;
    String val;
Button add_food_cal;
LinearLayout linearLayout;
LinearLayout linearLayout2;
LinearLayout layout_main,layout3;
TextView textView;
TextView textView2;
TextView tv_quantity;
TextView colorie_count,calorie_count2,total_calorie;
String qty;
int result=0;
int total;
TextView tv_calorie;
TextView tv_add_plate;
Button qr_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_tracker);
        iv=(ImageView)findViewById(R.id.iv_Calorie_Tracker);
        tv=(TextView)findViewById(R.id.tv_calorie);
        add_food_cal=(Button)findViewById(R.id.btn_cal_addFood);
        layout_main=(LinearLayout)findViewById(R.id.layout_main);
        linearLayout=(LinearLayout)findViewById(R.id.my_dynamic_layout);
        linearLayout2=(LinearLayout)findViewById(R.id.dynamic_linear2);
        layout3=(LinearLayout)findViewById(R.id.layout3);
        colorie_count=(TextView)findViewById(R.id.tv_colorie_count);
        calorie_count2=(TextView)findViewById(R.id.tv_colorie_count2);
        total_calorie=(TextView)findViewById(R.id.total_calorie);
        tv_add_plate=(TextView)findViewById(R.id.tv_add_plate);
        qr_btn=(Button)findViewById(R.id.btn_qr_scan);
      //  tv_quantity=(TextView)findViewById(R.id.tv_quantity);

        setListener();
        qr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(CalorieTracker.this,BarcodeScanner.class));
            }
        });
    }
    public void setListener()
    {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddMealDialog mealDialog=new AddMealDialog(CalorieTracker.this);
                mealDialog.show();
            }
        });
        add_food_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFoodDialog foodDialog=new AddFoodDialog(CalorieTracker.this);
                foodDialog.show();
            }
        });
    }
    public void inflateLayout()
    {
        LinearLayout chile=(LinearLayout)this.getLayoutInflater().inflate(R.layout.layout_add_food,null);
        layout_main.addView(chile);
    }

    public class AddMealDialog extends Dialog {
        private Activity activity;
        TextView tv_cancel;
        Spinner spinner_addMeal;
        SpinnerAdapter spinnerAdapter_Meal;
        ArrayList<SpinnerItem> list;
        Button btn_ok;
        public AddMealDialog(Activity a)
        {
            super(a);
            this.activity=a;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.add_meal_dialog);
            setSpinner();
            // tv_cancel=(TextView)findViewById(R.id.tv_cancel_addMeal);
            spinner_addMeal=(Spinner)findViewById(R.id.spinner_addMeal);
            spinnerAdapter_Meal=new SpinnerAdapter(activity,list);
            spinner_addMeal.setAdapter(spinnerAdapter_Meal);
            btn_ok=(Button)findViewById(R.id.btn_ok);

            spinner_addMeal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    SpinnerItem clkItem=(SpinnerItem)adapterView.getItemAtPosition(i);
                    title=clkItem.getTitle();
//                    LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
//                    View view2=inflater.inflate(R.layout.layout_add_food,null);
                 //   TextView textView=(TextView)view2.findViewById(R.id.tv_add_food);
                  //  textView.setText(title);
                   tv.setText(title);
                   add_food_cal.setVisibility(View.VISIBLE);
                   tv_add_plate.setVisibility(View.VISIBLE);
//                Intent intent=new Intent(activity,CalorieTracker.class);
//                intent.putExtra("title",title);
//                activity.startActivity(intent);
                  //  inflateLayout();

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
//        tv_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dismiss();
//            }
//        });
            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });

        }
        public void setSpinner()
        {
            list=new ArrayList<>();
            list.add(new SpinnerItem("Break Fast"));
            list.add(new SpinnerItem("Lunch"));
            list.add(new SpinnerItem("Evening Tiffin"));
            list.add(new SpinnerItem("Dinner"));

        }
    }
    public void set()
    {
        textView=new TextView(this);
       // colorie_count=new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(20, 0, 1, 0);
        textView.setLayoutParams(lp);
        textView.setText(val);
        linearLayout.addView(textView);


//        String calorie=textView.getText().toString();
//        if (textView.getText().toString().equals("1 Bowl Rice"))
//        {
//            colorie_count.setText(calorie);
//        }else if (textView.getText().toString().equals("Egg"))
//        {
//            colorie_count.setText(calorie+" contains 250cal");
//        }

    }
    public void setLayout2()
    {
        textView2=new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(10, 20, 1, 0);
        textView2.setLayoutParams(lp);
        if (val.equalsIgnoreCase("Bowl Rice"))
        {
            textView2.setText(qty+" "+val);

        }else if (val.equalsIgnoreCase("Egg"))
        {

            textView2.setText(qty+" "+val);
        }else if (val.equalsIgnoreCase("Chicken"))
        {
            textView2.setText(qty+"00 grams of chicken");
        }else if (val.equalsIgnoreCase("Green Vegetable"))
        {
            textView2.setText(qty+"00 grams green vegetable");
        }else if (val.equalsIgnoreCase("Tea"))
        {
            textView2.setText(qty+"00 ml Tea");
        }
        else if (val.equalsIgnoreCase("Chapati"))
        {
            textView2.setText(qty+"pcs chapati");
        }
        else if (val.equalsIgnoreCase("Bread"))
        {
            textView2.setText(qty+"pcs Bread");
        }
        else if (val.equalsIgnoreCase("Milk"))
        {
            textView2.setText(qty+"00 ml milk");
        }
        else if (val.equalsIgnoreCase("Dry Fruits"))
        {
            textView2.setText(qty+"pcs Dry Fruits");
        }
        else if (val.equalsIgnoreCase("Potato"))
        {
            textView2.setText(qty+"00 grams of Potato");
        }
        else if (val.equalsIgnoreCase("Mutton"))
        {
            textView2.setText(qty+"00 grams Mutton");
        }
        else if (val.equalsIgnoreCase("Biryani"))
        {
            textView2.setText(qty+" plate biryani");
        }
        else if (val.equalsIgnoreCase("Fish"))
        {
            textView2.setText(qty+"00 grams fish");
        }

        linearLayout2.addView(textView2);
    }
    public class AddFoodDialog extends Dialog{
        private Activity activity;
        TextView tv_cancel;
        Spinner spinner_addFood;
        Spinner food_qty;
        SpinnerAdapter spinnerAdapter_Food;
        SpinnerAdapter spinnerAdapter_food_qty;
        ArrayList<SpinnerItem> list2;
        ArrayList<SpinnerItem> list3;
        Button btn_ok_food;
        public AddFoodDialog(Activity a)
        {
            super(a);
            this.activity=a;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.layout_add_food);
            setFood();
            setQty();
            spinner_addFood=(Spinner)findViewById(R.id.spinner_food);
            food_qty=(Spinner)findViewById(R.id.spinner_food_quantity);
            spinnerAdapter_Food=new SpinnerAdapter(activity,list2);
            spinnerAdapter_food_qty=new SpinnerAdapter(activity,list3);
            spinner_addFood.setAdapter(spinnerAdapter_Food);
            food_qty.setAdapter(spinnerAdapter_food_qty);
            btn_ok_food=(Button)findViewById(R.id.btn_ok_food);
            spinner_addFood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    SpinnerItem clkItem=(SpinnerItem)adapterView.getItemAtPosition(i);
                    val=clkItem.getTitle();
                    if (i==0)
                    {

                    }else {


                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            food_qty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    SpinnerItem clkItem=(SpinnerItem)adapterView.getItemAtPosition(i);
                    qty=clkItem.getTitle();
                    if (i==0)
                    {

                    }else{
                        setLayout2();
                        tv_calorie=new TextView(CalorieTracker.this);
                        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        lp3.setMargins(10, 20, 1, 0);
                        tv_calorie.setLayoutParams(lp3);
                        if (val.equalsIgnoreCase("Bowl Rice"))
                        {
                            result=Integer.parseInt(qty.toString())*200;
                            tv_calorie.setText(" contains:"+result+"cal");

                        }else if (val=="Egg")
                        {
                            result=Integer.parseInt(qty.toString())*300;
                            tv_calorie.setText(" contains:"+result+"cal");
                        }else if (val.equalsIgnoreCase("Chicken"))
                        {
                            result=Integer.parseInt(qty.toString())*500/100;
                            tv_calorie.setText(" contains:"+result+"cal");
                        }else if (val.equalsIgnoreCase("Green Vegetable"))
                        {
                            result=Integer.parseInt(qty.toString())*250;
                            tv_calorie.setText(" contains:"+result+"cal");
                        }else if (val.equalsIgnoreCase("Bread"))
                        {
                            result=Integer.parseInt(qty.toString())*50;
                            tv_calorie.setText(" contains:"+result+"cal");
                        }
                        else if (val.equalsIgnoreCase("Chapati"))
                        {
                            result=Integer.parseInt(qty.toString())*60;
                            tv_calorie.setText("contains:"+result+"cal");
                        }
                        else if (val.equalsIgnoreCase("Milk"))
                        {
                            result=Integer.parseInt(qty.toString())*200;
                            tv_calorie.setText(" contains:"+result+"cal");
                        }
                        else if (val.equalsIgnoreCase("Dry Fruits"))
                        {
                            result=Integer.parseInt(qty.toString())*100;
                            tv_calorie.setText(" contains:"+result+"cal");
                        }
                        else if (val.equalsIgnoreCase("Tea"))
                        {
                            result=Integer.parseInt(qty.toString())*20;
                            tv_calorie.setText(" contains:"+result+"cal");
                        }
                        else if (val.equalsIgnoreCase("Potato"))
                        {
                            result=Integer.parseInt(qty.toString())*100;
                            tv_calorie.setText(" contains:"+result+"cal");
                        }else if (val.equalsIgnoreCase("Mutton"))
                        {
                            result=Integer.parseInt(qty.toString())*500;
                            tv_calorie.setText(" Mutton contains:"+result+"cal");
                        }else if (val.equalsIgnoreCase("Fish"))
                        {
                            result=Integer.parseInt(qty.toString())*250;
                            tv_calorie.setText(" contains:"+result+"cal");
                        }else if (val.equalsIgnoreCase("Biryani"))
                        {
                            result=Integer.parseInt(qty.toString())*400;
                            tv_calorie.setText(" contains:"+result+"cal");
                        }
                        total+=result;
                        colorie_count.setText("Total calorie consumed: "+total+" cal.");
                        layout3.addView(tv_calorie);

//                        if (food=="1 Bowl Rice")
//                        {

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
         btn_ok_food.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 dismiss();
             }
         });
        }
        public void setFood()
        {
            list2=new ArrayList<>();
            if (title.equalsIgnoreCase("Break Fast"))
            {
                list2.add(new SpinnerItem("Choose"));
                list2.add(new SpinnerItem("Tea"));
                list2.add(new SpinnerItem("Chapati"));
                list2.add(new SpinnerItem("Bread"));
                list2.add(new SpinnerItem("Milk"));
                list2.add(new SpinnerItem("Dry Fruits"));
                list2.add(new SpinnerItem("Egg"));
                list2.add(new SpinnerItem("Aumnlet"));
            }else if (title.equalsIgnoreCase("Lunch")){
                list2.add(new SpinnerItem("Choose"));
                list2.add(new SpinnerItem("Bowl Rice"));
                list2.add(new SpinnerItem("Potato"));
                list2.add(new SpinnerItem("Egg"));
                list2.add(new SpinnerItem("Chicken"));
                list2.add(new SpinnerItem("Fish"));
                list2.add(new SpinnerItem("Biryani"));
                list2.add(new SpinnerItem("Mutton"));
                list2.add(new SpinnerItem("Green Vegetable"));
            }else if (title.equalsIgnoreCase("Evening Tiffin"))
            {
                list2.add(new SpinnerItem("Choose"));
                list2.add(new SpinnerItem("Tea"));
                list2.add(new SpinnerItem("Chapati"));
                list2.add(new SpinnerItem("Bread"));
                list2.add(new SpinnerItem("Milk"));
                list2.add(new SpinnerItem("Dry Fruits"));
            }else {
                list2.add(new SpinnerItem("Choose"));
                list2.add(new SpinnerItem("Bowl Rice"));
                list2.add(new SpinnerItem("Potato"));
                list2.add(new SpinnerItem("Egg"));
                list2.add(new SpinnerItem("Chicken"));
                list2.add(new SpinnerItem("Fish"));
                list2.add(new SpinnerItem("Biryani"));
                list2.add(new SpinnerItem("Mutton"));
                list2.add(new SpinnerItem("Green Vegetable"));
            }

        }
        public void setQty()
        {
            list3=new ArrayList<>();

                 list3.add(new SpinnerItem("choose"));
                 list3.add(new SpinnerItem("1"));
                 list3.add(new SpinnerItem("2"));
                 list3.add(new SpinnerItem("3"));
                 list3.add(new SpinnerItem("4"));
                 list3.add(new SpinnerItem("5"));
                 list3.add(new SpinnerItem("6"));
                 list3.add(new SpinnerItem("7"));
                 list3.add(new SpinnerItem("8"));




        }
    }


}
