package com.guoguoquan.guoguonews.Model;

import android.util.SparseArray;

import com.guoguoquan.guoguonews.Bean.NewsBean;
import com.guoguoquan.guoguonews.Model.http.DaoHttpImpl;
import com.guoguoquan.guoguonews.Model.http.listener.RequestCallback;
import com.guoguoquan.guoguonews.Presenter.utils.Constant;

/**
 * Created by DYK on 2016/5/30.
 */
public class SubmitImageManager {
    public static SubmitImageManager mSubmitImageManager = null;


    public interface SubmitImageListener {
        void onPrograss(int number);

        void onSuccess(String message);

        void onFailed(String message);
    }

    private SubmitImageManager() {
    }

    public static SubmitImageManager getInstance() {
        if (mSubmitImageManager == null) {
            mSubmitImageManager = new SubmitImageManager();
        }
        return mSubmitImageManager;
    }

    public void submitImage(String[] key, String[] value, String[] filekey, String[] file, final SubmitImageListener mSubmitImageListener) {
        DaoHttpImpl.getInstance().POSTHttp(key, value, filekey, file, Constant.URL_SUBMIT, new RequestCallback() {

            @Override
            public void onProgress(int number) {
                super.onProgress(number);
                mSubmitImageListener.onPrograss(number);
            }

            @Override
            public void onSuccess(Object obj) {
                mSubmitImageListener.onSuccess(obj.toString());
            }

            @Override
            public void onFail(Object obj) {
                mSubmitImageListener.onFailed(obj.toString());
            }
        });
    }


}
