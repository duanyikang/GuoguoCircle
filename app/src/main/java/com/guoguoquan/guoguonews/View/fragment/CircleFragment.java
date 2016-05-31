package com.guoguoquan.guoguonews.View.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;

import com.guoguoquan.guoguonews.Presenter.GetNetDataPresenter;
import com.guoguoquan.guoguonews.View.IViewGetNetData;
import com.guoguoquan.guoguonews.View.adapter.MyStaggeredViewAdapter;
import com.guoguoquan.guoguonews.Bean.NewsBean;

/**
 * @author 小段果果
 * @time 2016/5/25  11:05
 * @E-mail duanyikang@mumayi.com
 */

public class CircleFragment extends BaseFragment implements IViewGetNetData{
    @Override
    public void initView() {
        super.initView();
        GetNetDataPresenter.getInstance(this).go(3, new String[]{"size", "page"}, new String[]{"100", "1"});
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showSuccess(SparseArray<NewsBean> mDatas) {
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mStaggeredAdapter = new MyStaggeredViewAdapter(getActivity(),mDatas);
        mRecyclerView.setAdapter(mStaggeredAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showFailed(String message) {

    }
}

