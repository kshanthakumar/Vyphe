package com.example.vyphe.activity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.vyphe.R;

public class UserVerifyActivity extends BaseActivity {

    private Toolbar mToolbar;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMainContentView(R.layout.activity_user_verify);

        setupView();
        // Call the ActionBar customizer.
        customizeActionBar(mActionBar, mToolbar);
    }


    private void setupView() {

        mToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Method to customize the action bar based on activity's needs.
     */
    protected void customizeActionBar(ActionBar actionBar, Toolbar toolbar) {

        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        // To hide action bar home icon
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        actionBar.setTitle(getResources().getString(R.string.verify_user));
    }
}
