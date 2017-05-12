package com.example.vyphe.custome;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by user on 13-May-17.
 */

public class VypheEditText extends android.support.v7.widget.AppCompatEditText {

    public VypheEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public VypheEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VypheEditText(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "Montserrat-Regular.ttf");
        setTypeface(tf, 1);
    }
}
