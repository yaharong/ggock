package com.king.togi.ggock.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.king.togi.ggock.R;
import com.king.togi.ggock.fragment.HomePageFragment;
import com.king.togi.ggock.fragment.MyPageFragment;
import com.king.togi.ggock.fragment.ZZimPageFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends RootActivity {

    // 하단 탭바 바인딩
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    // 17-08-01 : 자기자신 선언
    Activity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 버터나이프 바인딩
        ButterKnife.bind(this);

        // 하단 탭바 초기화
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        self = HomeActivity.this;   // 17-08-01 : 자기자신 초기화

        InitView();
    }

    private void InitView()
    {
        pushFragment(new HomePageFragment());

    }
    // 하단 탭바 리스너 : 일단은 그냥 체인지로 바꿈
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:              // 홈 버튼 클릭 시
                    // 17-08-01 : 홈 화면 새로고침
                    //changeActivity(HomeActivity.this, HomeActivity.class);
                    pushFragment(new HomePageFragment());
                    return true;
                case R.id.navigation_zzim:              // 찜 버튼 클릭 시
                    //changeActivity(HomeActivity.this, ZZimActivity.class);
                    pushFragment(new ZZimPageFragment());
                    return true;
                case R.id.navigation_myPage:            // 마이페이지 버튼 클릭 시
                    //changeActivity(HomeActivity.this, MyPageNoAuthActivity.class);
                    pushFragment(new MyPageFragment());
                    return true;
            }
            return false;
        }
    };

    /**
     * Method to push any fragment into given id.
     *
     * @param fragment An instance of Fragment to show into the given id.
     */
    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.main_container, fragment);
                ft.commit();
            }
        }
    }

}
