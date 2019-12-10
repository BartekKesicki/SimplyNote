package com.example.simplynote.new_checklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;
import com.example.simplynote.utils.ChecklistItemManager;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class NewCheckListActivity extends BaseActivity implements NewCheckListContract.NewCheckListView {

    public static void start(Context context) {
        Intent intent = new Intent(context, NewCheckListActivity.class);
        context.startActivity(intent);
    }

    @Inject
    ChecklistItemManager checklistItemManager;

    @Inject
    NewChecklistActivityPresenter presenter;

    @BindView(R.id.submit_button) Button submitButton;

    @BindView(R.id.new_item_button) Button newItemButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_checklist);
        super.bind();
        presenter.attach(this);
        setListeners();
    }

    private void setListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.submitChecklistForm();
            }
        });

        newItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.performAddNewChecklistRow();
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public void addNewRow() {
        //todo implement
    }

    @Override
    public void removeRow(int id) {
        //todo implement
    }
}
