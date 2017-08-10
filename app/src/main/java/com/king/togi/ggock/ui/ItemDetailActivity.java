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
import android.widget.TextView;

import com.king.togi.ggock.R;

public class ItemDetailActivity extends AppCompatActivity {

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

        place_recyclerview      = (RecyclerView) findViewById(R.id.place_recyclerview);
        comment_recyclerview    = (RecyclerView) findViewById(R.id.comment_recyclerview);
        recommand_recyclerview  = (RecyclerView) findViewById(R.id.recommand_recyclerview);
        product_image_viewpager = (ViewPager)    findViewById(R.id.product_image_viewpager);

        place_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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


    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {
        TextView place_name, place_btn;


        //TextView name;
        public PlaceViewHolder(View itemView) {
            super(itemView);

            place_name        = itemView.findViewById(R.id.place_name);
                place_btn   = itemView.findViewById(R.id.place_btn);

        }
    }

    private class PlaceRecyclerViewAdapter extends RecyclerView.Adapter<PlaceViewHolder>
    {
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
            return 0;
        }
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView place_name, place_btn;


        //TextView name;
        public CommentViewHolder(View itemView) {
            super(itemView);

            place_name        = itemView.findViewById(R.id.place_name);
            place_btn   = itemView.findViewById(R.id.place_btn);

        }
    }

    private class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentViewHolder>
    {
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
            return 0;
        }
    }

    private class RecommandRecyclerViewAdapter extends RecyclerView.Adapter<CommentViewHolder>
    {
        @Override
        public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_detailpage_recommand_layout, parent, false);

            return new CommentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CommentViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    public class ImagePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }
}
