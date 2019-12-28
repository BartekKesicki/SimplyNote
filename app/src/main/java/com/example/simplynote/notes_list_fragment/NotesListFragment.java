package com.example.simplynote.notes_list_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseFragment;
import com.example.simplynote.new_note.NewNoteActivity;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class NotesListFragment extends BaseFragment implements NotesListFragmentContract.NotesListView {

    public static NotesListFragment newInstance() {
        return new NotesListFragment();
    }

    @Inject
    NotesListPresenter presenter;

    private Button addNewNoteButton;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        presenter.attach(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home_notes_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeUIControls(view);
        setButtonListeners();
    }

    private void setButtonListeners() {
        addNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewNoteActivity.start(requireContext());
            }
        });
    }

    private void initializeUIControls(View view) {
        addNewNoteButton = view.findViewById(R.id.add_new_note_button);
    }

    @Override
    public void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}
