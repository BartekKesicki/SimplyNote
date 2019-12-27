package com.example.simplynote.utils;

import android.widget.LinearLayout;

import com.example.simplynote.new_checklist.OnChecklistItemClickListener;

public interface ChecklistItemManager {
    LinearLayout createNewRow(OnChecklistItemClickListener onChecklistItemClickListener, int id);
}
