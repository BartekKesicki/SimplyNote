package com.example.simplynote.notes_list_fragment;

import com.example.simplynote.room.model.Note;

public interface OnNotesListFragmentAction {
    void performRemoveNote(Note note, int position);
}
