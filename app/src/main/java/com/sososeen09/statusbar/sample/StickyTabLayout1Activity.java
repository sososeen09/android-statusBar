package com.sososeen09.statusbar.sample;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class StickyTabLayout1Activity extends AppCompatActivity {

    private StickyFragment1 mStickyFragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_full_screen);

        mStickyFragment1 = new StickyFragment1();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, mStickyFragment1).commit();

        //效果等同于CoordinatorLayout设置fitsSystemWindows属性为true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
