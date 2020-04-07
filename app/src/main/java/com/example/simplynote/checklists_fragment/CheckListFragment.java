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
import com.example.simplynote.room.model.ChecklistWithItems;
import com.example.simplynote.utils.AlertDialogManager;
import com.example.simplynote.utils.StringProvider;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.support.AndroidSupportInjection;

public class CheckListFragment extends BaseFragment implements CheckListFragmentContract.CheckListView, OnCheckListFragmentRowAction {

    public static CheckListFragment newInstance() {
        return new CheckListFragment();
    }

    @Inject
    CheckListPresenter presenter;

    @Inject
    AlertDialogManager alertDialogManager;

    @Inject
    StringProvider stringProvider;

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
        alertDialogManager.setMContext(requireContext());
        presenter.performToLoadCheckList();
    }

    private void setButtonListeners() {
        addNewChecklistButton.setOnClickListener(view -> NewCheckListActivity.start(requireContext()));
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
    public void showFetchedChecklists(List<ChecklistWithItems> checklistsWithItems) {
        checklistsAdapter = new ChecklistsAdapter(checklistsWithItems, this);
        recyclerView.setAdapter(checklistsAdapter);
    }

    @Override
    public void showRemoveChecklistSuccess() {
        Toast.makeText(requireContext(), stringProvider.getString(R.string.checklist_removed_properly_message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showRemoveChecklistFailure() {
        Toast.makeText(requireContext(), stringProvider.getString(R.string.checklist_removed_failure_message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPerformRemoveChecklistItem(Checklist checklist) {
        alertDialogManager.createDialog(stringProvider.getString(R.string.yes), stringProvider.getString(R.string.no), (dialog, which) -> {
            presenter.performToRemoveChecklist(checklist);
            dialog.dismiss();
        }, (dialog, which) -> {
            dialog.dismiss();
        }, stringProvider.getString(R.string.checklist_remove_ask_message)).show();
    }
}
