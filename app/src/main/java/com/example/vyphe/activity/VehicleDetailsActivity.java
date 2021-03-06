package com.example.vyphe.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.vyphe.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class VehicleDetailsActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private ActionBar mActionBar;

    private CircleImageView mIvVehicle;
    private FloatingActionButton mFbCamera;

    private static final int CAMERA_REQUEST = 1000;
    private static final int GALLERY_REQUEST = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMainContentView(R.layout.activity_vehicle_details);

        setupView();
        // Call the ActionBar customizer.
        customizeActionBar(mActionBar, mToolbar);
    }

    private void setupView() {

        mIvVehicle = (CircleImageView) findViewById(R.id.profile_image);
        mFbCamera = (FloatingActionButton) findViewById(R.id.fab_camera);
        mToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();

        mFbCamera.setOnClickListener(this);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mIvVehicle.setImageBitmap(photo);
        } else if (requestCode == GALLERY_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mIvVehicle.setImageBitmap(photo);
        }
    }

    private void showOpenImageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(VehicleDetailsActivity.this);
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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.fab_camera:
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
                break;
        }
    }
}
