package com.example.simplynote.new_checklist;

import com.example.simplynote.base.BaseContract;

public class NewCheckListContract {

    public interface NewCheckListPresenter<V> extends BaseContract.BasePresenter<V> { }

    public interface NewCheckListView extends BaseContract.BaseView {
        void addNewRow();
        void removeRow(int id);
    }

    public static NewCheckListView NULL = new NewCheckListView() {
        @Override
        public void addNewRow() { }
        @Override
        public void removeRow(int id) { }
    };
}
