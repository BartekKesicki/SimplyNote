package com.example.simplynote.notes_list_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseFragment;

import dagger.android.support.AndroidSupportInjection;

public class NotesListFragment extends BaseFragment implements NotesListFragmentContract.NotesListView {

    public static NotesListFragment newInstance() {
        return new NotesListFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home_notes_list_fragment, container, false);
    }
}
