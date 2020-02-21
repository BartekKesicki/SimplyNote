package com.example.simplynote.notes_list_fragment;

import com.example.simplynote.base.BaseContract;
import com.example.simplynote.room.model.Note;

import java.util.List;

public class NotesListFragmentContract {

    public interface NotesListView extends BaseContract.BaseView {
        void showErrorMessage();
        void createListView(List<Note> notes);
    }

    public interface NotesListFragmentPresenter<V> extends BaseContract.BasePresenter<V> { }

    public static NotesListView NULL = new NotesListView() {
        @Override
        public void showErrorMessage() { }

        @Override
        public void createListView(List<Note> notes) { }
    };
}
