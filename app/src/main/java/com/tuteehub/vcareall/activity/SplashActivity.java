package com.tuteehub.vcareall.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.tuteehub.vcareall.R;


public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread background = new Thread() {
            public void run() {

                try {
                    sleep(2  * 1000);
                    startActivity(new Intent(SplashActivity.this, IntroActivity.class));
                    finish();

                } catch (Exception e) {

                }
            }
        };
        background.start();
    }



}
