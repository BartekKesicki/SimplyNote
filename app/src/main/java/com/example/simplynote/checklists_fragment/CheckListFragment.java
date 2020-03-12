package com.example.simplynote.checklists_fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseFragment;
import com.example.simplynote.new_checklist.NewCheckListActivity;
import com.example.simplynote.room.model.Checklist;
import com.example.simplynote.utils.AlertDialogManager;

import java.util.List;

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

    private ChecklistsAdapter checklistsAdapter;

    private RecyclerView recyclerView;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        presenter.attach(this);
    }

    private void initializeUIControls(View view) {
        addNewChecklistButton = view.findViewById(R.id.add_new_checklist_button);
        recyclerView = view.findViewById(R.id.checklists_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeUIControls(view);
        setButtonListeners();
        presenter.performToLoadCheckList();
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

    @Override
    public void showChecklistLoadFailedMessage() {
        Toast.makeText(requireContext(), getString(R.string.checklists_load_fail_message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFetchedChecklists(List<Checklist> checklists) {
        checklistsAdapter = new ChecklistsAdapter(checklists);
        recyclerView.setAdapter(checklistsAdapter);
    }
}
