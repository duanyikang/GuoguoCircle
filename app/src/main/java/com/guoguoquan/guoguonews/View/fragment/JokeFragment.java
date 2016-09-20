package com.guoguoquan.guoguonews.View.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;


import com.guoguoquan.guoguonews.Presenter.JokePresenter;

import com.guoguoquan.guoguonews.R;
import com.guoguoquan.guoguonews.View.base.BaseFragment;
import com.guoguoquan.guoguonews.View.iview.InterJokeFragmentView;
import com.guoguoquan.guoguonews.View.listener.OnLoadMoreListener;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;



/**
 * @author 小段果果
 * @time 2016/5/24  20:12
 * @E-mail duanyikang@mumayi.com
 */

public class JokeFragment extends BaseFragment<InterJokeFragmentView, JokePresenter> implements InterJokeFragmentView{

    LinearLayoutManager mLinearLayoutManager;
    RecyclerView mRecyclerView;

    private int page = 0;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setDataRefresh(true);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        setDataRefresh(true);
        mPresenter.getJokeData(3, page,false);
    }


    @Override
    protected void initView(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.content_list);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
    }


    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_joke;
    }

    @Override
    protected JokePresenter createPresenter() {
        return new JokePresenter(getContext());
    }

    @Override
    public void setDataRefresh(Boolean b) {
        setRefresh(b);
    }

    @Override
    public void requestDataRefresh(SwipyRefreshLayoutDirection direction) {
        mPresenter.getJokeData(3, ++page,false);
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

