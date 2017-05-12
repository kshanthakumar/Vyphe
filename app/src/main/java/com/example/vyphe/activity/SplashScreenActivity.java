package com.example.vyphe.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vyphe.R;
import com.example.vyphe.util.AccessMySharedPref;
import com.example.vyphe.util.MySharedPreference;

public class SplashScreenActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            //Showing splash screen with a timer.
            @Override
            public void run() {
                // This method will be executed once the timer is over

                if (MySharedPreference.readBoolean(SplashScreenActivity.this,
                        AccessMySharedPref.IS_USER_LOGGED_IN, false)) {
                    // User already login start app home activity
                    Intent i = new Intent(SplashScreenActivity.this, LandingActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    // Start app login activity
                    Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.enter, R.anim.exit);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}
