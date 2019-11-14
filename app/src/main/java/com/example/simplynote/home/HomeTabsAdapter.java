package com.example.simplynote.home;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.simplynote.checklists_fragment.CheckListFragment;
import com.example.simplynote.error.ErrorFragment;
import com.example.simplynote.notes_list_fragment.NotesListFragment;

public class HomeTabsAdapter extends FragmentPagerAdapter {

    private static final int CHECKLIST_FRAGMENT_INDEX = 0;
    private static final int NOTESLIST_FRAGMENT_INDEX = 1;
    private Context context;
    private int count;
    private CheckListFragment checkListFragment;
    private NotesListFragment notesListFragment;
    private ErrorFragment errorFragment;

    public HomeTabsAdapter(Context context, @NonNull FragmentManager fm, int count) {
        super(fm, count);
        this.context = context;
        this.count = count;
        initializeFragments();
    }

    private void initializeFragments() {
        checkListFragment = CheckListFragment.newInstance();
        notesListFragment = NotesListFragment.newInstance();
        errorFragment = ErrorFragment.newInstance();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case CHECKLIST_FRAGMENT_INDEX: return checkListFragment;
            case NOTESLIST_FRAGMENT_INDEX: return notesListFragment;
            default: return errorFragment;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
