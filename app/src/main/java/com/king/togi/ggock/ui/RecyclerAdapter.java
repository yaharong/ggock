package com.king.togi.ggock.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.king.togi.ggock.R;
import com.king.togi.ggock.model.ItemModel;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2017-08-07.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    ArrayList<ItemModel> mItems;

    public RecyclerAdapter(ArrayList<ItemModel> items){
        mItems = items;
    }
    // 뷰 홀더
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_item_list_layout, parent,false);
        return new RecyclerAdapter.ItemViewHolder;
        // 2213123123123
    }
    // 데이터 셋의 크기를 리턴해줍니다.
    @Override
    public int getItemCount() {
        return mItems.size();
    }

    // 커스텀 뷰홀더
    class ItemViewHolder extends RecyclerView.ViewHolder{
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
