package com.example.simplynote.checklists_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplynote.R;
import com.example.simplynote.room.model.Checklist;
import com.example.simplynote.room.model.ChecklistWithItems;
import com.example.simplynote.utils.views.BaseHolderView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChecklistsAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ChecklistWithItems> checklistsWithItems;
    private OnCheckListFragmentRowAction onCheckListFragmentRowAction;

    public ChecklistsAdapter(List<ChecklistWithItems> checklistsWithItems, OnCheckListFragmentRowAction onCheckListFragmentRowAction) {
        this.checklistsWithItems = checklistsWithItems;
        this.onCheckListFragmentRowAction = onCheckListFragmentRowAction;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.checklists_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.checklistName.setText(checklistsWithItems.get(position).getChecklist().getName());
        holder.checklistItemsQuantity.setText("Positions: " + checklistsWithItems.get(position).getChecklistItems().size());
        holder.deleteButton.setOnClickListener(v -> onCheckListFragmentRowAction.onPerformRemoveChecklistItem(checklistsWithItems.get(position).getChecklist(), position));
    }

    @Override
    public int getItemCount() {
        return checklistsWithItems.size();
    }
}

class ViewHolder extends BaseHolderView {

    @BindView(R.id.checklist_name)
    TextView checklistName;

    @BindView(R.id.checklist_items_quantity)
    TextView checklistItemsQuantity;

    @BindView(R.id.delete_row_button)
    ImageButton deleteButton;

    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    protected void clear() {
        checklistName.setText("");
        checklistItemsQuantity.setText("");
    }
}
