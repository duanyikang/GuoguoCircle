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
    private IViewGetNetData mIViewGetNetData;
    private GetNewsBeanManager mGetNewsBeanManager;

    private GetNetDataPresenter(IViewGetNetData mIViewGetNetData) {
        this.mIViewGetNetData = mIViewGetNetData;
        this.mGetNewsBeanManager = GetNewsBeanManager.getInstance();
    }

    public static GetNetDataPresenter getInstance(IViewGetNetData mIViewGetNetData)
    {
        if(mGetNetDataPresenter==null)
        {
            mGetNetDataPresenter=new GetNetDataPresenter(mIViewGetNetData);
        }
        return mGetNetDataPresenter;
    }

    public void go(int type, String[] key, String[] value) {

        mGetNewsBeanManager.getNewsBean(type, key, value, new GetNewsBeanManager.GetNetDataListener() {
            @Override
            public void onSuccess(SparseArray<NewsBean> mDatas) {
                mIViewGetNetData.showSuccess(mDatas);
            }

            @Override
            public void onFailed(String message) {
                mIViewGetNetData.showFailed(message);
            }
        });
    }

}

