package com.example.simplynote.utils.impl;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.simplynote.R;
import com.example.simplynote.utils.ChecklistItemManager;
import com.example.simplynote.utils.StringProvider;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import javax.inject.Inject;

public class CheckListItemManagerImpl implements ChecklistItemManager {

    private Context mContext;
    private StringProvider stringProvider;

    @Inject
    public CheckListItemManagerImpl(Context context, StringProvider stringProvider) {
        this.mContext = context;
        this.stringProvider = stringProvider;
    }

    @Override
    public LinearLayout createNewRow() {
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextInputLayout textInputLayout = createTextInputLayout();
        linearLayout.addView(textInputLayout);
        Button removeItemButton = createRemoveItemButton();
        linearLayout.addView(removeItemButton);
        return linearLayout;
    }

    private Button createRemoveItemButton() {
        Button button = new Button(mContext);
        //todo add listener and text
        return button;
    }

    private TextInputLayout createTextInputLayout() {
        TextInputLayout textInputLayout = new TextInputLayout(mContext, null);
        textInputLayout.setHint(stringProvider.getString(R.string.new_checlist_new_item_label));
        textInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
        textInputLayout.setBoxCornerRadii(5, 5, 5, 5);
        TextInputEditText editext = new TextInputEditText(textInputLayout.getContext());
        textInputLayout.addView(editext);
        return textInputLayout;
    }
}
