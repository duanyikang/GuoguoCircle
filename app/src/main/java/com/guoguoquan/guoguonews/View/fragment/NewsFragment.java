package com.guoguoquan.guoguonews.View.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.guoguoquan.guoguonews.Presenter.NewsPresenter;
import com.guoguoquan.guoguonews.Presenter.base.BasePresenter;
import com.guoguoquan.guoguonews.R;
import com.guoguoquan.guoguonews.View.base.BaseFragment;
import com.guoguoquan.guoguonews.View.iview.InterNewsFragmentView;

/**
 * ×÷Õß£ºduanyikang on 2016/9/14 0014 15:25
 * ÓÊÏä£ºduanyikang@yixia.com
 */
public class NewsFragment extends BaseFragment<InterNewsFragmentView, NewsPresenter> implements InterNewsFragmentView {

    LinearLayoutManager mLinearLayoutManager;
    RecyclerView mRecyclerView;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setDataRefresh(true);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        setDataRefresh(true);
        mPresenter.getNewsData(String.valueOf(100));
    }


    @Override
    protected void initView(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.content_list);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected NewsPresenter createPresenter() {
        return new NewsPresenter(getContext());
    }

    @Override
    public void setDataRefresh(Boolean b) {
        setRefresh(b);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    @Override
    public LinearLayoutManager getLayoutManager() {
        return mLinearLayoutManager;
    }
}
