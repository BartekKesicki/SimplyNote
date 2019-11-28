package com.example.simplynote.new_note;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class NewNoteActivity extends BaseActivity implements NewNoteContract.NewNoteView {

    @Inject
    NewNoteActivityPresenter presenter;

    @BindView(R.id.submit_button) Button submitButton;

    @BindView(R.id.new_note_title_edittext) EditText titleEditText;

    @BindView(R.id.new_note_content_edittext) EditText noteEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_note);
        super.bind();
        presenter.attach(this);
        setButtonListeners();
    }

    private void setButtonListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEditText.getText().toString();
                String noteContent = noteEditText.getText().toString();
                presenter.addNewNote(title, noteContent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}
