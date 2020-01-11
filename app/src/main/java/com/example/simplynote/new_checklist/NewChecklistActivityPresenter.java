package com.example.simplynote.new_checklist;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class NewChecklistActivityPresenter implements NewCheckListContract.NewCheckListPresenter<NewCheckListContract.NewCheckListView> {

    private static final int FIRST_INDEX = 0;

    private NewCheckListContract.NewCheckListView view;

    @Override
    public void attach(NewCheckListContract.NewCheckListView view) {
        this.view = view;
    }

    public void performAddNewChecklistRow() {
        view.addNewRow();
    }

    public void submitChecklistForm(LinearLayout checkListContainer, String checkListName) {
        List<String> items = retrieveCheckListItems(checkListContainer);
        //todo validate name, list and submit checklist row
    }

    private List<String> retrieveCheckListItems(LinearLayout checkListContainer) {
        List<String> checklistItems = new ArrayList<>();
        for (int i = 0; i < checkListContainer.getChildCount(); i++) {
            if (checkListContainer.getChildAt(i) != null && checkListContainer.getChildAt(i) instanceof LinearLayout) {
                String checklistItem = retrieveItem((LinearLayout)checkListContainer.getChildAt(i));
                checklistItems.add(checklistItem);
            }
        }
        return checklistItems;
    }

    private String retrieveItem(LinearLayout linearLayout) {
        TextInputLayout textInputLayout = (TextInputLayout)linearLayout.getChildAt(FIRST_INDEX);
        EditText editText = (EditText) textInputLayout.getChildAt(FIRST_INDEX);
        return editText.getText().toString();
    }

    @Override
    public void detach() {
        this.view = NewCheckListContract.NULL;
    }
}
