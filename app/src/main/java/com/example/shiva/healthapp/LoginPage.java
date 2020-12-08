package com.example.shiva.healthapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.shiva.healthapp.enums.URL;
import com.example.shiva.healthapp.network.HttpClient;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
*/
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import maes.tech.intentanim.CustomIntent;

public class LoginPage extends AppCompatActivity {
    private static final int RC_SIGN_IN = 1;
    private static final String TAG ="LoginActivity" ;
    LoginButton loginButton;
    private CallbackManager callbackManager;
    FacebookCallback<LoginResult> callback;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    RelativeLayout relativeLayout;
    Button login;
    String user_id;
    TextView user_Register;
    JSONArray array=new JSONArray();
    TextView all;
    EditText et_email,et_pass;
    String loginEmail,loginPass;
    TextView tv_show;
    TextView tv__marque;
    SignInButton signInButton;
    FirebaseAuth firebaseAuth;
    GoogleApiClient mGoogleApiClient;
   // AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     /*   if (Build.VERSION.SDK_INT>=19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }*/
        setContentView(R.layout.activity_login_page);
        firebaseAuth=FirebaseAuth.getInstance();
      /*  MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        adView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().addTestDevice("DA49242D265BF42E1A1AD028E371A2B9").build();
        adView.loadAd(adRequest);
        */
      tv__marque=(TextView)findViewById(R.id.tv_marque);
      tv__marque.setSelected(true);
        user_Register=(TextView)findViewById(R.id.tv_register_now);
        all=(TextView)findViewById(R.id.already);
        et_email=(EditText)findViewById(R.id.et_login_email);
        et_pass=(EditText)findViewById(R.id.et_login_password);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        tv_show=(TextView)findViewById(R.id.tv_et_show);
        tv_show.setText("SHOW");
        tv_show.setVisibility(View.GONE);
        et_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (et_pass.getText().length()>0)
                {
                   tv_show.setVisibility(View.VISIBLE);
                }else {
                    tv_show.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        tv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               HideShow();
            }
        });
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_email.getText().toString().equals(""))
                {
                    et_email.setError("blank is not excepted");
                }else if (et_email.getText().toString().length()<3)
                {
                    et_email.setError("Invalid Adress");
                } else if (!et_email.getText().toString().matches("[A-Z a-z 0-9_]+@.*")) {
                    et_email.setError("Invalid Adress");
                } else if (et_pass.getText().toString().equals("")) {
                        et_pass.setError("blank is not excepted");
                    } else if (et_pass.getText().toString().length()<3){
                       et_pass.setError("The password must contain atleast 8 characters!");
                    }else {
                    new LoginTask().execute();
                }

               // startActivity(new Intent(LoginPage.this,DashBoard.class));
              //  CustomIntent.customType(getApplicationContext(),"up-to-bottom");
            }
        });
       /* relativeLayout=(RelativeLayout)findViewById(R.id.root_layout);
        AnimationDrawable animationDrawable=(AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager=CallbackManager.Factory.create();

        accessTokenTracker=new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };
        profileTracker=new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                 displayMessage(currentProfile);
            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();
        callback=new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();
                displayMessage(profile);


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        };
        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager,callback);
        signInButton=(SignInButton)findViewById(R.id.google_btn);
        signIngso();
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                google_sign_in_process();
            }
        });
    }
    private  void signIngso()
    {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient=new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
    }

    private void google_sign_in_process() {

        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess())
            {
                GoogleSignInAccount account=result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            }else {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed");
                // ...
            }
        }

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                              startActivity(new Intent(LoginPage.this,DashBoard.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginPage.this,"login failed",Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    private void displayMessage(Profile profile) {
        if (profile != null) {
            user_id=profile.getId();
            new SendUserId().execute();
           /* textView.setText(profile.getName());
           // String url = profile.getProfilePictureUri(150, 150).toString();
            //  Glide.with(getApplicationContext()).load(url).error(R.id.profile_image).into(imageView);
          //  Glide.with(MainActivity.this).load(url).asBitmap().into(new BitmapImageViewTarget(imageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circleImage= RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(),resource);
                    circleImage.setCircular(true);
                   // imageView.setImageDrawable(circleImage)

                }
            });*/
        }


    }
    public void userRegister(View view)
    {
         startActivity(new Intent(LoginPage.this,UserRegistrationPage.class));
    }


    protected void onStop () {
        super.onStop();
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
       // displayMessage(profile);
    }
    public class SendUserId extends AsyncTask<String,Void,Boolean>
    {
        JSONObject response;
        ProgressDialog progressDialog=new ProgressDialog(LoginPage.this);
        JSONObject jsonObject=new JSONObject();

        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                jsonObject.put("facebook_id",user_id);
                Log.e("request", String.valueOf(jsonObject));
                response= HttpClient.SendHttpPost(URL.Facebook.getURL(),jsonObject);
                Log.e("response", String.valueOf(response));
                boolean status = response != null && response.getInt("is_error") == 0;
               String fbid=response.getString("facebook_id");
                UserSession session=new UserSession(LoginPage.this);
                session.setFacebookId(fbid);
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
            if (status)
            {
                Toast.makeText(LoginPage.this,"success",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),DashBoard.class));
                finish();
            }else {
                Toast.makeText(LoginPage.this,"failed",Toast.LENGTH_LONG).show();
            }
        }
    }
    public class LoginTask extends AsyncTask<String,Void,Boolean> {
        JSONObject response1;
        ProgressDialog progressDialog = new ProgressDialog(LoginPage.this);
        JSONObject jsonObject2 = new JSONObject();
        String eror_msg;
        String success_msg;
        int is_error;
        String email;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("please wait...");
            progressDialog.isIndeterminate();
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(String... strings) {

            try {
                  loginEmail=et_email.getText().toString();
                  loginPass=et_pass.getText().toString();
                  jsonObject2.put("email",loginEmail);
                  jsonObject2.put("password",loginPass);
                  Log.e("request", String.valueOf(jsonObject2));
                response1 = HttpClient.SendHttpPost(URL.Login.getURL(), jsonObject2);

                Log.e("response1", String.valueOf(response1));
                boolean status = response1 != null && response1.getInt("is_error") == 0;
                is_error=response1.getInt("is_error");
                if (is_error==0)
                {
                    success_msg=response1.getString("success_msg");
                    String userId=response1.getString("id");
                    UserSession userSession=new UserSession(LoginPage.this);
                    userSession.setUserId(userId);
                    userSession.setEmail(loginEmail);
                }else{
                    eror_msg=response1.getString("err_msg");
                }
                return status;
            } catch (JSONException e) {
                e.printStackTrace();
                progressDialog.dismiss();
                //       spinner.setVisibility(View.GONE);
                return false;

            }


        }

        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
            progressDialog.dismiss();
            if (status)
            {
                Toast.makeText(LoginPage.this,""+success_msg,Toast.LENGTH_LONG).show();
                UserSession session=new UserSession(LoginPage.this);
                session.setEmail(loginEmail);
                et_email.setText("");
                et_pass.setText("");
                startActivity(new Intent(getApplicationContext(),DashBoard.class));
            }else {
                Toast.makeText(LoginPage.this,""+eror_msg,Toast.LENGTH_LONG).show();
                et_email.setText("");
                et_pass.setText("");
            }
        }
    }
}
