package com.king.togi.ggock.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.king.togi.ggock.R;
import com.king.togi.ggock.model.ItemModel;
import com.king.togi.ggock.ui.CustomAdapter;

import java.util.ArrayList;

public class HomePageFragment extends Fragment
{
    // 전역 변수 선언 ========================================================================================

    // 광고/서비스 ViewPager
    private ViewPager viewPager;
    private CustomAdapter adapter;

    // 최근 본 상품 리사이클러 뷰
    LinearLayout latest_item_layout;
    RecyclerView recyclerView;
    TestAdapter testAdapter;
    ArrayList<ItemModel> itemModels;
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
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        // 리사이클러 뷰 for 최근 본 항목 ============================================================
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        // 방향
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        // 아답터 (뷰홀더, 데이터 설정연결, 이벤트등등..)
        testAdapter = new TestAdapter();
        // 데이터 설정
        itemModels = initData();
        // 연결
        recyclerView.setAdapter(testAdapter);
        // 광고/서비스 화면 넘기는 효과 ( 뷰페이저 )
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        adapter = new CustomAdapter(view.getContext());
        viewPager.setAdapter(adapter);
        // =========================================================================================
        // 점 UI
        pointUI(view);

        // 통신으로 최근 본 정보를 가져온 후에(10개까지만) 그 정보를 노출
        // 만약 통신으로 가져온 정보가 하나도 없다면 최근 본 상품 뷰를 GONE시킨다.
        // => latest_item_layout
        latest_item_layout = (LinearLayout) view.findViewById(R.id.latest_item_layout);
        //latest_item_layout.setVisibility(View.GONE);

        

        return view;
    }

    // 점 UI  ======================================================================================
    public void pointUI(View view) {
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
    class TestAdapter extends RecyclerView.Adapter<TestViewHolder> {
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
}
