package com.guoguoquan.guoguonews.Presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.guoguoquan.guoguonews.Bean.JokeBean;
import com.guoguoquan.guoguonews.Bean.JokeServiceBean;
import com.guoguoquan.guoguonews.Presenter.base.BasePresenter;
import com.guoguoquan.guoguonews.View.adapter.JokeFragmentAdapter;
import com.guoguoquan.guoguonews.View.iview.InterJokeFragmentView;
import com.guoguoquan.guoguonews.View.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 作者：duanyikang on 2016/9/13 0013 15:52
 * 邮箱：duanyikang@yixia.com
 */
public class JokePresenter extends BasePresenter<InterJokeFragmentView> {

    private Context context;
    private InterJokeFragmentView mInterOneFragmentView;

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private JokeFragmentAdapter mJokeFragmentAdapter = new JokeFragmentAdapter(context);


    public JokePresenter(Context context) {
        this.context = context;
    }

    public void getJokeData(int size, int page, boolean isadd) {
        mInterOneFragmentView = getView();
        if (mInterOneFragmentView != null) {
            mRecyclerView = mInterOneFragmentView.getRecyclerView();
            mLinearLayoutManager = mInterOneFragmentView.getLayoutManager();
            netApi.getJokeList(String.valueOf(size), String.valueOf(page))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(jokeServiceBean -> {
                        disPlayAdapter(jokeServiceBean.getDetail(), isadd);
                    }, this::loadError);
        }
    }

    private void disPlayAdapter(List<JokeBean> jokeList, boolean isadd) {
        if (mInterOneFragmentView != null) {
            mJokeFragmentAdapter.addAll(jokeList);
            mJokeFragmentAdapter.setCanLoading(true);
            mRecyclerView.setAdapter(mJokeFragmentAdapter);
            mRecyclerView.setLayoutManager(mLinearLayoutManager);
            mInterOneFragmentView.setDataRefresh(false);
        }
    }


}
