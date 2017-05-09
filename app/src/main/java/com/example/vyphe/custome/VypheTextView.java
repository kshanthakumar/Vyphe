package com.example.vyphe.custome;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by user on 4/17/2017.
 */

public class VypheTextView extends android.support.v7.widget.AppCompatTextView {

    public VypheTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public VypheTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VypheTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "Montserrat-Regular.ttf");
        setTypeface(tf ,1);
    }
}
