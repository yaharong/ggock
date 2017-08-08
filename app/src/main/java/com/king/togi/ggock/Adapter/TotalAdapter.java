package com.king.togi.ggock.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_item_list_layout, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.toBind(items.get(position), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 찜 페이지로 이동
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_1, text_2,text_3, zzimCount;
        public ImageButton zzimButton;

        public ViewHolder(View itemView) {
            super(itemView);
            text_1 = itemView.findViewById(R.id.textView1);
            text_2 = itemView.findViewById(R.id.textView2);
            text_3 = itemView.findViewById(R.id.textView3);
            zzimCount = itemView.findViewById(R.id.zzimCount);
            zzimButton = (ImageButton)itemView.findViewById(R.id.zzimButton);
        }

        public void toBind(TotalModel model, View.OnClickListener clicklistener){
            text_1.setText(model.getText_1());
            text_2.setText(model.getText_2());
            text_3.setText(model.getText_3());
            zzimCount.setText("" + model.getZzimCount());
            zzimButton.setOnClickListener(clicklistener);
        }

    }
}
