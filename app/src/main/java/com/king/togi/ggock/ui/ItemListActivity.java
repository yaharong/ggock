package com.king.togi.ggock.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.king.togi.ggock.R;
import com.king.togi.ggock.fragment.item_list_fragment.TotalItemListFragment;

import static com.king.togi.ggock.R.id.container;

public class ItemListActivity extends RootActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    TotalItemListFragment totalItemListFragment = new TotalItemListFragment();
    TotalItemListFragment cosmeticsListFragment = new TotalItemListFragment();
    TotalItemListFragment foodListFragment = new TotalItemListFragment();
    TotalItemListFragment suppliesListFragment = new TotalItemListFragment();
    TotalItemListFragment clothesListFragment = new TotalItemListFragment();

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction ft = fragmentManager.beginTransaction();



    // 화면 생성
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ft.addToBackStack(null);
                    return totalItemListFragment;
                case 1:
                    ft.addToBackStack(null);
                    return cosmeticsListFragment;
                case 2:
                    ft.addToBackStack(null);

                    return foodListFragment;
                case 3:
                    ft.addToBackStack(null);

                    return suppliesListFragment;
                default:
                    ft.addToBackStack(null);

                    return clothesListFragment;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "전체";
                case 1:
                    return "화장품";
                case 2:
                    return "식품";
                case 3:
                    return "생활용품";
                case 4:
                    return "패션";
            }
            return null;
        }
    }


}