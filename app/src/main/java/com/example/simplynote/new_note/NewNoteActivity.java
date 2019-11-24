package com.example.simplynote.new_note;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class NewNoteActivity extends BaseActivity implements NewNoteContract.NewNoteView {

    @Inject
    NewNoteActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_note);
        super.bind();
        presenter.attach(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}
