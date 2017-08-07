package com.king.togi.ggock.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.togi.ggock.R;

/**
 * Created by Tacademy on 2017-08-02.
 * 홈페이지 광고/서비스 파트에서 쓰이는 페이져 어댑터
 */

public class CustomAdapter extends PagerAdapter {

    Context context;
    // 이미지 갯수 , 현재 이미지는 그냥 하드코딩으로 들어가있따.
    int[] imageId = {R.drawable.gametitle_09, R.drawable.gametitle_10};

    public CustomAdapter(Context context){
        this.context = context;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View viewItem = inflater.inflate(R.layout.cell_viewpager_layout, container, false);

        ImageView imageView = (ImageView) viewItem.findViewById(R.id.img_viewpager);
        imageView.setImageResource(imageId[position]);
        TextView textView1 = (TextView) viewItem.findViewById(R.id.text_viewpager);
        textView1.setText("나는 광고다");    // 광고 문구





        ((ViewPager)container).addView(viewItem);

        return viewItem;
    }



    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub

        return view == ((View)object);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }

}


