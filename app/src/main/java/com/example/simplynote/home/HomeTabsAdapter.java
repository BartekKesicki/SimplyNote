package com.example.simplynote.home;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomeTabsAdapter extends FragmentPagerAdapter {

    private Context context;
    private int count;

    public HomeTabsAdapter(Context context, @NonNull FragmentManager fm, int count) {
        super(fm, count);
        this.context = context;
        this.count = count;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //todo fill fragments
        switch (position) {
            default: return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
