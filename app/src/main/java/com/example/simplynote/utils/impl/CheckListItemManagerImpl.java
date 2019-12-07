package com.example.simplynote.utils.impl;

import android.content.Context;

import com.example.simplynote.utils.ChecklistItemManager;
import com.google.android.material.textfield.TextInputLayout;

import javax.inject.Inject;

public class CheckListItemManagerImpl implements ChecklistItemManager {

    private Context mContext;

    @Inject
    public CheckListItemManagerImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public TextInputLayout createNewRow() {
        //todo implement method
        return null;
    }
}
