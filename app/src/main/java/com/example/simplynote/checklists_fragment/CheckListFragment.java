package com.example.simplynote.checklists_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class CheckListFragment extends BaseFragment implements CheckListFragmentContract.CheckListView {

    public static CheckListFragment newInstance() {
        return new CheckListFragment();
    }

    @Inject
    CheckListPresenter presenter;

    //todo initialize checklist adapter

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        presenter.attach(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home_checklists_fragment, container, false);
    }

    @Override
    public void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}
