package com.king.togi.ggock.ui;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.king.togi.ggock.R;

public class ItemDetailActivity extends AppCompatActivity {
    // 더보기 버튼
    TextView view_all;
    Boolean view_flag = false;
    LinearLayoutManager place_layoutManager;
    // 뒤로가기 버튼
    TextView back_btn;

    // 1. 일단 RecyclerView 3개 끌어오기
    RecyclerView place_recyclerview, comment_recyclerview, recommand_recyclerview;
    ViewPager product_image_viewpager;

    // 2. Adapter 만들기
    PlaceRecyclerViewAdapter placeRecyclerViewAdapter;
    CommentRecyclerViewAdapter commentRecyclerViewAdapter;
    RecommandRecyclerViewAdapter recommandRecyclerViewAdapter;
    ImagePagerAdapter imagePagerAdapter;

    // 3. Adapter 연결하기

    // 4. 어댑터 방향성 설정
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        back_btn = (TextView) findViewById(R.id.back_btn);
        place_recyclerview = (RecyclerView) findViewById(R.id.place_recyclerview);
        comment_recyclerview = (RecyclerView) findViewById(R.id.comment_recyclerview);
        recommand_recyclerview = (RecyclerView) findViewById(R.id.recommand_recyclerview);
        product_image_viewpager = (ViewPager) findViewById(R.id.product_image_viewpager);

        // place_recyclerview 수직 스크롤 막기
        place_layoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        //place_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        place_recyclerview.setLayoutManager(place_layoutManager);
        comment_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recommand_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        placeRecyclerViewAdapter = new PlaceRecyclerViewAdapter();
        commentRecyclerViewAdapter = new CommentRecyclerViewAdapter();
        recommandRecyclerViewAdapter = new RecommandRecyclerViewAdapter();
        imagePagerAdapter = new ImagePagerAdapter();

        place_recyclerview.setAdapter(placeRecyclerViewAdapter);
        comment_recyclerview.setAdapter(commentRecyclerViewAdapter);
        recommand_recyclerview.setAdapter(recommandRecyclerViewAdapter);
        product_image_viewpager.setAdapter(imagePagerAdapter);

        // 더보기 기능
        view_all = (TextView) findViewById(R.id.viewall_btn);

        final int cnt = place_recyclerview.getAdapter().getItemCount();
        if (cnt > 3) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) place_recyclerview.getLayoutParams();
            view_all.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (view_flag == true) {
                        view_flag = false;
                        params.height = place_layoutManager.getChildAt(0).getHeight() * 3;
                        place_recyclerview.setLayoutParams(params);
                        view_all.setText("더보기▼");

                    } else {
                        view_flag = true;
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) place_recyclerview.getLayoutParams();
                        params.height = place_layoutManager.getChildAt(0).getHeight() * cnt;
                        place_recyclerview.setLayoutParams(params);
                        view_all.setText("더보기▲");
                    }

                }
            });
        } else {
            view_all.setVisibility(View.GONE);
        }

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {
        TextView place_name, place_btn;

        public PlaceViewHolder(View itemView) {
            super(itemView);

            place_name = itemView.findViewById(R.id.place_name);
            place_btn = itemView.findViewById(R.id.place_btn);

        }
    }

    private class PlaceRecyclerViewAdapter extends RecyclerView.Adapter<PlaceViewHolder> {
        @Override
        public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_detailpage_place_layout, parent, false);

            return new PlaceViewHolder(view);
        }


        @Override
        public void onBindViewHolder(PlaceViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {

            return 10;
        }
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView comment_name, comment_time, comment_content;
        ImageView comment_poster;
        Button comment_setting_btn;


        //TextView name;
        public CommentViewHolder(View itemView) {
            super(itemView);

            comment_poster = itemView.findViewById(R.id.comment_poster);
            comment_name = itemView.findViewById(R.id.comment_name);
            comment_time = itemView.findViewById(R.id.comment_time);
            comment_content = itemView.findViewById(R.id.comment_content);
            comment_setting_btn = itemView.findViewById(R.id.comment_setting_btn);

        }


    }

    private class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentViewHolder> {
        @Override
        public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_detailpage_comment_layout, parent, false);

            return new CommentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CommentViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    class RecommandViewHolder extends RecyclerView.ViewHolder {
        ImageView recommand_poster;


        //TextView name;
        public RecommandViewHolder(View itemView) {
            super(itemView);

            recommand_poster = itemView.findViewById(R.id.recommand_poster);
        }
    }

    private class RecommandRecyclerViewAdapter extends RecyclerView.Adapter<RecommandViewHolder> {
        @Override
        public RecommandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_detailpage_recommand_layout, parent, false);

            return new RecommandViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecommandViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    public class ImagePagerAdapter extends PagerAdapter {
        int[] imageId = {R.drawable.gametitle_09, R.drawable.gametitle_10, R.drawable.common_full_open_on_phone};
        ImageView imageView;
        TextView textView1;


        public void setTextView1(String str) {
            this.textView1.setText(str);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View viewItem = LayoutInflater.from(container.getContext()).inflate(R.layout.cell_homepage_viewpager_layout, container, false);

            imageView = (ImageView) viewItem.findViewById(R.id.img_viewpager);
            imageView.setImageResource(imageId[position]);

            ((ViewPager) container).addView(viewItem);

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

            return view == ((View) object);
        }

        @Override
        public void startUpdate(ViewGroup container) {
            super.startUpdate(container);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            ((ViewPager) container).removeView((View) object);
        }
    }
}
