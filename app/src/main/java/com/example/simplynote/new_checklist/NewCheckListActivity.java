package com.example.simplynote.new_checklist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;
import com.example.simplynote.home.HomeActivity;
import com.example.simplynote.utils.AlertDialogManager;
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
    AlertDialogManager alertDialogManager;

    @Inject
    NewChecklistActivityPresenter presenter;

    @BindView(R.id.save_button) Button submitButton;

    @BindView(R.id.cancel_button) Button cancelButton;

    @BindView(R.id.add_new_item_button) View newItemButton;

    @BindView(R.id.checklist_items_container) LinearLayout checkListContainer;

    @BindView(R.id.new_checklist_title_edittext) EditText checklistName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_checklist);
        super.bind();
        presenter.attach(this);
        checklistItemManager.setMContext(this);
        alertDialogManager.setMContext(this);
        setListeners();
    }

    private void setListeners() {
        submitButton.setOnClickListener(view ->
                alertDialogManager.createDialog(getString(R.string.yes), getString(R.string.no),
                        (dialog, which) -> presenter.submitChecklistForm(checkListContainer, checklistName.getText().toString()),
                        (dialog, which) -> dialog.dismiss(), getString(R.string.new_checklist_submit_prompt)).show());

        cancelButton.setOnClickListener(view -> onBackPressed());

        newItemButton.setOnClickListener(view -> presenter.performAddNewChecklistRow());
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public void addNewRow() {
        int id = checkListContainer.getChildCount();
        checkListContainer.addView(checklistItemManager.createNewRow(this, id));
    }

    @Override
    public void removeRow(int id) {
        checkListContainer.removeViewAt(id);
    }

    @Override
    public void showNoCheckListNameErrorMessage() {
        alertDialogManager.createDialog(getString(R.string.ok), null, (dialog, which) -> dialog.dismiss(), null, getString(R.string.new_checklist_validation_fill_name)).show();
    }

    @Override
    public void showNoItemsErrorMessage() {
        alertDialogManager.createDialog(getString(R.string.ok), null, (dialog, which) -> dialog.dismiss(), null, getString(R.string.new_checklist_validation_fill_items)).show();
    }

    @Override
    public void showInsertionErrorMessage() {
        alertDialogManager.createDialog(getString(R.string.ok), null, (dialog, which) -> dialog.dismiss(), null, getString(R.string.new_checklist_insertion_failure_message)).show();
    }

    @Override
    public void redirectToMainPage() {
        HomeActivity.start(this);
    }

    @Override
    public void onPerformRemove(final int id) {
        alertDialogManager.createDialog(getString(R.string.yes), getString(R.string.no),
                (dialog, which) -> removeRow(id),
                (dialog, which) -> dialog.dismiss(), getString(R.string.new_checklist_remove_row_prompt)).show();
    }
}
