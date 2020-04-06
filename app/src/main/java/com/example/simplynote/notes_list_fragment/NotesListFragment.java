package com.example.simplynote.notes_list_fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseFragment;
import com.example.simplynote.new_note.NewNoteActivity;
import com.example.simplynote.room.model.Note;
import com.example.simplynote.utils.AlertDialogManager;
import com.example.simplynote.utils.StringProvider;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class NotesListFragment extends BaseFragment implements NotesListFragmentContract.NotesListView, OnNotesListFragmentAction {

    public static NotesListFragment newInstance() {
        return new NotesListFragment();
    }

    @Inject
    NotesListPresenter presenter;

    @Inject
    AlertDialogManager alertDialogManager;

    @Inject
    StringProvider stringProvider;

    private RecyclerView recyclerView;

    private NotesAdapter notesAdapter;

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
        presenter.performToLoadNotesList();
    }

    private void setButtonListeners() {
        addNewNoteButton.setOnClickListener(view -> NewNoteActivity.start(requireContext()));
    }

    private void initializeUIControls(View view) {
        addNewNoteButton = view.findViewById(R.id.add_new_note_button);
        recyclerView = view.findViewById(R.id.notes_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(requireContext(), getString(R.string.noteslists_fragment_fetch_data_failure_message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void createListView(List<Note> notes) {
        notesAdapter = new NotesAdapter(notes, this);
        recyclerView.setAdapter(notesAdapter);
    }

    @Override
    public void performRemoveNote(long id) {
        alertDialogManager.createDialog(stringProvider.getString(R.string.yes), stringProvider.getString(R.string.no), (dialog, which) -> {
            //todo remove note
            dialog.dismiss();
        }, (dialog, which) -> {
            dialog.dismiss();
        }, stringProvider.getString(R.string.note_remove_ask_message));
    }
}
