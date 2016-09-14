package com.guoguoquan.guoguonews.Model.http;

import com.guoguoquan.guoguonews.MyApplication;
import com.guoguoquan.guoguonews.Util.StateUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：duanyikang on 2016/9/13 0013 17:05
 * 邮箱：duanyikang@yixia.com
 */
public class ApiRetrofit {

    public JokeApi JokeApiService;

    public static final String Base_Url = "http://api.1-blog.com/biz/bizserver/";

    public JokeApi getJokeApiService() {
        return JokeApiService;
    }

    public ApiRetrofit() {
        File httpCacheDirectory=new File(MyApplication.context.getCacheDir(),"responses");
        int cacheSize=10*1024*1024;
        Cache cache=new Cache(httpCacheDirectory,cacheSize);

        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache)
                .build();

        Retrofit retrofit_joke=new Retrofit.Builder()
                .baseUrl(Base_Url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();



        JokeApiService=retrofit_joke.create(JokeApi.class);

    }
    Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {

        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
        cacheBuilder.maxAge(0, TimeUnit.SECONDS);
        cacheBuilder.maxStale(365, TimeUnit.DAYS);
        CacheControl cacheControl = cacheBuilder.build();

        Request request = chain.request();
        if (!StateUtils.isNetworkAvailable(MyApplication.context)) {
            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build();

        }
        Response originalResponse = chain.proceed(request);
        if (StateUtils.isNetworkAvailable(MyApplication.context)) {
            int maxAge = 0; // read from cache
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public ,max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    };

}
