package com.example.simplynote.new_checklist;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.simplynote.new_note.NewNoteActivityPresenter;
import com.example.simplynote.repository.ChecklistItemRepository;
import com.example.simplynote.repository.ChecklistRepository;
import com.example.simplynote.utils.BaseScheduler;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NewChecklistActivityPresenter implements NewCheckListContract.NewCheckListPresenter<NewCheckListContract.NewCheckListView> {

    private static final int FIRST_INDEX = 0;

    private NewCheckListContract.NewCheckListView view;

    private ChecklistRepository checklistRepository;

    private ChecklistItemRepository checklistItemRepository;

    private BaseScheduler baseScheduler;

    @Inject
    public NewChecklistActivityPresenter(ChecklistRepository checklistRepository, ChecklistItemRepository checklistItemRepository, BaseScheduler baseScheduler) {
        this.checklistRepository = checklistRepository;
        this.checklistItemRepository = checklistItemRepository;
        this.baseScheduler = baseScheduler;
    }

    @Override
    public void attach(NewCheckListContract.NewCheckListView view) {
        this.view = view;
    }

    public void performAddNewChecklistRow() {
        view.addNewRow();
    }

    public void submitChecklistForm(LinearLayout checkListContainer, String checkListName) {
        List<String> items = retrieveCheckListItems(checkListContainer);
        if (TextUtils.isEmpty(checkListName)) {
            view.showNoCheckListNameErrorMessage();
            return;
        }
        if (items.isEmpty()) {
            view.showNoCheckListNameErrorMessage();
            return;
        }
        //todo insertion of checklist
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
