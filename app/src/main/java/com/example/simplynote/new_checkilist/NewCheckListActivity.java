package com.example.simplynote.new_checkilist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class NewCheckListActivity extends BaseActivity implements NewCheckListContract.NewCheckListView {

    public static void start(Context context) {
        Intent intent = new Intent(context, NewCheckListActivity.class);
        context.startActivity(intent);
    }

    @Inject
    NewChecklistActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_checklist);
        super.bind();
        presenter.attach(this);
        //todo set listeners
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}
