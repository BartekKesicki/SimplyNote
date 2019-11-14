package com.example.simplynote.error;

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

public class ErrorFragment extends BaseFragment implements ErrorFragmentContract.ErrorFragmentView {

    public static ErrorFragment newInstance() {
        return new ErrorFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home_error_fragment, container, false);
    }
}
