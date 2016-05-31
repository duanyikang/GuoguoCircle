package com.guoguoquan.guoguonews.View;

import android.util.SparseArray;

import com.guoguoquan.guoguonews.Bean.NewsBean;

/**
 * Created by DYK on 2016/5/30.
 */
public interface IViewSubmitImage {
    void showLoading();

    void hideLoading();

    void onPrograss(int number);

    void showSuccess(String message);

    void showFailed(String message);
}
