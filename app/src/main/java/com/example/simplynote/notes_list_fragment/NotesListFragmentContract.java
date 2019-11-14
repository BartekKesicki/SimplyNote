package com.example.simplynote.notes_list_fragment;

import com.example.simplynote.base.BaseContract;

public class NotesListFragmentContract {

    public interface NotesListView extends BaseContract.BaseView {}

    public interface NotesListFragmentPresenter<V> extends BaseContract.BasePresenter<V> { }

    public static NotesListView NULL = new NotesListView() { };
}
