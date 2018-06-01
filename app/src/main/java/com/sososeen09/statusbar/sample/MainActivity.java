package com.sososeen09.statusbar.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void normal(View view) {
        startActivity(new Intent(this, NormalActivity.class));
    }

    public void stickyLayout1(View view) {
        startActivity(new Intent(this, StickyTabLayout1Activity.class));
    }


    public void stickyLayout2(View view) {
        startActivity(new Intent(this, StickyTabLayout2Activity.class));
    }

}
