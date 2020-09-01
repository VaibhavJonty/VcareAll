package com.tuteehub.vcareall.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.tuteehub.vcareall.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.imgMenu)
    AppCompatImageView imgMenu;
    @BindView(R.id.editUsername)
    TextInputEditText editUsername;
    @BindView(R.id.editEmail)
    TextInputEditText editEmail;
    @BindView(R.id.editPassword)
    TextInputEditText editPassword;
    @BindView(R.id.spCountry)
    MaterialAutoCompleteTextView spCountry;
    @BindView(R.id.spCity)
    MaterialAutoCompleteTextView spCity;
    @BindView(R.id.btnSignUp)
    MaterialButton btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSignUp)
    public void onViewClicked() {
        startActivity(new Intent(SignUpActivity.this, FeedActivity.class));
    }
}