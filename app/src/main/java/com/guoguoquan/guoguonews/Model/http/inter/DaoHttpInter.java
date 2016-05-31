package com.guoguoquan.guoguonews.Model.http.inter;


import com.guoguoquan.guoguonews.Model.http.listener.RequestCallback;

/**
 * 作者：小段果果 on 2016/5/19 10:20
 * 邮箱：duanyikang@mumayi.com
 */
public interface DaoHttpInter {
    void POSTHttp(String key[],String value[],String filekey[],String file[] ,String URL,RequestCallback callback);
    void GETHttp(String URL,String key[],String value[],RequestCallback callback);
}
