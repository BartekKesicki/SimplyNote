package com.example.simplynote.utils.impl;

import android.content.Context;

import com.example.simplynote.utils.StringProvider;

import javax.inject.Inject;

public class StringProviderImpl implements StringProvider {

    private Context mContext;

    @Inject
    public StringProviderImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public String getString(int id) {
        return mContext.getString(id);
    }
}
