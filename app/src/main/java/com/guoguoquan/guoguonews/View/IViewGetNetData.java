package com.guoguoquan.guoguonews.View;

import android.util.SparseArray;

import com.guoguoquan.guoguonews.Bean.NewsBean;

/**
 * @author 小段果果
 * @time 2016/5/30  16:08
 * @E-mail duanyikang@mumayi.com
 */

public interface IViewGetNetData {


    void showLoading();

    void hideLoading();

    void showSuccess(SparseArray<NewsBean> mDatas);

    void showFailed(String message);
}

