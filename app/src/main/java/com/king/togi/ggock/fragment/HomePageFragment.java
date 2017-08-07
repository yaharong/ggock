package com.king.togi.ggock.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.king.togi.ggock.R;
import com.king.togi.ggock.model.ItemModel;
import com.king.togi.ggock.ui.CustomAdapter;
import com.king.togi.ggock.ui.FranceActivity;

import java.util.ArrayList;

/*
* writen by. togi
*   홈페이지 버튼을 눌렀을 때 전환되는 홈 화면
*
* */

public class HomePageFragment extends RootFragment
{
    // 전역 변수 선언 ========================================================================================
    View mView;  // fragment_home_page
    // 광고/서비스 ViewPager
    private ViewPager service_pager;
    private CustomAdapter viewpager_adapter;
    // 카드뉴스 ViewPager
    private ViewPager cardnews_pager;
    // 최근 본 상품 리사이클러 뷰
    LinearLayout latest_item_layout;
    RecyclerView latest_item_recyclerView;
    LatestItemAdapter latest_item_adapter;
    DetailItemAdapter detail_item_adapter;
    ArrayList<ItemModel> itemModels;
    // 프랑스 이거꼭사 리사이클러 뷰
    RecyclerView detail_item_recyclerView;
    // 프랑스 이거꼭사 더보기 버튼
    Button moreBtn;
    // 프랑스 이미지뷰
    ImageView france_image;
    // ======================================================================================================

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
        mView = inflater.inflate(R.layout.fragment_home_page, container, false);

        // 리사이클러 뷰=============================================================================
        // 리사이클러 뷰 for 최근 본 항목
        latest_item_recyclerView = (RecyclerView) mView.findViewById(R.id.latest_item_recyclerView);
        // 리사이클러 뷰 for 프랑스 이거 꼭사
        detail_item_recyclerView = (RecyclerView) mView.findViewById(R.id.detail_item_recyclerView);
        // 방향
        latest_item_recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        detail_item_recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        // 아답터 선언(뷰홀더, 데이터 설정연결, 이벤트등등..)
        latest_item_adapter = new LatestItemAdapter();
        detail_item_adapter = new DetailItemAdapter();
        // 데이터 설정
        itemModels = initData();
        // 연결
        latest_item_recyclerView.setAdapter(latest_item_adapter);
        detail_item_recyclerView.setAdapter(detail_item_adapter);

        // 광고/서비스 화면 넘기는 효과 ( 뷰페이저 ) ==================================================
        service_pager = (ViewPager) mView.findViewById(R.id.service_pager);
        viewpager_adapter = new CustomAdapter(mView.getContext());
        service_pager.setAdapter(viewpager_adapter);

        cardnews_pager = (ViewPager) mView.findViewById(R.id.cardnews_pager);
        cardnews_pager.setAdapter(viewpager_adapter);

        // 점 UI========================================================================================
        FrameLayout service_point_ui = (FrameLayout) mView.findViewById(R.id.service_point_ui);
        FrameLayout card_point_ui    = (FrameLayout) mView.findViewById(R.id.card_point_ui);
        pointUI(service_point_ui, service_pager);
        pointUI(card_point_ui, cardnews_pager);

        // 통신으로 최근 본 정보를 가져온 후에(10개까지만) 그 정보를 노출
        // 만약 통신으로 가져온 정보가 하나도 없다면 최근 본 상품 뷰를 GONE시킨다.
        // => latest_item_layout
        latest_item_layout = (LinearLayout) mView.findViewById(R.id.latest_item_layout);
        //latest_item_layout.setVisibility(View.GONE);

        // 더보기 버튼에 클릭리스너 부착
        moreBtn = (Button) mView.findViewById(R.id.moreBtn);
        everyClickListener(moreBtn, FranceActivity.class);
        // 프랑스 이미지 뷰 클릭리스너 부착
        france_image = (ImageView) mView.findViewById(R.id.france_image);
        everyClickListener(france_image,FranceActivity.class);



        return mView;
    }

    // 첫번째 : 클릭리스너를 붙이고 싶은 View 객채, 두번째는 목표 지점 activity.class 로 전달
    private void everyClickListener(View view, Class<?> targetActivity)
    {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(mView.getContext(), targetActivity);
            }
        });
    }

    // 점 UI  ======================================================================================
    private void pointUI(FrameLayout layout, ViewPager pager) {

        ImageView viewpoint_viewpager1 = (ImageView) layout.findViewById(R.id.viewpoint_viewpager1);
        ImageView viewpoint_viewpager2 = (ImageView) layout.findViewById(R.id.viewpoint_viewpager2);
        ImageView viewpoint_viewpager3 = (ImageView) layout.findViewById(R.id.viewpoint_viewpager3);
        // 점UI default 세팅
        viewpoint_viewpager1.setImageResource(android.R.drawable.presence_online);
        // 뷰페이저 스와이프 리스너
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    viewpoint_viewpager1.setImageResource(android.R.drawable.presence_online);
                    viewpoint_viewpager2.setImageResource(android.R.drawable.presence_invisible);
                    viewpoint_viewpager3.setImageResource(android.R.drawable.presence_invisible);
                } else if (position == 1) {
                    viewpoint_viewpager1.setImageResource(android.R.drawable.presence_invisible);
                    viewpoint_viewpager2.setImageResource(android.R.drawable.presence_online);
                    viewpoint_viewpager3.setImageResource(android.R.drawable.presence_invisible);
                } else {
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

    // 리사이클러 뷰 만들기 ==========================================================================
    // 이미지 데이터 정보가 하드코딩으로 들어있다.
    public ArrayList<ItemModel> initData() {
        String data[][] =
                {
                        {"SOON.9", "http://postfiles14.naver.net/MjAxNzAyMDZfMTUw/MDAxNDg2MzQ1NzQxNzAw.EeDfmVU_xMJG75SyK0dmm2URhy_ZNZ2iVwkmY3JzF6cg.10Q8usGt2iyzGCz3zB_mUiJ0ZZtowaTMVbSTu3T4do0g.JPEG.sweetbin38/DSC_2265.JPG?type=w966"},
                        {"SOON.9", "http://postfiles14.naver.net/MjAxNzAyMDZfMTUw/MDAxNDg2MzQ1NzQxNzAw.EeDfmVU_xMJG75SyK0dmm2URhy_ZNZ2iVwkmY3JzF6cg.10Q8usGt2iyzGCz3zB_mUiJ0ZZtowaTMVbSTu3T4do0g.JPEG.sweetbin38/DSC_2265.JPG?type=w966"},
                        {"SOON.9", "http://postfiles14.naver.net/MjAxNzAyMDZfMTUw/MDAxNDg2MzQ1NzQxNzAw.EeDfmVU_xMJG75SyK0dmm2URhy_ZNZ2iVwkmY3JzF6cg.10Q8usGt2iyzGCz3zB_mUiJ0ZZtowaTMVbSTu3T4do0g.JPEG.sweetbin38/DSC_2265.JPG?type=w966"},
                        {"SOON.9", "http://postfiles14.naver.net/MjAxNzAyMDZfMTUw/MDAxNDg2MzQ1NzQxNzAw.EeDfmVU_xMJG75SyK0dmm2URhy_ZNZ2iVwkmY3JzF6cg.10Q8usGt2iyzGCz3zB_mUiJ0ZZtowaTMVbSTu3T4do0g.JPEG.sweetbin38/DSC_2265.JPG?type=w966"},
                        {"아레스옴므", "http://ldb.phinf.naver.net/20151126_91/1448511898022cXuOx_JPEG/167053593171965_0.jpeg"},
                };
        // HairModel객체에 데이터를 담아서 ArrayList<HairModel>를 반환하시오
        ArrayList<ItemModel> arrayList = new ArrayList<>();
        for (String[] a : data) {
            arrayList.add(new ItemModel(a[0], a[1]));
        }
        return arrayList;
    }
    class TestViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        //TextView name;
        public TestViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.poster);
            //name = itemView.findViewById(R.id.name);
        }
    }

    // RecyclerView_adapter : 리사이클러 뷰 어댑터
    class LatestItemAdapter extends RecyclerView.Adapter<TestViewHolder> {
        @Override
        public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // xml -> View
            View view =
                    LayoutInflater.from(getActivity()).inflate(R.layout.cell_latest_item_layout, parent, false);
            return new TestViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TestViewHolder holder, int position) {
            // 데이터 세팅!!
            // 데이터 추출
            ItemModel itemModel = itemModels.get(position);
            // 텍스트 세팅
            //holder.name.setText( itemModel.getShopName() );
            //holder.name.setText( "아아아");
            // 이미지 세팅
            Glide.with(getActivity())
                    .load(itemModel.getPoster())
                    .override(500,500)
                    .centerCrop()
                    .into(holder.poster);
        }

        @Override
        public int getItemCount() {
            return itemModels == null ? 0 : itemModels.size();
        }

    }

    // DetailItemAdapter : 리사이클러 뷰 어댑터
    class DetailItemAdapter extends RecyclerView.Adapter<TestViewHolder> {
        @Override
        public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // xml -> View
            View view =
                    LayoutInflater.from(getActivity()).inflate(R.layout.cell_detail_item_layout, parent, false);
            return new TestViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TestViewHolder holder, int position) {
            // 데이터 세팅!!
            // 데이터 추출
            ItemModel itemModel = itemModels.get(position);
            // 텍스트 세팅
            //holder.name.setText( itemModel.getShopName() );
            //holder.name.setText( "아아아");
            // 이미지 세팅
            Glide.with(getActivity())
                    .load(itemModel.getPoster())
                    .override(500,500)
                    .centerCrop()
                    .into(holder.poster);
        }

        @Override
        public int getItemCount() {
            return itemModels == null ? 0 : itemModels.size();
        }

    }

    LoginFragement loginFragement = new LoginFragement();
    // 서비스 어댑터 ================================================================================
    public class ServiceAdapter extends FragmentPagerAdapter
    {
        int[] imageId = {R.drawable.gametitle_09, R.drawable.gametitle_10};
        ImageView imageView;
        TextView textView1;

        public ServiceAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View viewItem = LayoutInflater.from(getActivity()).inflate(R.layout.cell_viewpager_layout, container, false);

            imageView     = (ImageView) viewItem.findViewById(R.id.img_viewpager);
            imageView.setImageResource(imageId[position]);
            textView1     = (TextView) viewItem.findViewById(R.id.text_viewpager);
            textView1.setText("나는 광고다");    // 광고 문구

            ((ViewPager)container).addView(viewItem);

            return viewItem;
        }

        @Override
        public Fragment getItem(int position) {



            switch (position)
            {
                case 0:
                    return loginFragement;
            }
            return null;
        }

        @Override
        public int getCount() {
            return  imageId.length;
        }


    }

}
