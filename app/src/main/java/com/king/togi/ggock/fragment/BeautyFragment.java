package com.king.togi.ggock.fragment;

import android.os.Bundle;
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

import java.util.ArrayList;


// 지울 가능성 높음
public class BeautyFragment extends RootFragment {
    View mView;  // fragment_home_page
    RecyclerView beauty_recyclerView;
    // 레이아웃
    LinearLayout beauty_layout;
    // 어댑터
    BeautyAdapter beauty_adapter;
    ArrayList<ItemModel> itemModels;

    public BeautyFragment() {
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
        mView = inflater.inflate(R.layout.fragment_beauty, container, false);

        // 리사이클러 뷰=============================================================================
//        beauty_recyclerView = (RecyclerView) mView.findViewById(beauty_recyclerView);
        // 방향
        beauty_recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext(), LinearLayoutManager.VERTICAL, false));
        // 아답터 선언(뷰홀더, 데이터 설정연결, 이벤트등등..)
        beauty_adapter = new BeautyAdapter();
        // 데이터 설정
        itemModels = initData();
        // 연결
        beauty_recyclerView.setAdapter(beauty_adapter);

        return mView;
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
        }
    }

    // RecyclerView_adapter : 리사이클러 뷰 어댑터
    class BeautyAdapter extends RecyclerView.Adapter<TestViewHolder> {
        @Override
        public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // xml -> View
            View view =
                    LayoutInflater.from(getActivity()).inflate(R.layout.cell_item_list_layout, parent, false);
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
                    .override(500, 500)
                    .centerCrop()
                    .into(holder.poster);
        }

        @Override
        public int getItemCount() {
            return itemModels == null ? 0 : itemModels.size();
        }
    }
}
