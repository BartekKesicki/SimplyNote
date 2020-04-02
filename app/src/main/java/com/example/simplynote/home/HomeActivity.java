package com.example.simplynote.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;
import com.example.simplynote.checklists_fragment.CheckListFragment;
import com.example.simplynote.notes_list_fragment.NotesListFragment;
import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class HomeActivity extends BaseActivity implements HomeContract.HomeView {

    public static void start(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Inject
    HomeActivityPresenter presenter;

    @BindView (R.id.tabLayout) TabLayout tabLayout;

    @BindView (R.id.viewPager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        hideActionBar();
        setContentView(R.layout.activity_home);
        super.bind();
        presenter.attach(this);
        initializeTabLayout();
    }

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void initializeTabLayout() {
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        HomeTabsAdapter myAdapter = new HomeTabsAdapter(getSupportFragmentManager());
        myAdapter.addFragment(CheckListFragment.newInstance(), getString(R.string.home_checklists_tab_item));
        myAdapter.addFragment(NotesListFragment.newInstance(), getString(R.string.home_notes_tab_item));

        viewPager.setAdapter(myAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}
