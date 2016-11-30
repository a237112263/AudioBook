package com.example.administrator.audiobook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/11/28.
 */
public class JavaFragmrnt extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment,null);
        RecyclerView mRecyclerView= (RecyclerView) view.findViewById(R.id.LV);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));//设置模式
        mRecyclerView.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST));//设置分割线
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画
        final String[] question=getResources().getStringArray(R.array.java);
        final String[] answer=getResources().getStringArray(R.array.java1);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(getActivity(),question);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnRecyclerViewListener(new RecyclerViewAdapter.OnRecyclerViewListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getActivity(),TextViewActivity.class);
                intent.putExtra("question",question[position]);
                intent.putExtra("answer",answer[position]);
                startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        return view;
    }
}
