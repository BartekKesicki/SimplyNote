package com.example.simplynote.utils;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.simplynote.new_checklist.OnChecklistItemClickListener;

public interface ChecklistItemManager {
    LinearLayout createNewRow(OnChecklistItemClickListener onChecklistItemClickListener, int id);
    void setMContext(Context context);
}
