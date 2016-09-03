package com.guoguoquan.guoguonews.View;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author 小段果果
 * @time 2016/5/18  14:25
 * @E-mail duanyikang@mumayi.com
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
		//facebook图片加载初始化
        Fresco.initialize(this);
    }
}

