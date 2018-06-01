package com.sososeen09.statusbar.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author sososeen09
 */
public class StickyFragment2 extends Fragment {
    private boolean hasShowMasking = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sticky2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        AppBarLayout appBarLayout = view.findViewById(R.id.appbar);
        final CoordinatorLayout coordinatorLayout = view.findViewById(R.id.main_content);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -100) {

                    if (!coordinatorLayout.getFitsSystemWindows()) {
                        coordinatorLayout.setFitsSystemWindows(true);
                        appBarLayout.setFitsSystemWindows(true);
                        ViewCompat.requestApplyInsets(coordinatorLayout);
                    }

                    showMaskOnce();
                } else {
                    if (coordinatorLayout.getFitsSystemWindows()) {
                        coordinatorLayout.setFitsSystemWindows(false);
                        appBarLayout.setFitsSystemWindows(false);
                        ViewCompat.requestApplyInsets(coordinatorLayout);
                    }
                    hideMaskOnce();
                }
            }
        });

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
        StatusBarUtils.showStatusMasking(getActivity(), Color.BLACK);
    }

    private void hideMask() {
        StatusBarUtils.hideStatusMasking(getActivity());
    }

}
