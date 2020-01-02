package com.example.simplynote.utils;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public interface AlertDialogManager {
    AlertDialog createDialog(String positiveButtonText, String negativeButtonText,
                             DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener, String message);
    void setMContext(Context context);
}
