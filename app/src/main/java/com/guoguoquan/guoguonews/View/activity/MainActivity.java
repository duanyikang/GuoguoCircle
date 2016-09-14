
package com.guoguoquan.guoguonews.View.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.guoguoquan.guoguonews.Presenter.base.BasePresenter;
import com.guoguoquan.guoguonews.R;
import com.guoguoquan.guoguonews.View.adapter.ViewPagerFgAdapter;
import com.guoguoquan.guoguonews.View.base.BaseActivity;
import com.guoguoquan.guoguonews.View.base.BaseFragment;
import com.guoguoquan.guoguonews.View.fragment.JokeFragment;
import com.guoguoquan.guoguonews.View.fragment.NewsFragment;
import com.guoguoquan.guoguonews.View.fragment.WetherFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.content_viewPager)
    ViewPager mViewPager;

    private List<BaseFragment> mFragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = (ViewPager) findViewById(R.id.content_viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        initTabView();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void initTabView() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new JokeFragment());
        mFragmentList.add(new JokeFragment());
        mFragmentList.add(new JokeFragment());

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new ViewPagerFgAdapter(getSupportFragmentManager(), mFragmentList, "main_view_pager"));
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
