package com.example.simplynote.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity implements MainContract.MainView {

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.attach(this);
    }
}
