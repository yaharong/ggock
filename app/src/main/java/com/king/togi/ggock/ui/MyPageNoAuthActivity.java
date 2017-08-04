package com.king.togi.ggock.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.king.togi.ggock.R;

public class MyPageNoAuthActivity extends RootActivity {

    Activity self;  // 17-08-01 : 자기자신 선언

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:              // 홈 버튼 클릭 시
                    changeActivity(self, HomeActivity.class);
                    return true;
                case R.id.navigation_zzim:              // 찜 버튼 클릭 시
                    changeActivity(self, ZZimActivity.class);
                    return true;
                case R.id.navigation_myPage:            // 마이페이지 버튼 클릭 시
                    // 17-08-01 : 마이페이지 화면 새로고침
                    refreshActivity(self, MyPageNoAuthActivity.class);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_my_page_noauth);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        self = MyPageNoAuthActivity.this;   // 17-08-01 : 자기자신 초기화
    }

}
