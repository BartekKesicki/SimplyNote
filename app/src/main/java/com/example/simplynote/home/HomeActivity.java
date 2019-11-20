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
    private static final int CHECKLISTS_FRAGMENT_INDEX = 0;
    private static final int NOTES_FRAGMENT_INDEX = 1;

    //todo remove toolbar

    @Inject
    HomeActivityPresenter presenter;

    @BindView (R.id.tabLayout) TabLayout tabLayout;

    @BindView (R.id.viewpager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        super.bind();
        presenter.attach(this);
        initializeTabLayout();
    }

    private void initializeTabLayout() {
        final HomeTabsAdapter myAdapter = new HomeTabsAdapter(this, getSupportFragmentManager(), TABS_COUNT);
        viewPager.setAdapter(myAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(CHECKLISTS_FRAGMENT_INDEX).setText(R.string.home_checklists_tab_item);
        tabLayout.getTabAt(NOTES_FRAGMENT_INDEX).setText(R.string.home_notes_tab_item);

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
