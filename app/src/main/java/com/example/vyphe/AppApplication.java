package com.example.vyphe;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Shanthakumar on 24-02-2017.
 */

public class AppApplication extends Application {

    private static final String TAG = AppApplication.class.getCanonicalName();
    private RequestQueue mRequestQueue;
    private static AppApplication mInstance;

    public AppApplication() {
        mInstance = this;
    }

    public static AppApplication getInstance() {
        if (mInstance == null) {
            mInstance = new AppApplication();
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
}
