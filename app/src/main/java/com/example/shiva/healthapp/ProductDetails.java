package com.example.shiva.healthapp;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductDetails extends AppCompatActivity {
ImageView iv_productDetails;
TextView tv_title,tv_price,tv_desc;
public static int index;
EditText et_comment;
ImageView iv_send;
String comments;
RvCommentProdDetail adapter;
RecyclerView recyclerView;
ArrayList<String> list=new ArrayList<>();
RelativeLayout add_to_cart;
TextView tv_oldAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        iv_productDetails=(ImageView)findViewById(R.id.iv_productDetails);
        tv_title=(TextView)findViewById(R.id.tv_title_ProductDetails);
        tv_price=(TextView)findViewById(R.id.tv_price_productDetails);
        tv_desc=(TextView)findViewById(R.id.tv_desc_ProductDetails);
        recyclerView=(RecyclerView)findViewById(R.id.rv_productDetails);
        et_comment=(EditText)findViewById(R.id.et_review_productDetails);
        tv_oldAmount=(TextView)findViewById(R.id.tv_old_amount);
        tv_oldAmount.setPaintFlags(tv_oldAmount.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        add_to_cart=(RelativeLayout)findViewById(R.id.layout_addToCart);
        iv_send=(ImageView)findViewById(R.id.iv_send_productDetails);
        iv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comments=et_comment.getText().toString();
                list.add(comments);
                adapter=new RvCommentProdDetail(ProductDetails.this,list);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(ProductDetails.this));
                et_comment.setText("");
            }
        });
        addTocart();

        details();
    }
    public void addTocart()
    {
        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductQuantityDialog quantityDialog=new ProductQuantityDialog(ProductDetails.this);
                quantityDialog.show();
            }
        });
    }
    public void details()
    {
        Intent intent=getIntent();
        index=intent.getIntExtra("index",0);
        iv_productDetails.setImageResource(Shop.arrayList.get(index).getImage());
        tv_title.setText(Shop.arrayList.get(index).getTitle());
        tv_price.setText(Shop.arrayList.get(index).getAmount());
        tv_desc.setText(Shop.arrayList.get(index).getDesc());
    }
}
