package com.king.togi.ggock.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.king.togi.ggock.R;
import com.king.togi.ggock.model.TotalModel;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2017-08-08.
 */

public class TotalAdapter extends RecyclerView.Adapter<TotalAdapter.ViewHolder> {
    private ArrayList<TotalModel> items;

    public TotalAdapter(ArrayList<TotalModel> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_listpage_item_layout, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.toBind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    // 뷰홀더 클래스 선언
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView image, name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cell_item_image);
            name = itemView.findViewById(R.id.item_name);
        }

        // 멤버변수 초기화 해주기
        public void toBind(TotalModel model){
            image.setText(model.getImageUrl());
            name.setText(model.getName());
        }
    }
}
