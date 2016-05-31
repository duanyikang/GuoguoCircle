package com.guoguoquan.guoguonews.Model.http.listener;

/**
 * 作者：小段果果 on 2016/5/19 10:24
 * 邮箱：duanyikang@mumayi.com
 */
public abstract class RequestCallback {
    public abstract  void onSuccess(Object obj);

    public abstract void onFail(Object obj);

    public void onProgress(int number)
    {

    }

}
