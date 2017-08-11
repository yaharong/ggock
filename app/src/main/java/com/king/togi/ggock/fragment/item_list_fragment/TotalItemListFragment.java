package com.king.togi.ggock.fragment.item_list_fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.king.togi.ggock.Adapter.TotalAdapter;
import com.king.togi.ggock.R;
import com.king.togi.ggock.fragment.RootFragment;
import com.king.togi.ggock.model.ItemModel;
import com.king.togi.ggock.net.Net;
import com.king.togi.ggock.ui.ItemDetailActivity;
import com.king.togi.ggock.util.RecyclerViewPositionHelper;
import com.king.togi.ggock.util.U;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tacademy on 2017-08-08.
 */


public class TotalItemListFragment extends RootFragment{

    View mView;
    RecyclerView recyclerView;
    TotalAdapter totalAdapter;
    ArrayList<ItemModel> itemModels;

    FloatingActionButton fab;
    Boolean topFlag;


    public TotalItemListFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 해당 플래그 먼트에서 출력하는 화면
        mView =inflater.inflate(R.layout.fragment_total_item_list, container, false);

        fab = (FloatingActionButton) mView.findViewById(R.id.back_to_top_btn);
        topFlag = false;

        // 리사이클러 뷰 for 상품 목록 페이지
        recyclerView = (RecyclerView) mView.findViewById(R.id.item_list_recyclerview);
        // 방향
        recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext(), LinearLayoutManager.VERTICAL, false));
        // 아답터 선언(뷰홀더, 데이터 설정연결, 이벤트등등..)
        //totalAdapter = new TotalAdapter(totalModels);
        LatestItemAdapter latestItemAdapter = new LatestItemAdapter();

        Call<ItemModel> togi = Net.getInstance().getDaumFactoryIm().togi();
        togi.enqueue(new Callback<ItemModel>() {
            @Override
            public void onResponse(Call<ItemModel> call, Response<ItemModel> response) {
                if(response.isSuccessful())
                {
                    U.getInstance().log("내이름은 ? "+response.body().getShopName());
                    // 데이터를 담아 둘 변수를 하나 만들고
                    // setAdapter() 메소드를 하나 짜서 그 데이터를 넘겨 준후에
                    // viewHolder Binding 을 어댑터안에서 진행한 후에 recyclerView.setAdapter까지
                    // 위의 setAdapter() 안에서 해준다.
                }else
                {
                    U.getInstance().log("Error1");

                }

            }

            @Override
            public void onFailure(Call<ItemModel> call, Throwable t) {
                U.getInstance().log("Error2");

            }
        });

        // 데이터 설정
        itemModels = initData();
        // 연결(나중에 통신 후에 setAdapter 하도록 변경하자
        recyclerView.setAdapter(latestItemAdapter);
        RecyclerViewPositionHelper helper = RecyclerViewPositionHelper.createHelper(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(topFlag ==false && helper.findFirstVisibleItemPosition() > 1)
                {
                    onShow(null);
                }

                if(topFlag == true && helper.findFirstVisibleItemPosition() < 1)
                {
                    onExit(null);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        // back to top button 기능 추가
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayoutManager layoutManager =
                        (LinearLayoutManager) recyclerView.getLayoutManager();
                layoutManager.smoothScrollToPosition(recyclerView,null,0);
            }
        });

        return mView;
    }
    // 통신 대신 쓰는 하드코딩으로 쓰고있답니다
    public ArrayList<ItemModel> initData()
    {
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
            arrayList.add(new ItemModel(a[1], a[0]));
        }
        return arrayList;
    }

    //// 생성, 홀더, 방향성, 어댑터, 연결, 데이터 설정
    class TestViewHolder extends RecyclerView.ViewHolder {
        ImageView cell_item_image;
        TextView item_name;

        //TextView name;
        public TestViewHolder(View itemView) {
            super(itemView);
            cell_item_image = itemView.findViewById(R.id.cell_item_image);
            item_name = itemView.findViewById(R.id.item_name);
        }
    }

    // RecyclerView_adapter : 리사이클러 뷰 어댑터
    class LatestItemAdapter extends RecyclerView.Adapter<TestViewHolder> {
        @Override
        public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // xml -> View
            View view =
                    LayoutInflater.from(getActivity()).inflate(R.layout.cell_listpage_item_layout, parent, false);
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
                    .into(holder.cell_item_image);
            // 포스터에 클릭리스너 부착
            holder.cell_item_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 나중에 조건 변경 할것!
                    if(true)
                    {
                        changeActivity(mView.getContext(), ItemDetailActivity.class);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemModels == null ? 0 : itemModels.size();
        }

    }

    //FrameLayout frameLayout = (FrameLayout) mView.findViewById(R.id.back_to_top_layout);
    public void onShow(View view)
    {
        topFlag = true;
        fab.setVisibility(View.VISIBLE);
        // 화면 높이 획득
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        // int evtWidth    = (int)(displayMetrics.widthPixels * 1.00);
        int evtHeight   = (int)(displayMetrics.heightPixels * 1.00);
        // 보인다

        // 애니메이션 생성
        Animation animation;
        AnimationSet set = new AnimationSet(true);
        set.setInterpolator(new AccelerateInterpolator());
        animation = new TranslateAnimation(0,0,evtHeight,0);
        animation.setDuration(300);// 0.3초 동안 무빙해라
        animation.setFillAfter(true);
        // 애니메이션 적용
        fab.setAnimation(animation);
        // 애니메이션 이벤트
        animation.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void onExit(View view)
    {
        topFlag = false;
        // 화면 높이 획득
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //int evtWidth    = (int)(displayMetrics.widthPixels * 1.00);
        int evtHeight   = (int)(displayMetrics.heightPixels * 1.00);
        // 보인다
        fab.setVisibility(View.GONE);
        // 애니메이션 생성
        Animation animation;
        AnimationSet set = new AnimationSet(true);
        set.setInterpolator(new AccelerateInterpolator());
        animation = new TranslateAnimation(0,0,0,evtHeight);
        animation.setDuration(300);// 0.3초 동안 무빙해라
        animation.setFillAfter(true);
        // 애니메이션 적용
        fab.setAnimation(animation);
        // 애니메이션 이벤트
        animation.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
