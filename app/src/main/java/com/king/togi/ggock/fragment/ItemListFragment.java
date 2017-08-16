package com.king.togi.ggock.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.king.togi.ggock.R;
import com.king.togi.ggock.fragment.item_list_fragment.TotalItemListFragment;

public class ItemListFragment extends Fragment {

    Button back_btn;
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;


    TotalItemListFragment totalItemListFragment = new TotalItemListFragment();
    TotalItemListFragment cosmeticsListFragment = new TotalItemListFragment();
    TotalItemListFragment foodListFragment = new TotalItemListFragment();
    TotalItemListFragment suppliesListFragment = new TotalItemListFragment();
    TotalItemListFragment clothesListFragment = new TotalItemListFragment();

    FragmentManager fragmentManager;
    FragmentTransaction ft;

    public ItemListFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        back_btn = (Button) view.findViewById(R.id.back_btn);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) view.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
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

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppCompatActivity)getActivity()).onBackPressed();
            }
        });
        fragmentManager = (getActivity()).getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();

        return view;
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
