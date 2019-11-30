package com.example.simplynote.new_note;

import com.example.simplynote.base.BaseContract;

public class NewNoteContract {

    public interface NewNotePresenter<V> extends BaseContract.BasePresenter<V> {}

    public interface NewNoteView extends BaseContract.BaseView {
        void setTitleError();
        void setContentError();
        void clearAllErrors();
        void redirectToHomePage();
        void displayNoteInsertionFailureMessage();
        void displaySuccessNoteInsertionMessage();
    }

    public static NewNoteView NULL = new NewNoteView() {
        @Override
        public void setTitleError() { }
        @Override
        public void setContentError() { }
        @Override
        public void clearAllErrors() { }
        @Override
        public void redirectToHomePage() { }
        @Override
        public void displayNoteInsertionFailureMessage() { }
        @Override
        public void displaySuccessNoteInsertionMessage() { }
    };
}
