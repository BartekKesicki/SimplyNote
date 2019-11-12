package com.example.simplynote.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;
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

    private static final int TABS_COUNT = 2;

    @Inject
    HomeActivityPresenter presenter;

    @BindView (R.id.tabLayout) TabLayout tabLayout;

    @BindView (R.id.viewpager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter.attach(this);
        initializeTabLayout();
    }

    private void initializeTabLayout() {
        tabLayout.addTab(new TabLayout.Tab().setText(R.string.home_checklists_tab_item));
        tabLayout.addTab(new TabLayout.Tab().setText(R.string.home_notes_tab_item));

        final HomeTabsAdapter myAdapter = new HomeTabsAdapter(this, getSupportFragmentManager(), TABS_COUNT);
        viewPager.setAdapter(myAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

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
