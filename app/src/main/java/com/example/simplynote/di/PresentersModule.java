package com.example.simplynote.di;

import com.example.simplynote.checklists_fragment.CheckListPresenter;
import com.example.simplynote.error.ErrorFragmentPresenter;
import com.example.simplynote.home.HomeActivityPresenter;
import com.example.simplynote.login.LoginActivityPresenter;
import com.example.simplynote.new_checklist.NewChecklistActivityPresenter;
import com.example.simplynote.new_note.NewNoteActivityPresenter;
import com.example.simplynote.notes_list_fragment.NotesListPresenter;
import com.example.simplynote.register.RegisterActivityPresenter;
import com.example.simplynote.repository.ChecklistItemRepository;
import com.example.simplynote.repository.ChecklistRepository;
import com.example.simplynote.repository.NoteRepository;
import com.example.simplynote.repository.UserRepository;
import com.example.simplynote.utils.BaseScheduler;
import com.example.simplynote.utils.StringProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {

    @Provides
    @Singleton
    public LoginActivityPresenter provideLoginActivityPresenter(StringProvider stringProvider, UserRepository userRepository, BaseScheduler baseScheduler) {
        return new LoginActivityPresenter(stringProvider, userRepository, baseScheduler);
    }

    @Provides
    @Singleton
    public RegisterActivityPresenter provideRegisterActivityPresenter(StringProvider stringProvider, UserRepository userRepository, BaseScheduler baseScheduler) {
        return new RegisterActivityPresenter(stringProvider, userRepository, baseScheduler);
    }

    @Provides
    @Singleton
    public HomeActivityPresenter provideHomeActivityPresenter() {
        return new HomeActivityPresenter();
    }

    @Provides
    @Singleton
    public CheckListPresenter provideCheckListPresenter(BaseScheduler baseScheduler, ChecklistRepository checklistRepository) {
        return new CheckListPresenter(baseScheduler, checklistRepository);
    }

    @Provides
    @Singleton
    public NotesListPresenter provideNotesListPresenter(BaseScheduler baseScheduler, NoteRepository noteRepository) {
        return new NotesListPresenter(baseScheduler, noteRepository);
    }

    @Provides
    @Singleton
    public ErrorFragmentPresenter provideErrorFragmentPresenter() {
        return new ErrorFragmentPresenter();
    }

    @Provides
    @Singleton
    public NewChecklistActivityPresenter provideNewChecklistActivityPresenter(ChecklistRepository checklistRepository,
                                                                              ChecklistItemRepository checklistItemRepository,
                                                                              BaseScheduler baseScheduler) {
        return new NewChecklistActivityPresenter(checklistRepository, checklistItemRepository, baseScheduler);
    }

    @Provides
    @Singleton
    public NewNoteActivityPresenter provideNewNoteActivityPresenter(NoteRepository noteRepository, BaseScheduler baseScheduler) {
        return new NewNoteActivityPresenter(noteRepository, baseScheduler);
    }
}
