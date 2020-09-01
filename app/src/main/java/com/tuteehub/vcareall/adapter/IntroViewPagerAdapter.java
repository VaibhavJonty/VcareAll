package com.tuteehub.vcareall.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.button.MaterialButton;
import com.tuteehub.vcareall.R;
import com.tuteehub.vcareall.activity.SignUpActivity;


public class IntroViewPagerAdapter extends PagerAdapter {
    Context context;
    private LayoutInflater layoutInflater;
    private int[] layouts;
    MaterialButton btnSignUp,btnLogIn;
    public IntroViewPagerAdapter(int[] layouts, Context context) {
        this.layouts = layouts;
        this.context = context;
        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater != null ? layoutInflater.inflate(layouts[position], container, false) : null;
        btnLogIn = view.findViewById(R.id.btnLogin);
        btnSignUp = view.findViewById(R.id.btnSignUp);
        container.addView(view);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, SignUpActivity.class));
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}