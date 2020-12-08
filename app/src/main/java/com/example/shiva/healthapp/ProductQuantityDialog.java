package com.example.shiva.healthapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

/**
 * Created by Shiva on 4/17/2018.
 */

public class ProductQuantityDialog extends Dialog {
    private Activity activity;
    TextView productTitle,fst_item,scnd_item,thrd_item,frth_item;
    public static int cart_postion;
    CartTable  cartTable;
    AddToCartModel cartModel;
    TempTable db;
    public ProductQuantityDialog(Activity a)
    {
        super(a);
        this.activity=a;
        cartModel=new AddToCartModel();
        db=new TempTable(activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.product_quantity_dialog);
        productTitle=(TextView)findViewById(R.id.tv_title_productQuantity);
        fst_item=(TextView)findViewById(R.id.tv_fst_item_pq);
        scnd_item=(TextView)findViewById(R.id.scnd_item_pq);
        thrd_item=(TextView)findViewById(R.id.third_item_pq);
        frth_item=(TextView)findViewById(R.id.frth_item_pq);
        cart_postion=ProductDetails.index;

        productTitle.setText(Shop.arrayList.get(cart_postion).getTitle());
        fst_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(activity)
                        .setTitle("Congrats !")
                        .setText("successfully added to cart...")
                        .setTitleAppearance(R.style.AlertTextAppearance_Title)
                       .setBackgroundColorInt(Color.CYAN)
                        .setIcon(R.drawable.alerter_ic_notifications)
                        .enableSwipeToDismiss()
                        .setIconColorFilter(0)
                        .setDuration(2000)
                        .show();
                cartModel.setCart_position(cart_postion);
                boolean db1=  db.insertData(cartModel);
                if (db1==true)
                {
                    Toast.makeText(activity, "position successfully added to cart", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, "position Insertion failed", Toast.LENGTH_SHORT).show();
                }
//             boolean db =  cartTable.insertData(cart_postion);
//             if (db==true)
//             {
//                 Toast.makeText(activity, "insertion success", Toast.LENGTH_SHORT).show();
//             }else Toast.makeText(activity, "insert failed", Toast.LENGTH_SHORT).show();
//                dismiss();
            }
        });
        scnd_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(activity)
                        .setTitle("Congrats !")
                        .setText("successfully added to cart...")
                        .setTitleAppearance(R.style.AlertTextAppearance_Title)
                        .setBackgroundColorInt(Color.parseColor("#ff1744"))
                        .setIcon(R.drawable.alerter_ic_notifications)
                        .enableSwipeToDismiss()
                        .setIconColorFilter(0)
                        .setDuration(2000)
                        .show();
//                cartTable=new CartTable(activity);
//                Toast.makeText(activity, "successfully added to cart", Toast.LENGTH_SHORT).show();
//                boolean db =  cartTable.insertData(cart_postion);
//                if (db==true)
//                {
//                    Toast.makeText(activity, "insertion success", Toast.LENGTH_SHORT).show();
//                }else Toast.makeText(activity, "insert failed", Toast.LENGTH_SHORT).show();


                dismiss();
            }
        });
        thrd_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerter.create(activity)
                        .setTitle("Congrats !")
                        .setText("successfully added to cart...")
                        .setTitleAppearance(R.style.AlertTextAppearance_Title)
                        .setBackgroundColorInt(Color.CYAN)
                        .setIcon(R.drawable.alerter_ic_notifications)
                        .enableSwipeToDismiss()
                        .setIconColorFilter(0)
                        .setDuration(2000)
                        .show();
                Toast.makeText(activity, "successfully added to cart", Toast.LENGTH_SHORT).show();
               // cartTable.insertData(cart_postion);

                dismiss();
            }
        });
        frth_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "successfully added to cart", Toast.LENGTH_SHORT).show();
               // cartTable.insertData(cart_postion);
                dismiss();
            }
        });

    }
}
