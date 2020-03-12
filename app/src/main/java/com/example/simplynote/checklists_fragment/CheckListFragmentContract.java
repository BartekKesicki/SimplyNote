package com.example.simplynote.checklists_fragment;

import com.example.simplynote.base.BaseContract;
import com.example.simplynote.room.model.Checklist;

import java.util.List;

public class CheckListFragmentContract {

    public interface CheckListView extends BaseContract.BaseView {
        void showChecklistLoadFailedMessage();
        void showFetchedChecklists(List<Checklist> checklists);
    }

    public interface CheckListFragmentPresenter<V> extends BaseContract.BasePresenter<V> { }

    public static CheckListView NULL = new CheckListView() {
        @Override
        public void showChecklistLoadFailedMessage() { }

        @Override
        public void showFetchedChecklists(List<Checklist> checklists) { }
    };
}
