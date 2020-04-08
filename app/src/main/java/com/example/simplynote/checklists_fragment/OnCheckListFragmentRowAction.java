package com.example.simplynote.checklists_fragment;

import com.example.simplynote.room.model.Checklist;

public interface OnCheckListFragmentRowAction {
    void onPerformRemoveChecklistItem(Checklist checklist, int position);
}
