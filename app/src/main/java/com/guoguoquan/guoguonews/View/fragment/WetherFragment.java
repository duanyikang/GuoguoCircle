package com.guoguoquan.guoguonews.View.fragment;

import com.guoguoquan.guoguonews.Presenter.base.BasePresenter;
import com.guoguoquan.guoguonews.View.base.BaseFragment;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

/**
 * ���ߣ�duanyikang on 2016/9/14 0014 15:25
 * ���䣺duanyikang@yixia.com
 */
public class WetherFragment extends BaseFragment{


    @Override
    public void requestDataRefresh(SwipyRefreshLayoutDirection direction) {

    }

    @Override
    protected int createViewLayoutId() {
        return 0;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
