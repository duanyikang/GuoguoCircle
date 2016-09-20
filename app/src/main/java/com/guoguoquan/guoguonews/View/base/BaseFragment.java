package com.guoguoquan.guoguonews.View.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoguoquan.guoguonews.Presenter.base.BasePresenter;
import com.guoguoquan.guoguonews.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;


import butterknife.ButterKnife;

/**
 * 作者：duanyikang on 2016/9/13 0013 14:49
 * 邮箱：duanyikang@yixia.com
 */
public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {
    protected T mPresenter;

    private boolean mIsRequestDatafresh = false;
    protected SwipyRefreshLayout mSwipeRefreshLayout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(createViewLayoutId(), container, false);
        ButterKnife.bind(this, rootView);
        initView(rootView);
        if (isSetRefresh()) {
            setUpSwipeRefresh(rootView);
        }

        return rootView;
    }

    private void setUpSwipeRefresh(View view) {
        mSwipeRefreshLayout = (SwipyRefreshLayout) view.findViewById(R.id.swipe_refresh);
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setColorSchemeResources(R.color.refresh_progress_1, R.color.refresh_progress_2, R.color.refresh_progress_3);
            mSwipeRefreshLayout.setOnRefreshListener(direction -> requestDataRefresh(direction));
        }
    }

    public void setRefresh(boolean requestDataRefresh) {
        if (mSwipeRefreshLayout == null) {
            return;
        }
        if (!requestDataRefresh) {
            mIsRequestDatafresh = false;
            mSwipeRefreshLayout.postDelayed(() -> {
                if (mSwipeRefreshLayout != null) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }, 1000);
        } else {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    public abstract void requestDataRefresh(SwipyRefreshLayoutDirection direction);

    protected void initView(View rootView) {
    }

    protected abstract int createViewLayoutId();

    protected abstract T createPresenter();

    public Boolean isSetRefresh() {
        return true;
    }
}
