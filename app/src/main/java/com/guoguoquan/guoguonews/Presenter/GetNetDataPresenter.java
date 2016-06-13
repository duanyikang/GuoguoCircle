package com.guoguoquan.guoguonews.Presenter;

import android.util.SparseArray;

import com.guoguoquan.guoguonews.Model.GetNewsBeanManager;
import com.guoguoquan.guoguonews.View.IViewGetNetData;
import com.guoguoquan.guoguonews.Bean.NewsBean;

/**
 * @author 小段果果
 * @time 2016/5/30  15:42
 * @E-mail duanyikang@mumayi.com
 */

public class GetNetDataPresenter {
    public static GetNetDataPresenter mGetNetDataPresenter = null;

    public static ImplGetNetDataWatcher implGetNetDataWatcher=new ImplGetNetDataWatcher();
    private GetNewsBeanManager mGetNewsBeanManager;

    private GetNetDataPresenter() {

        this.mGetNewsBeanManager = GetNewsBeanManager.getInstance();
    }

    public static GetNetDataPresenter getInstance(IViewGetNetData mIViewGetNetData,int type)
    {
        if(mGetNetDataPresenter==null)
        {
            mGetNetDataPresenter=new GetNetDataPresenter();
        }

        implGetNetDataWatcher.addWatcher(mIViewGetNetData,type);
        return mGetNetDataPresenter;
    }

    public void go(int type, String[] key, String[] value) {

        mGetNewsBeanManager.getNewsBean(type, key, value, new GetNewsBeanManager.GetNetDataListener() {
            @Override
            public void onSuccess(SparseArray<NewsBean> mDatas,int type) {
                implGetNetDataWatcher.notifyshowSuccess(mDatas,type);

            }

            @Override
            public void onFailed(String message,int type) {
                implGetNetDataWatcher.notifyshowFailed(message,type);
            }
        });
    }

}

