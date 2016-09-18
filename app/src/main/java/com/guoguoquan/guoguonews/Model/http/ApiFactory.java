package com.guoguoquan.guoguonews.Model.http;

import java.util.Objects;

/**
 * 作者：duanyikang on 2016/9/13 0013 17:31
 * 邮箱：duanyikang@yixia.com
 */
public class ApiFactory {

    protected static final Object monitor = new Object();

    static NetApi netApiSingleton = null;

    public static NetApi getNetApiSingleton() {
        synchronized (monitor) {
            if (netApiSingleton == null) {
                netApiSingleton = new ApiRetrofit().getNetApiService();
            }
            return netApiSingleton;
        }
    }
}
