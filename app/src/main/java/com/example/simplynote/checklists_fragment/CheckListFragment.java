package com.example.simplynote.checklists_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseFragment;
import com.example.simplynote.new_checklist.NewCheckListActivity;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.support.AndroidSupportInjection;

public class CheckListFragment extends BaseFragment implements CheckListFragmentContract.CheckListView {

    public static CheckListFragment newInstance() {
        return new CheckListFragment();
    }

    @Inject
    CheckListPresenter presenter;

    private Button addNewChecklistButton;

    //todo initialize checklist adapter

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        presenter.attach(this);
    }

    private void initializeUIControls(View view) {
        addNewChecklistButton = view.findViewById(R.id.add_new_checklist_button);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeUIControls(view);
        setButtonListeners();
    }

    private void setButtonListeners() {
        addNewChecklistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewCheckListActivity.start(requireContext());
            }
        });
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
