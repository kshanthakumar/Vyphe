package com.example.vyphe.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.example.vyphe.R;

public class BaseActivity extends AppCompatActivity {

    protected static final String TAG = BaseActivity.class.getSimpleName();

    /**
     * Our primary toolbar that is going to be made
     * the ActionBar.
     */
    private Toolbar mToolbar;

    /**
     * The actual ActionBar instance.
     */
    private ActionBar mActionBar;

    /**
     * The layout holding the ToolBar (ActionBar) and TabLayout if any.
     * This layout allows us to control scroll behavior or the child elements
     * and its motion more easily and gracefully.
     */
    protected AppBarLayout mAppBarLayout;

    /**
     * The layout that is going to hold the actual content of the activity,
     * fragment, tab etc.
     */
    private FrameLayout mFlContentLayout;

    /**
     * Instance of Alert dialog to ensure dismiss of the dialog can be
     * handled separately.
     */
    protected AlertDialog mAlertDialog;

    /**
     * Floating Action button on each screen. To be used if necessary.
     * By default, VISIBILITY of this item is set to GONE since not all
     * screens would actually need this functionality.
     */
    protected FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        // Initialize the toolbar layout and assign it as the Action Bar for
        // all screens.
        mToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();

        mFlContentLayout = (FrameLayout) findViewById(R.id.base_FlContent);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.base_AppBar);

        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        // Call the ActionBar customizer. We do the basic setup. Child activities
        // can override this function to get better control over the action bar.
        // The action bar and toolbar instances should not be misused anywhere else.
        // Hence made private and setup here. Child activities can save a local instance
        // of action bar from here on. But they cannot manipulate before this level.
        customizeActionBar(mActionBar, mToolbar);
    }

    /**
     * Method to customize the action bar based on each activity's needs.
     */
    protected void customizeActionBar(ActionBar actionBar, Toolbar toolbar) {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle("");
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
    }

    public final void setActionBarTitle(String title) {
        mActionBar.setTitle(title);
    }

    // ----------------------------------------------
    // - LAYOUT STRUCTURE CHANGES
    // ----------------------------------------------

    /**
     * Sets the content view for this activity. Since we are using navigation
     * bar, content view cannot be used as before.
     *
     * @param view View to be set for the fragment or layout that is to be shown
     *             as the main content layout.
     */
    protected final void setMainContentView(View view) {
        try {
            if (mFlContentLayout != null) {
                mFlContentLayout.addView(view);
            }
        } catch (Exception e) {
           /* Logger.d(e.getLocalizedMessage());
            Logger.d(e.getMessage());*/
        }
    }

    /**
     * Sets the content view for this activity. Since we are using navigation
     * bar, content view cannot be used as before.
     *
     * @param layout Layout to be set for the fragment or layout that is to be shown
     *               as the main content layout.
     */
    protected final void setMainContentView(int layout) {
        try {
            if (mFlContentLayout != null) {
                //Logger.d(TAG, "setMainContentView - setting the Layout with ID: "+layout);
                mFlContentLayout.addView(getLayoutInflater().inflate(layout, null));
            }
        } catch (Exception e) {
            /*Logger.d(e.getLocalizedMessage());
            Logger.d(e.getMessage());*/
        }
    }

    public void showOkayAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle()
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mAlertDialog.dismiss();
                    }
                });
        mAlertDialog = builder.create();
        mAlertDialog.show();
    }
}
