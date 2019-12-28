package com.example.simplynote.base;

import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    protected void toast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }
}
