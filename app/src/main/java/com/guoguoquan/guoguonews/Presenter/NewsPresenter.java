package com.guoguoquan.guoguonews.Presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.guoguoquan.guoguonews.Bean.NewsBean;
import com.guoguoquan.guoguonews.Presenter.base.BasePresenter;

import com.guoguoquan.guoguonews.View.adapter.NewsFragmentAdapter;
import com.guoguoquan.guoguonews.View.iview.InterNewsFragmentView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;

import rx.schedulers.Schedulers;

/**
 * ×÷Õß£ºduanyikang on 2016/9/18 0018 10:07
 * ÓÊÏä£ºduanyikang@yixia.com
 */
public class NewsPresenter extends BasePresenter<InterNewsFragmentView> {
    private Context mContext;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private NewsFragmentAdapter mNewsFragmentAdapter;

    private InterNewsFragmentView mInterNewsFragmentView;


    public NewsPresenter(Context context) {
        this.mContext = context;
    }

    public void getNewsData(String size) {
        mInterNewsFragmentView = getView();
        if (mInterNewsFragmentView != null) {
            mRecyclerView = mInterNewsFragmentView.getRecyclerView();
            mLinearLayoutManager = mInterNewsFragmentView.getLayoutManager();
            netApi.getNewsList(size)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(newsServiceBean -> {
                        disPlayAdapter(newsServiceBean.getDetail());
                    }, this::loadError);
        }
    }

    private void disPlayAdapter(List<NewsBean> newsList) {
        if (mInterNewsFragmentView != null) {
            mNewsFragmentAdapter = new NewsFragmentAdapter(mContext, newsList);
            mRecyclerView.setAdapter(mNewsFragmentAdapter);
            mRecyclerView.setLayoutManager(mLinearLayoutManager);
            mInterNewsFragmentView.setDataRefresh(false);
        }
    }
}
