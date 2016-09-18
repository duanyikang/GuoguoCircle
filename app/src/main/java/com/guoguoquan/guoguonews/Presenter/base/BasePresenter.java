package com.guoguoquan.guoguonews.Presenter.base;

import android.widget.Toast;

import com.guoguoquan.guoguonews.Model.http.ApiFactory;
import com.guoguoquan.guoguonews.Model.http.NetApi;
import com.guoguoquan.guoguonews.MyApplication;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 作者：duanyikang on 2016/9/13 0013 14:02
 * 邮箱：duanyikang@yixia.com
 */
public abstract class BasePresenter<V> {
    protected Reference<V> mViewRef;

    public static final NetApi netApi = ApiFactory.getNetApiSingleton();


    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public void loadError(Throwable throwable) {
        throwable.printStackTrace();
        Toast.makeText(MyApplication.context, throwable.toString(), Toast.LENGTH_LONG).show();

    }
}
