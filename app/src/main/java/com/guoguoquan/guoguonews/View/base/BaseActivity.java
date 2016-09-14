package com.guoguoquan.guoguonews.View.base;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;


import com.guoguoquan.guoguonews.Presenter.base.BasePresenter;
import com.guoguoquan.guoguonews.R;

import butterknife.ButterKnife;


/**
 * 作者：duanyikang on 2016/9/9 0009 15:47
 * 邮箱：duanyikang@yixia.com
 */
public abstract class BaseActivity<V, T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;
    protected AppBarLayout mAppBarLayout;
    protected Toolbar mToolbar;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean mIsRequestDataRefresh = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (createPresenter() != null) {
            mPresenter = createPresenter();
            mPresenter.attachView((V) this);
        }

        setContentView(provideContentViewId());
        ButterKnife.bind(this);

        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mAppBarLayout != null && mToolbar != null) {
            setSupportActionBar(mToolbar);
            if (canBack()) {
                ActionBar mActionBar = getSupportActionBar();
                if (mActionBar != null)
                    mActionBar.setDisplayHomeAsUpEnabled(true);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                mAppBarLayout.setElevation(10.6f);
            }
        }


        if (isSetRefresh()) {
            setupSwipeRefresh();
        }
    }

    private void setupSwipeRefresh() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setColorSchemeResources(R.color.refresh_progress_1, R.color.refresh_progress_2, R.color.refresh_progress_3);
            mSwipeRefreshLayout.setProgressViewOffset(true, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            mSwipeRefreshLayout.setOnRefreshListener(this::requestDataRefresh);
        }

    }

    public void setRefresh(boolean requestDataRefresh) {
        if (mSwipeRefreshLayout == null) {
            return;
        }
        if (!requestDataRefresh) {
            mIsRequestDataRefresh = false;
            mSwipeRefreshLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mSwipeRefreshLayout != null) {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }
            }, 1000);
        } else {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void requestDataRefresh() {
        mIsRequestDataRefresh = true;
    }

    private boolean isSetRefresh() {
        return false;
    }


    private boolean canBack() {
        return false;
    }

    protected abstract int provideContentViewId();

    protected abstract T createPresenter();


}
