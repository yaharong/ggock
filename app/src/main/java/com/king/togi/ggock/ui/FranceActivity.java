package com.king.togi.ggock.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.king.togi.ggock.R;
import com.king.togi.ggock.fragment.BeautyFragment;
import com.king.togi.ggock.fragment.ClothesFragment;
import com.king.togi.ggock.fragment.DrugFragment;
import com.king.togi.ggock.fragment.SuppliesFragment;

public class FranceActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_france);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



        Spinner s = (Spinner)findViewById(R.id.spinner1);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        // Fragment 만들어야함
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new BeautyFragment();
                case 1:
                    return new ClothesFragment();
                case 2:
                    return new DrugFragment();
                default:
                    return new SuppliesFragment();
            }
            //return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "주류";
                case 1:
                    return "화장품";
                case 2:
                    return "의류";
                case 3:
                    return "약품";
            }
            return null;
        }
    }

    // 가격 조절 필터(레인지시크바 이용)
    // getactivity???
    // 구체적으로 구현 아직 안됨
//    public void onFilter() {
//        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(FranceActivity.this);
//        seekBar.setRangeValues(0, 100);
//
//        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
//            @Override
//            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
//                //Now you have the minValue and maxValue of your RangeSeekbar
//                Toast.makeText(getApplicationContext(), minValue + "-" + maxValue, Toast.LENGTH_LONG).show();
//            }
//        });
//        // Get noticed while dragging
//        seekBar.setNotifyWhileDragging(true);
//
//    }
}