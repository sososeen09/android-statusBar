package com.sososeen09.statusbar.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author sososeen09
 */
public class StickyFragment1 extends Fragment {

    boolean first = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sticky1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        AppBarLayout appBarLayout = view.findViewById(R.id.appbar);

//
//        if (ViewCompat.getFitsSystemWindows(appBarLayout)) {
//            ViewCompat.setOnApplyWindowInsetsListener(appBarLayout, new OnApplyWindowInsetsListener() {
//                @Override
//                public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
//                    if (first) {
//                        first = false;
//                        return ViewCompat.dispatchApplyWindowInsets(tabLayout, insets);
//                    }else {
//                        return insets;
//                    }
//                }
//            });
//        }
//
//        ViewCompat.setOnApplyWindowInsetsListener(tabLayout, new OnApplyWindowInsetsListener() {
//            @Override
//            public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
//                return insets.consumeSystemWindowInsets();
//            }
//        });
    }


}
