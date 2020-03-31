package com.example.simplynote.checklists_fragment;

import com.example.simplynote.base.BaseContract;
import com.example.simplynote.room.model.Checklist;
import com.example.simplynote.room.model.ChecklistWithItems;

import java.util.List;

public class CheckListFragmentContract {

    public interface CheckListView extends BaseContract.BaseView {
        void showChecklistLoadFailedMessage();
        void showFetchedChecklists(List<ChecklistWithItems> checklistsWithItems);
    }

    public interface CheckListFragmentPresenter<V> extends BaseContract.BasePresenter<V> { }

    public static CheckListView NULL = new CheckListView() {
        @Override
        public void showChecklistLoadFailedMessage() { }

        @Override
        public void showFetchedChecklists(List<ChecklistWithItems> checklistsWithItems) { }
    };
}
