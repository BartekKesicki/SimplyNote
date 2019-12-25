package com.example.simplynote.utils.impl;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.example.simplynote.utils.AlertDialogManager;

import javax.inject.Inject;

public class AlertDialogManagerImpl implements AlertDialogManager {

    private Context mContext;

    @Inject
    public AlertDialogManagerImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public AlertDialog createDialog(String positiveButtonText, String negativeButtonText, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, positiveButtonText, positiveListener);
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, negativeButtonText, negativeListener);
        return alertDialog;
    }
}
