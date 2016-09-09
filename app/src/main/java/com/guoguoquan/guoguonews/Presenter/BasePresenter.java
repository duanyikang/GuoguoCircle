package com.guoguoquan.guoguonews.Presenter;

/**
 * 作者：duanyikang on 2016/9/9 0009 15:48
 * 邮箱：duanyikang@yixia.com
 */
public class BasePresenter<V> implements Presenter {

    public V mvpView;


    @Override
    public void attachView(Object view) {

    }

    @Override
    public void detachView() {

    }
}
