package com.example.simplynote.room.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

public class ChecklistWithItems {

    @Embedded
    private Checklist checklist;

    @Relation(parentColumn = "id", entityColumn = "checklistId")
    private List<ChecklistItem> checklistItems = new ArrayList<>();

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public void setChecklistItems(List<ChecklistItem> checklistItems) {
        this.checklistItems = checklistItems;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public List<ChecklistItem> getChecklistItems() {
        return checklistItems;
    }
}
