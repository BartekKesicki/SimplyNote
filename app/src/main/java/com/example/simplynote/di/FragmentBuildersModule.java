package com.example.simplynote.di;

import com.example.simplynote.checklists_fragment.CheckListFragment;
import com.example.simplynote.notes_list_fragment.NotesListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    public abstract CheckListFragment bindCheckListFragment();

    @ContributesAndroidInjector
    public abstract NotesListFragment bindNotesListFragment();
}
