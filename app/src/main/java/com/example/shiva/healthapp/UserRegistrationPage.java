package com.example.shiva.healthapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiva.healthapp.enums.URL;
import com.example.shiva.healthapp.network.HttpClient;

import org.json.JSONException;
import org.json.JSONObject;

public class UserRegistrationPage extends AppCompatActivity {
private EditText et_u_name,et_f_name,et_lst_name,et_pass,et_email,et_mobile;
private String userName,fName,lName,Password,email,mobile;
Button submit_btn;
ImageView goHome_iv;
TextView show_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration_page);
        et_u_name=(EditText)findViewById(R.id.et_uName_rp);
        et_f_name=(EditText)findViewById(R.id.et_firstName_rp);
        et_lst_name=(EditText)findViewById(R.id.et_lastName_rp);
        et_pass=(EditText)findViewById(R.id.et_password_rp);
        et_email=(EditText)findViewById(R.id.et_email_rp);
        et_mobile=(EditText)findViewById(R.id.et_mobile_rp);
        submit_btn=(Button)findViewById(R.id.btn_submit_rp);
        goHome_iv=(ImageView)findViewById(R.id.iv_toolbar_rp);
        show_pass=(TextView)findViewById(R.id.tv_show_pass);
        show_pass.setVisibility(View.GONE);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_u_name.getText().toString().equals(""))
                {
                    et_u_name.setError("fill the blanks");
                }else if (et_f_name.getText().toString().equals(""))
                {
                    et_f_name.setError("fill the blanks");
                }else if (et_lst_name.getText().toString().equals(""))
                {
                    et_lst_name.setError("fill the blanks");
                }else if (et_pass.getText().toString().equals(""))
                {
                    et_pass.setError("fill the blanks");
                }else if (et_pass.getText().toString().length()<8)
                {
                     et_pass.setError("your password must contain atleast 8 characters!");
                }
                else if(et_email.getText().toString().equals(""))
                {
                   et_email.setError("fill the blanks");
                }else if (et_email.getText().toString().length()<3)
                {
                    et_email.setError("Invalid email address!");
                }
                else if (!et_email.getText().toString().matches("[A-Z a-z 0-9_]+@.*")) {
                    et_email.setError("Invalid email address!");
                }
                else if (et_mobile.getText().toString().equals(""))
                {
                    et_mobile.setError("fill the blanks");
                }else if (et_mobile.getText().toString().length()<10 ||et_mobile.getText().toString().length()>13)
                {
                    et_mobile.setError("Invalid mobile number !");
                }
                else {
                    new RegisterTask().execute();

                }




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
                     show_pass.setVisibility(View.VISIBLE);
                 }else {
                     show_pass.setVisibility(View.GONE);
                 }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
      show_pass.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              HideShow();
          }
      });




    }
    public void HideShow()
    {
       if (show_pass.getText().toString().equals("SHOW"))
       {
           show_pass.setText("Hide");
           et_pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
       }else {
           show_pass.setText("SHOW");
           et_pass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
       }
    }
    public void goHome(View view)
    {
        startActivity(new Intent(UserRegistrationPage.this,DashBoard.class));
    }
    class RegisterTask extends AsyncTask<String,Void,Boolean>
    {
        JSONObject response;
        ProgressDialog progressDialog=new ProgressDialog(UserRegistrationPage.this);
        JSONObject jsonObject=new JSONObject();
        private String error_msg = "server error";

        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                userName=et_u_name.getText().toString();
                fName=et_f_name.getText().toString();
                lName=et_lst_name.getText().toString();
                Password=et_pass.getText().toString();
                email=et_email.getText().toString();
                mobile=et_mobile.getText().toString();
                jsonObject.put("username",userName);
                jsonObject.put("first_name",fName);
                jsonObject.put("last_name",lName);
                jsonObject.put("password",Password);
                jsonObject.put("email",email);
                jsonObject.put("mobile",mobile);
                Log.e("request", String.valueOf(jsonObject));
                response= HttpClient.SendHttpPost(URL.Sign.getURL(),jsonObject);
                Log.e("response", String.valueOf(response));
                boolean status = response != null && response.getInt("is_error") == 0;

                return status;
            } catch (JSONException e) {
                e.printStackTrace();
                progressDialog.dismiss();
                //       spinner.setVisibility(View.GONE);
                return false;
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("please wait...");
            progressDialog.isIndeterminate();
            progressDialog.show();
        }



        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
            Log.e("status", String.valueOf(status));
            progressDialog.dismiss();
            if (status) {
                Toast.makeText(getApplicationContext(),"data sent successfully",Toast.LENGTH_LONG).show();
                 et_u_name.setText("");et_f_name.setText("");et_lst_name.setText("");et_pass.setText("");et_email.setText("");et_mobile.setText("");
            } else {
                Toast.makeText(getApplicationContext(),"data sending failed",Toast.LENGTH_LONG).show();
                et_u_name.setText("");et_f_name.setText("");et_lst_name.setText("");et_pass.setText("");et_email.setText("");et_mobile.setText("");

            }
        }
    }
}
