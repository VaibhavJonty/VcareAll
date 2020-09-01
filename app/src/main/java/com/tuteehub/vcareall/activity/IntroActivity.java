package com.tuteehub.vcareall.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.tuteehub.vcareall.R;
import com.tuteehub.vcareall.adapter.IntroViewPagerAdapter;
import com.tuteehub.vcareall.utils.InkPageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;


public class IntroActivity extends AppCompatActivity {
    private static final String TAG = "IntroActivity";
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    InkPageIndicator indicator;
    @BindView(R.id.layoutDots)
    LinearLayout layoutDots;

    private int[] layouts;
    private IntroViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);


        //Adding the slides in the Array (int[]) named layouts;
        layouts = new int[]{
                R.layout.slide_1,
                R.layout.slide_1,
                R.layout.slide_1
        };

        changeStatusBarColor();

        //Setting the ViewPager and indicator.
        viewPagerAdapter = new IntroViewPagerAdapter(layouts, this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setAdapter(viewPagerAdapter);
        indicator.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }


    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // channging the skip and back button visibility when required. Launching the Welcome Screen.
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT

                indicator.setVisibility(View.INVISIBLE);
            } else {
                // still pages are left
                indicator.setVisibility(View.VISIBLE);

            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };


}
