package com.example.simplynote.notes_list_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplynote.R;
import com.example.simplynote.common.DateFormats;
import com.example.simplynote.room.model.Note;
import com.example.simplynote.utils.views.BaseHolderView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Note> notes;

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.noteName.setText(notes.get(position).getTitle());
        String descriptionPreffix = "Created at: ";
        holder.noteDescription.setText(descriptionPreffix + DateFormats.listItemDateFormat.format(notes.get(position).getCreationTime()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}

class ViewHolder extends BaseHolderView {

    @BindView(R.id.note_name)
    TextView noteName;

    @BindView(R.id.note_description)
    TextView noteDescription;

    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    protected void clear() {
        noteName.setText("");
        noteDescription.setText("");
    }
}
