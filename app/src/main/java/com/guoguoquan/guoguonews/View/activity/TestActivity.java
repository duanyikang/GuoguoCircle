package com.guoguoquan.guoguonews.View.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.guoguoquan.guoguonews.Presenter.BasePresenter;
import com.guoguoquan.guoguonews.R;
import com.guoguoquan.guoguonews.View.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 作者：duanyikang on 2016/9/9 0009 16:25
 * 邮箱：duanyikang@yixia.com
 */
public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


}
