package com.guoguoquan.guoguonews.Presenter;

/**
 * 作者：duanyikang on 2016/9/9 0009 15:50
 * 邮箱：duanyikang@yixia.com
 */
public interface Presenter<V> {
    void attachView(V view);
    void detachView();
}
