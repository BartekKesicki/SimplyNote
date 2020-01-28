package com.example.simplynote.new_checklist;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.simplynote.new_note.NewNoteActivityPresenter;
import com.example.simplynote.repository.ChecklistItemRepository;
import com.example.simplynote.repository.ChecklistRepository;
import com.example.simplynote.room.model.Checklist;
import com.example.simplynote.room.model.ChecklistItem;
import com.example.simplynote.utils.BaseScheduler;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

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
        final List<String> items = retrieveCheckListItems(checkListContainer);
        if (TextUtils.isEmpty(checkListName)) {
            view.showNoCheckListNameErrorMessage();
            return;
        }
        if (items.isEmpty()) {
            view.showNoCheckListNameErrorMessage();
            return;
        }
        Checklist checklist = createChecklist(checkListName);
        checklistRepository.insert(checklist)
                .subscribeOn(baseScheduler.io())
                .observeOn(baseScheduler.main())
                .subscribe(new SingleObserver<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onSuccess(Long id) {
                        List<ChecklistItem> checklistItems = createChecklistItems(items, id);
                        insertChecklistItems(checklistItems, id);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //todo error message
                    }
                });
    }

    private void insertChecklistItems(List<ChecklistItem> items, long id) {
        checklistItemRepository.insert(items)
                .subscribeOn(baseScheduler.io())
                .observeOn(baseScheduler.main())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onComplete() {
                        //todo redirect to main page
                    }

                    @Override
                    public void onError(Throwable e) {
                        //todo error message
                    }
                });
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

    private Checklist createChecklist(String checklistName) {
        Checklist checklist = new Checklist();
        checklist.setCreationTime(System.currentTimeMillis());
        checklist.setName(checklistName);
        return checklist;
    }

    private List<ChecklistItem> createChecklistItems(List<String> checklistItems, long checkListId) {
        List<ChecklistItem> items = new ArrayList<ChecklistItem>();
        for (String itemContent : checklistItems) {
            ChecklistItem item = new ChecklistItem();
            item.setCheckListId(checkListId);
            item.setContent(itemContent);
            items.add(item);
        }
        return items;
    }

    @Override
    public void detach() {
        this.view = NewCheckListContract.NULL;
    }
}
