package com.example.simplynote.checklists_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplynote.R;
import com.example.simplynote.room.model.Checklist;
import com.example.simplynote.utils.views.BaseHolderView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChecklistsAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Checklist> checklists;

    public ChecklistsAdapter(List<Checklist> checklists) {
        this.checklists = checklists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.checklists_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.checklistName.setText(checklists.get(position).getName());
        //todo fill quantity
        holder.checklistItemsQuantity.setText("Quantity: " + "<quantity>");
    }

    @Override
    public int getItemCount() {
        return checklists.size();
    }
}

class ViewHolder extends BaseHolderView {

    @BindView(R.id.note_name)
    TextView checklistName;

    @BindView(R.id.note_description)
    TextView checklistItemsQuantity;

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
