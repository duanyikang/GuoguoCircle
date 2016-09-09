package com.guoguoquan.guoguonews.Model.http;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 作者：duanyikang on 2016/9/9 0009 16:05
 * 邮箱：duanyikang@yixia.com
 */
public interface ApiStores {
    /**
     * 基础url
     */
    String Base_API_SERVER_URL="http://www.weather.com.cn/";

    @GET("adat/sk/{cityId}.html")
    Observable<MainModel> loadData(@Path("cityId") String cityId);
}
