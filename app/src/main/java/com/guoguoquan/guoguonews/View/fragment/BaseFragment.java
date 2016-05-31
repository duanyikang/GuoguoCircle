package com.guoguoquan.guoguonews.View.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.guoguoquan.guoguonews.Bean.NewsBean;
import com.guoguoquan.guoguonews.R;
import com.guoguoquan.guoguonews.View.adapter.MyRecyclerViewAdapter;
import com.guoguoquan.guoguonews.View.adapter.MyStaggeredViewAdapter;

/**
 * @author 小段果果
 * @time 2016/5/24  20:24
 * @E-mail duanyikang@mumayi.com
 */

public class BaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    public View mView;
    public SwipeRefreshLayout mSwipeRefreshLayout;
    public RecyclerView mRecyclerView;
    public RecyclerView.LayoutManager mLayoutManager;
    public MyRecyclerViewAdapter mRecyclerViewAdapter;
    public MyStaggeredViewAdapter mStaggeredAdapter;

    public static final int SPAN_COUNT = 2;


    public SparseArray<NewsBean> mDatas = new SparseArray<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_base_layout, container, false);
        initView();
        return mView;
    }


    public void initView() {
        mSwipeRefreshLayout=(SwipeRefreshLayout)mView.findViewById(R.id.id_swiperefreshlayout);
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.id_recyclerview);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.main_blue_light, R.color.main_blue_dark);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }


    @Override
    public void onRefresh() {

    }
}

