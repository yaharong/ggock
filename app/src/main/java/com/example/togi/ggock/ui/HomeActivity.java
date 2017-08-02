package com.example.togi.ggock.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.example.togi.ggock.R;

public class HomeActivity extends RootActivity {

    // private TextView mTextMessage;  // 메인화면 메시지
    Activity self;  // 17-08-01 : 자기자신 선언

    private CustomAdapter mSectionsPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        self = HomeActivity.this;   // 17-08-01 : 자기자신 초기화

        viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter = new CustomAdapter(HomeActivity.this);
        viewPager.setAdapter(adapter);

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
                    changeActivity(self, MyPageActivity.class);
                    return true;
            }
            return false;
        }
    };


}
