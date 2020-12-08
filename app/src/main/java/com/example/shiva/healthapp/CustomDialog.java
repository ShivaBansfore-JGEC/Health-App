package com.example.shiva.healthapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Shiva on 3/13/2018.
 */

public class CustomDialog extends Dialog{
    private Activity activity;
    TextView tv_cancel;
    ImageView share_iv;
    Intent intentShare;
    String shareBody="this a great app please try it.http://www.myapp.com";
    public CustomDialog(Activity a)
    {
        super(a);
        this.activity=a;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_discount);
        tv_cancel=(TextView)findViewById(R.id.tv_cancel);
        share_iv=(ImageView) findViewById(R.id.share_iv);
        share_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentShare=new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                intentShare.putExtra(Intent.EXTRA_SUBJECT,"My App");
                intentShare.putExtra(Intent.EXTRA_TEXT,shareBody);
               activity.startActivity(Intent.createChooser(intentShare,"share via"));
            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

}
