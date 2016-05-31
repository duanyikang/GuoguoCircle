package com.guoguoquan.guoguonews.Model;

import android.util.SparseArray;

import com.guoguoquan.guoguonews.Model.http.DaoHttpImpl;
import com.guoguoquan.guoguonews.Model.http.listener.RequestCallback;
import com.guoguoquan.guoguonews.Bean.NewsBean;
import com.guoguoquan.guoguonews.Presenter.utils.Constant;

/**
 * @author 小段果果
 * @time 2016/5/30  11:26
 * @E-mail duanyikang@mumayi.com
 */

public class GetNewsBeanManager {

    public static GetNewsBeanManager mGetNewsBeanManager = null;

    private GetNewsBeanManager() {
    }

    private final int URL_TYPE_HOME = 1;
    private final int URL_TYPE_IMAGE = 2;
    private final int URL_TYPE_CIRCLE = 3;

    private String URL;
    private String[] key;
    private String[] value;


    public interface GetNetDataListener {

        void onSuccess(SparseArray<NewsBean> mDatas);

        void onFailed(String message);
    }

    public static GetNewsBeanManager getInstance() {
        if (mGetNewsBeanManager == null) {
            mGetNewsBeanManager = new GetNewsBeanManager();
        }
        return mGetNewsBeanManager;
    }

    public void getNewsBean(final int type, String[] key, String[] value, final GetNetDataListener mGetNetDataListener) {
        this.key = key;
        this.value = value;
        switch (type) {
            case URL_TYPE_HOME:
                URL = Constant.URL_JOKE;
                break;
            case URL_TYPE_IMAGE:
                URL = Constant.URL_IMAGE;
                break;
            case URL_TYPE_CIRCLE:
                URL = Constant.URL_GETCIRCL;
                break;
        }

        DaoHttpImpl.getInstance().POSTHttp(key, value, null, null, URL, new RequestCallback() {
            @Override
            public void onSuccess(Object obj) {
                switch (type) {
                    case URL_TYPE_HOME:
                        mGetNetDataListener.onSuccess(JsonResolveManager.getInstance().ResolveHomeList(obj.toString()));
                        break;
                    case URL_TYPE_IMAGE:
                        mGetNetDataListener.onSuccess(JsonResolveManager.getInstance().ResolveImageList(obj.toString()));
                        break;
                    case URL_TYPE_CIRCLE:
                        mGetNetDataListener.onSuccess(JsonResolveManager.getInstance().ResolveCircleList(obj.toString()));
                        break;
                }

            }

            @Override
            public void onFail(Object obj) {
                mGetNetDataListener.onFailed(obj.toString());
            }
        });
    }


}

