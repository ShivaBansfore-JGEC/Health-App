package com.example.shiva.healthapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TrainerSignUp extends AppCompatActivity {
ImageView select;
private static int IMAGE=1;
Bitmap bitmap;
ImageView imageView;
EditText et_pass;
TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_sign_up);
        select=(ImageView) findViewById(R.id.btn_select);
        imageView=(ImageView)findViewById(R.id.iv_upload);
        et_pass=(EditText)findViewById(R.id.et_pass_train_signUp);
        tv_show=(TextView)findViewById(R.id.text_show);
        tv_show.setVisibility(View.GONE);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
        et_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et_pass.length()>0)
                {
                    tv_show.setVisibility(View.VISIBLE);
                }else {
                    tv_show.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HideShow();
            }
        });

    }
    public void HideShow()
    {
        if (tv_show.getText().equals("SHOW"))
        {
            tv_show.setText("Hide");
            et_pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            et_pass.setSelection(et_pass.length());

        }else {
            tv_show.setText("SHOW");
            et_pass.setInputType(InputType.TYPE_CLASS_TEXT |InputType.TYPE_TEXT_VARIATION_PASSWORD);
            et_pass.setSelection(et_pass.length());
        }
    }

    private void selectImage()
    {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==IMAGE && resultCode==RESULT_OK && data!=null)
        {
            Uri path=data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //To Upload Image IN DATABASE

//    public void Upload()
//    {
//        StringRequest request=new StringRequest(Request.Method.POST, "http://192.168.43.47/myproject/image_upload.php", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.e("respons",response);
//                imageView.setImageResource(0);
//                imageView.setVisibility(View.GONE);
//                et_image_name.setText("");
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                String name=et_image_name.getText().toString();
//                Map<String,String> params=new HashMap<>();
//                params.put("name",name);
//                params.put("image",ImageToString(bitmap));
//                return params;
//            }
//        };
//        MysingleTon.getInstance(getApplicationContext()).addToRequestQue(request);
//    }

    //To convert image into String....

//    public String ImageToString(Bitmap bitmap)
//    {
//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
//        byte[] imagebytes=byteArrayOutputStream.toByteArray();
//        return Base64.encodeToString(imagebytes,Base64.DEFAULT);
//    }
    //To load image from database

//    imageView=(ImageView)findViewById(R.id.iv_server_image);
//        btn_srv.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            ImageRequest imageRequest=new ImageRequest("http://192.168.43.47/myproject/upload/image2.jpg", new Response.Listener<Bitmap>() {
//                @Override
//                public void onResponse(Bitmap response) {
//                    imageView.setImageBitmap(response);
//                }
//            }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(getApplicationContext(),"something went wrong"+error,Toast.LENGTH_LONG).show();
//                    error.printStackTrace();
//                }
//            });
//            MysingleTon.getInstance(getApplicationContext()).addToRequestQue(imageRequest);
//        }
//    });
}
