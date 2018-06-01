package com.sososeen09.statusbar.sample;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends AppCompatActivity {

    RecyclerView rv;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusHeight = StatusBarUtils.getStatusBarHeight(this);
        setContentView(R.layout.activity_normal);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }


        //透明状态栏/导航栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        //这样的效果跟上述的主题设置效果类似
        getWindow().getDecorView().setFitsSystemWindows(true);

        rv = findViewById(R.id.rv);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        mMyAdapter = new MyAdapter(list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        mMyAdapter.bindToRecyclerView(rv);
        mMyAdapter.addHeaderView(LayoutInflater.from(this).inflate(R.layout.item_header, rv, false));

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //如果当前的RecyclerView的第一个子View不是Adapter的header，就要显示浮层
                View childAt = rv.getChildAt(0);
                if (childAt != mMyAdapter.getHeaderLayout()) {
                    showMaskOnce();
                } else {
                    //如果当前的RecyclerView的第一个子View是Adapter的header，需要根据滚动的距离来判断
                    if (childAt.getTop() + statusHeight <= 0) {
                        showMaskOnce();
                    } else {
                        //状态栏隐藏蒙版
                        hideMaskOnce();
                    }
                }
            }
        });
    }

    private boolean hasShowMasking = false;
    private int statusHeight = 0;

    private void showMaskOnce() {
        if (!hasShowMasking) {
            hasShowMasking = true;
            showMask();
        }
    }

    private void hideMaskOnce() {
        if (hasShowMasking) {
            hasShowMasking = false;
            hideMask();
        }
    }

    private void showMask() {
        StatusBarUtils.showStatusMasking(this, Color.BLACK);
    }

    private void hideMask() {
        StatusBarUtils.hideStatusMasking(this);
    }

    private class MyAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {
        public MyAdapter(@Nullable List<Integer> data) {
            super(R.layout.item_test, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Integer item) {
            helper.setText(R.id.tv, "text: " + item);
        }
    }

}

