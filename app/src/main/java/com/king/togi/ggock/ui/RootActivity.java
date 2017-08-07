package com.king.togi.ggock.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.king.togi.ggock.R;

/**
 * Created by Tacademy on 2017-08-01.
 * 모든 액티비티에서 같이 쓸 사항이 속해 있다.
 */
public class RootActivity extends AppCompatActivity {

    // 17-08-01 16:18 : (togi) 액티비티 이동(현재 액티비티, 타겟 액티비티)
    public void changeActivity(Context currentContext, Class<?> targetActivity)
    {
        Intent intent = new Intent(currentContext, targetActivity);
        startActivity(intent);
    }

    // 17-08-01 16:18 : (togi) 액티비티 새로고침(현재 액티비티, 타겟 액티비티)
    public void refreshActivity(Context currentContext, Class<?> targetActivity)
    {
        Intent intent = new Intent(currentContext, targetActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 하단탭바 선언 및 초기화

    }

    // 알림 버튼 클릭 시 작동
    public void onMoveToNotice(View view)
    {
        changeActivity(this, NoticeActivity.class);
    }

    /**
     * Method to push any fragment into given id.
     *
     * @param fragment An instance of Fragment to show into the given id.
     *      프래그먼트 추가 해주는 함수
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
