package com.guoguoquan.guoguonews.Presenter.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 小段果果
 * @time 2016/5/19  17:58
 * @E-mail duanyikang@mumayi.com
 */

public class ThreadPoolUtil {
    private static final ThreadPoolUtil manager;
    private ExecutorService service;

    private ThreadPoolUtil() {
        this.service = Executors.newCachedThreadPool();
    }

    static {
        manager = new ThreadPoolUtil();
    }

    public static ThreadPoolUtil getInstance() {
        return manager;
    }

    public void addTask(Runnable runnable) {
        this.service.submit(runnable);
    }

    public void stopTask() {
        this.service.shutdown();
    }
}

