package com.guoguoquan.guoguonews.View.fragment;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.SparseArray;

import com.guoguoquan.guoguonews.Presenter.GetNetDataPresenter;
import com.guoguoquan.guoguonews.View.IViewGetNetData;
import com.guoguoquan.guoguonews.View.adapter.MyRecyclerViewAdapter;
import com.guoguoquan.guoguonews.Bean.NewsBean;

/**
 * @author 小段果果
 * @time 2016/5/25  10:16
 * @E-mail duanyikang@mumayi.com
 */

public class FunImageFragment extends BaseFragment implements IViewGetNetData {
    @Override
    public void initView() {
        super.initView();
        GetNetDataPresenter.getInstance(this).go(2, new String[]{"size", "page"}, new String[]{"100", "1"});

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showSuccess(SparseArray<NewsBean> mDatas) {
        mLayoutManager = new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerViewAdapter = new MyRecyclerViewAdapter(getActivity(), mDatas);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showFailed(String message) {

    }
}

