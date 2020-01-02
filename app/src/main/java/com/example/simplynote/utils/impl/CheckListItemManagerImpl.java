package com.example.simplynote.utils.impl;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.simplynote.R;
import com.example.simplynote.new_checklist.OnChecklistItemClickListener;
import com.example.simplynote.utils.ChecklistItemManager;
import com.example.simplynote.utils.StringProvider;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import javax.inject.Inject;

public class CheckListItemManagerImpl implements ChecklistItemManager {

    private Context mContext;
    private StringProvider stringProvider;

    @Inject
    public CheckListItemManagerImpl(StringProvider stringProvider) {
        this.stringProvider = stringProvider;
    }

    @Override
    public LinearLayout createNewRow(OnChecklistItemClickListener onChecklistItemClickListener, int id) {
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        //todo change Linear to Constraint Layout
        TextInputLayout textInputLayout = createTextInputLayout();
        linearLayout.addView(textInputLayout);
        Button removeItemButton = createRemoveItemButton(onChecklistItemClickListener, id);
        linearLayout.addView(removeItemButton);
        return linearLayout;
    }

    @Override
    public void setMContext(Context context) {
        this.mContext = context;
    }

    private Button createRemoveItemButton(final OnChecklistItemClickListener onChecklistItemClickListener, final int id) {
        Button button = new Button(mContext);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        //todo replace text on button with icon
        button.setText(stringProvider.getString(R.string.list_item_remove_button_text));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onChecklistItemClickListener.onPerformRemove(id);
            }
        });
        return button;
    }

    private TextInputLayout createTextInputLayout() {
        TextInputLayout textInputLayout = new TextInputLayout(mContext, null);
        textInputLayout.setHint(stringProvider.getString(R.string.new_checlist_new_item_label));
        textInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
        textInputLayout.setBoxCornerRadii(5, 5, 5, 5);
        TextInputEditText editext = new TextInputEditText(textInputLayout.getContext());
        textInputLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        editext.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textInputLayout.addView(editext);
        return textInputLayout;
    }
}
