package com.example.vyphe.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.vyphe.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLlGoogleLogin;
    private LinearLayout mLlFacebookLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupView();
    }

    private void setupView() {

        mLlGoogleLogin = (LinearLayout) findViewById(R.id.google_login);
        mLlFacebookLogin = (LinearLayout) findViewById(R.id.facebook_login);

        mLlGoogleLogin.setOnClickListener(this);
        mLlFacebookLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.google_login:
                Toast.makeText(LoginActivity.this, "Select Google login",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, UserVerifyActivity.class));
                break;
            case R.id.facebook_login:
                Toast.makeText(LoginActivity.this, "Select Facebook login",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, UserVerifyActivity.class));
                break;
        }
    }
}
