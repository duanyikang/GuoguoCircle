package com.guoguoquan.guoguonews;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author 小段果果
 * @time 2016/5/18  14:25
 * @E-mail duanyikang@mumayi.com
 */

public class MyApplication extends Application {

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
		//facebook图片加载初始化
        Fresco.initialize(this);
        context=getApplicationContext();
    }
}

/**
 * 为了技术还是舍弃一部分功能，此处从新把Retrofit Rxjava Butterknif配合MVP模式重构下自己的项目
 *
 *
 * 保留侧滑菜单
 * 目前主页有三个fragment
 *  分别是 1.笑话
 *        2.新闻
 *        3.天气
 *  后期会把时事通信放进来
 *
 */