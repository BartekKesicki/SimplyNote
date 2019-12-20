package com.example.simplynote.new_checklist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;
import com.example.simplynote.utils.ChecklistItemManager;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class NewCheckListActivity extends BaseActivity implements NewCheckListContract.NewCheckListView, OnChecklistItemClickListener {

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

    @BindView(R.id.checklist_items_container) ScrollView scrollView;

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
                //todo alert dialog
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
        scrollView.addView(checklistItemManager.createNewRow());
    }

    @Override
    public void removeRow(int id) {
        scrollView.removeViewAt(id);
    }

    @Override
    public void onClick(int id) {
        //todo edit item
    }

    @Override
    public void onPerformRemove(final int id) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage(getString(R.string.new_checklist_remove_row_prompt));
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        removeRow(id);
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
