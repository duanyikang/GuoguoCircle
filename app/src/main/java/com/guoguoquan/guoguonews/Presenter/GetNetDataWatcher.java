package com.guoguoquan.guoguonews.Presenter;

import android.util.SparseArray;

import com.guoguoquan.guoguonews.Bean.NewsBean;
import com.guoguoquan.guoguonews.View.IViewGetNetData;

/**
 * @author 小段果果
 * @time 2016/6/13  15:14
 * @E-mail duanyikang@mumayi.com
 */

public interface GetNetDataWatcher {
    void addWatcher(IViewGetNetData watcher,int type);

    void removeWatcher(IViewGetNetData watcher, int type);

    void notifyshowLoading(int type);

    void notifyhideLoading(int type);

    void notifyshowSuccess(SparseArray<NewsBean> mDatas, int type);

    void notifyshowFailed(String message, int type);
}

