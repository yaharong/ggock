package com.king.togi.ggock.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.king.togi.ggock.Adapter.TotalAdapter;
import com.king.togi.ggock.R;
import com.king.togi.ggock.model.TotalModel;

import java.util.ArrayList;

public class TotalFragment extends Fragment {

    private String title;
    private TextView item_text;
    private RecyclerView recyclerView;

    public TotalFragment() {
        // Required empty public constructor
    }

    public void setTitle(String title) {
        // Required empty public constructor
        this.title = title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_total, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        item_text = view.findViewById(R.id.total_fragment);
        recyclerView = view.findViewById(R.id.recyclerView_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        TotalAdapter adapter = new TotalAdapter(createModels(title));
        recyclerView.setAdapter(adapter);
    }

    // 파라미터로 외부에서 정해준 (FranceActivity) title 을 이용해서 각각에 해당하는 TotalModel 리스트를 만들어준다
    private ArrayList<TotalModel> createModels(String title){
        ArrayList<TotalModel> models = new ArrayList<>();
        switch (title){
            case "전체":
                for(int i = 0; i < 30; i++)
                    models.add(new TotalModel("text_1_" + i, "text_2_" + i, "text_3_" + i));
                break;
            case "패션/뷰티":
                for(int i = 0; i < 30; i++)
                    models.add(new TotalModel("text_1_" + i, "text_2_" + i, "text_3_" + i));
                break;
            case "식품":
                for(int i = 0; i < 30; i++)
                    models.add(new TotalModel("text_1_" + i, "text_2_" + i, "text_3_" + i));
                break;
            case "의약품":
                for(int i = 0; i < 30; i++)
                    models.add(new TotalModel("text_1_" + i, "text_2_" + i, "text_3_" + i));
                break;
            case "생활용품":
                for(int i = 0; i < 30; i++)
                    models.add(new TotalModel("text_1_" + i, "text_2_" + i, "text_3_" + i));
                break;
        }

        return models;
    }
}
