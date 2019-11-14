package com.example.simplynote.checklists_fragment;

import com.example.simplynote.base.BaseContract;

public class CheckListFragmentContract {

    public interface CheckListView extends BaseContract.BaseView {}

    public interface ChecListFragmentPresenter<V> extends BaseContract.BasePresenter<V> { }

    public static CheckListView NULL = new CheckListView() { };
}
