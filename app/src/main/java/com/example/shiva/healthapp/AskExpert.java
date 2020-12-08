package com.example.shiva.healthapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AskExpert extends AppCompatActivity {
EditText et_phone,et_email;
Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_expert);
        et_phone=(EditText)findViewById(R.id.et_phone_askExpert);
        et_email=(EditText)findViewById(R.id.et_email_askExpert);
        btn_submit=(Button)findViewById(R.id.btn_submit_askExpert);

    }
    public class sendQueryTask extends AsyncTask<String,Void,Boolean>
    {

        @Override
        protected Boolean doInBackground(String... strings) {
            return null;
        }
    }
}
