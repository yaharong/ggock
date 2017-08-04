package com.king.togi.ggock.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.king.togi.ggock.R;
import com.king.togi.ggock.ui.CustomAdapter;

public class HomePageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private CustomAdapter adapter;
    private ViewPager viewPager;

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 해당 프레그먼트를 화면에 출력
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        // Inflate the layout for this fragment
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        adapter = new CustomAdapter(view.getContext());
        viewPager.setAdapter(adapter);

        ImageView viewpoint_viewpager1 = (ImageView) view.findViewById(R.id.viewpoint_viewpager1);
        ImageView viewpoint_viewpager2 = (ImageView) view.findViewById(R.id.viewpoint_viewpager2);
        ImageView viewpoint_viewpager3 = (ImageView) view.findViewById(R.id.viewpoint_viewpager3);

        // 점UI default 세팅
        viewpoint_viewpager1.setImageResource(android.R.drawable.presence_online);
        // 뷰페이저 스와이프 리스너
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

        return view;
    }

}
