package com.example.simplynote.new_checkilist;

import com.example.simplynote.base.BaseContract;

public class NewCheckListContract {

    public interface NewCheckListPresenter<V> extends BaseContract.BasePresenter<V> { }

    public interface NewCheckListView extends BaseContract.BaseView { }

    public static NewCheckListView NULL = new NewCheckListView() {};
}
