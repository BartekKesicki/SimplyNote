package com.example.simplynote.checklists_fragment;

import com.example.simplynote.repository.ChecklistRepository;
import com.example.simplynote.room.model.Checklist;
import com.example.simplynote.room.model.ChecklistWithItems;
import com.example.simplynote.utils.BaseScheduler;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class CheckListPresenter implements CheckListFragmentContract.CheckListFragmentPresenter<CheckListFragmentContract.CheckListView> {

    private CheckListFragmentContract.CheckListView view;

    private BaseScheduler baseScheduler;

    private ChecklistRepository checklistRepository;

    @Inject
    public CheckListPresenter(BaseScheduler baseScheduler, ChecklistRepository checklistRepository) {
        this.baseScheduler = baseScheduler;
        this.checklistRepository = checklistRepository;
    }

    @Override
    public void attach(CheckListFragmentContract.CheckListView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = CheckListFragmentContract.NULL;
    }

    public void performToLoadCheckList() {
        checklistRepository.getAll()
                .subscribeOn(baseScheduler.io())
                .observeOn(baseScheduler.main())
                .subscribe(new SingleObserver<List<ChecklistWithItems>>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onSuccess(List<ChecklistWithItems> checklists) {
                        view.showFetchedChecklists(checklists);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showChecklistLoadFailedMessage();
                    }
                });
    }
}
