package com.example.vyphe.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.vyphe.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLlGoogleLogin;
    private LinearLayout mLlFacebookLogin;
    private ImageView mIvLoginLogo;
    private TextView mTvSignUp;
    private static int LOGO_TIME_OUT = 100;
    private static int SIGN_TIME_OUT = 1000;
    private static int LOGIN_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupView();
        startLogoAnimation();
        startSingUpAnimation();
        startLoginAnimation();
    }

    private void startLogoAnimation() {

        mIvLoginLogo.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(LoginActivity.this,
                        R.anim.fade_in);
                mIvLoginLogo.startAnimation(animation);
            }
        }, LOGO_TIME_OUT);
    }

    private void startSingUpAnimation() {

        mTvSignUp.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(LoginActivity.this,
                        R.anim.fade_in);
                mTvSignUp.startAnimation(animation);
            }
        }, SIGN_TIME_OUT);
    }

    private void startLoginAnimation() {

        mLlGoogleLogin.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(LoginActivity.this,
                        R.anim.fade_in);

                mLlGoogleLogin.startAnimation(animation);
                mLlFacebookLogin.startAnimation(animation);
            }
        }, LOGIN_TIME_OUT);

    }

    private void setupView() {

        mIvLoginLogo = (ImageView) findViewById(R.id.login_logo);
        mTvSignUp = (TextView) findViewById(R.id.sign_up);
        mLlGoogleLogin = (LinearLayout) findViewById(R.id.google_login);
        mLlFacebookLogin = (LinearLayout) findViewById(R.id.facebook_login);

        mLlGoogleLogin.setOnClickListener(this);
        mLlFacebookLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.google_login:
                startActivity(new Intent(LoginActivity.this, UserVerifyActivity.class));
                break;
            case R.id.facebook_login:
                startActivity(new Intent(LoginActivity.this, VehicleDetailsActivity.class));
                break;
        }
    }
}
