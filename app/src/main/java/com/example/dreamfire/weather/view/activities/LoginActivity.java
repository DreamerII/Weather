package com.example.dreamfire.weather.view.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

import com.example.dreamfire.weather.App;
import com.example.dreamfire.weather.R;
import com.example.dreamfire.weather.databinding.ActivityLoginBinding;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by dreamfire on 13.07.16.
 */
public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener{
    private GoogleApiClient mGoogleApiClient;
    private int mWidth, mHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mWidth = displaymetrics.widthPixels;
        mHeight = displaymetrics.heightPixels;

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        binding.signInButton.setSize(SignInButton.SIZE_STANDARD);
        binding.signInButton.setScopes(gso.getScopeArray());

        findViewById(R.id.sign_in_button).setOnClickListener(this);


        TranslateAnimation anim = new TranslateAnimation(-mWidth, 0, 0, 0);
        TranslateAnimation anim2 = new TranslateAnimation(mWidth, 0, 0, 0);
        anim.setDuration(1000);
        anim.setFillAfter(true);
        anim2.setDuration(1000);
        anim2.setFillAfter(true);

        binding.etName.startAnimation(anim);
        binding.etPass.startAnimation(anim2);
        binding.signInButton.startAnimation(anim);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_in_button:
                signIn();
                break;
        }
    }

    private void signIn(){
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.getStatus().getStatusCode() == 0) {
                GoogleSignInAccount gsa = result.getSignInAccount();
                App.name = result.getSignInAccount().getDisplayName();
                if (gsa.getId() != null) {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }
    }
}
