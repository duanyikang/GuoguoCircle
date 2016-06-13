package com.guoguoquan.guoguonews.Presenter;

import android.util.SparseArray;

import com.guoguoquan.guoguonews.Bean.NewsBean;
import com.guoguoquan.guoguonews.View.IViewGetNetData;

/**
 * @author 小段果果
 * @time 2016/6/13  15:15
 * @E-mail duanyikang@mumayi.com
 */

public class ImplGetNetDataWatcher implements GetNetDataWatcher {

    private SparseArray<IViewGetNetData> list = new SparseArray<IViewGetNetData>();

    @Override
    public void addWatcher(IViewGetNetData watcher, int type) {
        list.append(type, watcher);
    }

    @Override
    public void removeWatcher(IViewGetNetData watcher, int type) {
        list.remove(type);
    }

    @Override
    public void notifyshowLoading(int type) {
        if (list.get(type) != null)
            list.get(type).showLoading();
    }

    @Override
    public void notifyhideLoading(int type) {
        if (list.get(type) != null)
            list.get(type).showLoading();
    }

    @Override
    public void notifyshowSuccess(SparseArray<NewsBean> mDatas, int type) {
        if (list.get(type) != null)
            list.get(type).showSuccess(mDatas);
    }

    @Override
    public void notifyshowFailed(String message, int type) {
        if (list.get(type) != null)
            list.get(type).showFailed(message);
    }


}

