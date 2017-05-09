package com.example.vyphe.activity;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.vyphe.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserVerifyActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private ActionBar mActionBar;

    private CircleImageView mIvProfile;
    private FloatingActionButton mFbCamera;

    private static final int CAMERA_REQUEST = 1000;
    private static final int GALLERY_REQUEST = 2000;
    private static final int REQUEST_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMainContentView(R.layout.activity_user_verify);

        /*RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mToolbar.getLayoutParams();
        layoutParams.height = 42;
        mToolbar.setLayoutParams(layoutParams);*/
        setupView();
        // Call the ActionBar customizer.
        customizeActionBar(mActionBar, mToolbar);
        requestCameraPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CAMERA) {
            if (grantResults.length == 1
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            }
        }
    }

    private void requestCameraPermission() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
        }

    }

    private void setupView() {

        mIvProfile = (CircleImageView) findViewById(R.id.profile_image);
        mFbCamera = (FloatingActionButton) findViewById(R.id.fab_camera);
        mToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();

        mFbCamera.setOnClickListener(this);
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
        actionBar.setDisplayShowTitleEnabled(false);
        // To hide action bar home icon
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        actionBar.setTitle(getResources().getString(R.string.verify_user));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mIvProfile.setImageBitmap(photo);
        } else if (requestCode == GALLERY_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mIvProfile.setImageBitmap(photo);
        }
    }

    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.fab_camera:
                showOpenImageDialog();
                break;
        }
    }

    private void showOpenImageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(UserVerifyActivity.this);
        builder.setTitle(getString(R.string.open_gallery_title));
        builder.setMessage(getString(R.string.open_gallery_message));

        String positiveText = getString(R.string.camera);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, CAMERA_REQUEST);
                    }
                });

        String negativeText = getString(R.string.gallery);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        intent.setType("image/*");
                        startActivityForResult(intent, GALLERY_REQUEST);
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }

    private void showAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(UserVerifyActivity.this);
        builder.setTitle(getString(R.string.exit));
        builder.setMessage(getString(R.string.exit_alert_title));

        String positiveText = getString(R.string.yes);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                        finish();
                    }
                });

        String negativeText = getString(android.R.string.no);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }
}
