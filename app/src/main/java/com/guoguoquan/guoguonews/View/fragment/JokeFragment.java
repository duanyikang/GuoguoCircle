package com.guoguoquan.guoguonews.View.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;

import com.guoguoquan.guoguonews.Presenter.GetNetDataPresenter;
import com.guoguoquan.guoguonews.View.IViewGetNetData;
import com.guoguoquan.guoguonews.View.adapter.MyStaggeredViewAdapter;
import com.guoguoquan.guoguonews.Bean.NewsBean;

/**
 * @author 小段果果
 * @time 2016/5/24  20:12
 * @E-mail duanyikang@mumayi.com
 */

public class JokeFragment extends BaseFragment implements IViewGetNetData {


    @Override
    public void initView() {
        super.initView();
        GetNetDataPresenter.getInstance(this).go(1, new String[]{"size", "page"}, new String[]{"100", "1"});

    }

    public void initNetData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showSuccess(SparseArray<NewsBean> te) {
        if (te.size() != 0) {
            mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            mStaggeredAdapter = new MyStaggeredViewAdapter(getActivity(), te);
            mRecyclerView.setAdapter(mStaggeredAdapter);
            mRecyclerView.setLayoutManager(mLayoutManager);
        }
    }

    @Override
    public void showFailed(String message) {

    }
}

