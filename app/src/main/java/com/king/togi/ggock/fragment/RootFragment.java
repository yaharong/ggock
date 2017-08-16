package com.king.togi.ggock.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.king.togi.ggock.R;

/**
 * Created by Tacademy on 2017-08-07.
 */


public class RootFragment extends Fragment {

    public RootFragment() {
        // Required empty public constructor
    }



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

    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.main_container, fragment);
                ft.commit();
            }
        }
    }
}
