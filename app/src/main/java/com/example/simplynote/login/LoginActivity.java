package com.example.simplynote.login;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseContract;

public class LoginActivity extends AppCompatActivity implements BaseContract.BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
