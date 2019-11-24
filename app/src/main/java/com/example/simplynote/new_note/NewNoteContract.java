package com.example.simplynote.new_note;

import com.example.simplynote.base.BaseContract;

public class NewNoteContract {

    public interface NewNotePresenter<V> extends BaseContract.BasePresenter<V> {}

    public interface NewNoteView extends BaseContract.BaseView {}

    public static NewNoteView NULL = new NewNoteView() {};
}
