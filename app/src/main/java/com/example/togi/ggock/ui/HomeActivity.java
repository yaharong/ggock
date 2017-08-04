package com.example.togi.ggock.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.example.togi.ggock.R;

public class HomeActivity extends RootActivity {

    // 1. 프래그먼트로 바꾸기(하단 네비게이션 드로어 리스너) <= refresh 기능을 추후 추가할 것
    // 2. 프래그먼트안에 프래그먼트 만들기

    Activity self;  // 17-08-01 : 자기자신 선언
    private MyFragmentAdapter MyFragmentAdapter;
    private ViewPager mainPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 하단 탭바
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        self = HomeActivity.this;   // 17-08-01 : 자기자신 초기화

        // 중앙 화면 페이저
        MyFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        mainPager = (ViewPager) findViewById(R.id.mainPager);  // 리스트뷰와 같은 틀 역할을 한다.
        mainPager.setAdapter(MyFragmentAdapter);

    }

    // 하단 네비게이션 드로어 리스너 : 일단은 그냥 체인지로 바꿈
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:              // 홈 버튼 클릭 시
                    // 17-08-01 : 홈 화면 새로고침
                    //changeActivity(HomeActivity.this, HomeActivity.class);
                    mainPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_zzim:              // 찜 버튼 클릭 시
                    //changeActivity(HomeActivity.this, ZZimActivity.class);
                    mainPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_myPage:            // 마이페이지 버튼 클릭 시
                    //changeActivity(HomeActivity.this, MyPageNoAuthActivity.class);
                    mainPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

}
