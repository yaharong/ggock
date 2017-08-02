package com.example.togi.ggock.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.togi.ggock.R;

public class HomeActivity extends RootActivity {

    Activity self;  // 17-08-01 : 자기자신 선언

    private CustomAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        self = HomeActivity.this;   // 17-08-01 : 자기자신 초기화

        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new CustomAdapter(HomeActivity.this);
        viewPager.setAdapter(adapter);

        ImageView viewpoint_viewpager1 = (ImageView) findViewById(R.id.viewpoint_viewpager1);
        ImageView viewpoint_viewpager2 = (ImageView) findViewById(R.id.viewpoint_viewpager2);
        ImageView viewpoint_viewpager3 = (ImageView) findViewById(R.id.viewpoint_viewpager3);

        // default 세팅
        viewpoint_viewpager1.setImageResource(android.R.drawable.presence_online);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0)
                {
                    viewpoint_viewpager1.setImageResource(android.R.drawable.presence_online);
                    viewpoint_viewpager2.setImageResource(android.R.drawable.presence_invisible);
                    viewpoint_viewpager3.setImageResource(android.R.drawable.presence_invisible);
                }
                else if(position == 1)
                {
                    viewpoint_viewpager1.setImageResource(android.R.drawable.presence_invisible);
                    viewpoint_viewpager2.setImageResource(android.R.drawable.presence_online);
                    viewpoint_viewpager3.setImageResource(android.R.drawable.presence_invisible);
                }
                else
                {
                    viewpoint_viewpager1.setImageResource(android.R.drawable.presence_invisible);
                    viewpoint_viewpager2.setImageResource(android.R.drawable.presence_invisible);
                    viewpoint_viewpager3.setImageResource(android.R.drawable.presence_online);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }





    // 하단 네비게이션 드로어 리스너
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:              // 홈 버튼 클릭 시
                    // 17-08-01 : 홈 화면 새로고침
                    refreshActivity(self, HomeActivity.class);
                    return true;
                case R.id.navigation_zzim:              // 찜 버튼 클릭 시
                    changeActivity(self, ZZimActivity.class);
                    return true;
                case R.id.navigation_myPage:            // 마이페이지 버튼 클릭 시
                    changeActivity(self, MyPageNoAuthActivity.class);
                    return true;
            }
            return false;
        }
    };



}
