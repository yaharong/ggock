package com.example.togi.ggock.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.togi.ggock.fragment.HomePageFragment;
import com.example.togi.ggock.fragment.MyPageFragment;
import com.example.togi.ggock.fragment.ZZimPageFragment;

/**
 * Created by Tacademy on 2017-08-03.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    // 생성자
    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    // 특정 position의 데이터 하나를 가져온다.
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new HomePageFragment();
            case 1:
                return new ZZimPageFragment();
            default:
                return new MyPageFragment();
        }
    }
    // 데이터의 개수(Fragment의 개수)
    @Override
    public int getCount() {
        return 3;
    }

    // 데이터가 곧 화면이므로 상단탭의 제목만 넣어줘도 된다. basicAdapter의 cell 구성을 안해도된다는 의미
    @Override
    public CharSequence getPageTitle(int position) {
        // 같은 디비를 여러 모로 볼수있다.
        switch (position) {
            case 0:
                return "홈";
            case 1:
                return "찜";   // 필터나 쿼리를 쓴다
            case 2:
                return "마이페이지";
        }
        return null;
    }
}
