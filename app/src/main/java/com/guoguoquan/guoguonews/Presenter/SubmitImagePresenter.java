package com.guoguoquan.guoguonews.Presenter;

import com.guoguoquan.guoguonews.Model.SubmitImageManager;
import com.guoguoquan.guoguonews.Presenter.utils.SnackbarUtil;
import com.guoguoquan.guoguonews.View.IViewSubmitImage;

/**
 * Created by DYK on 2016/5/30.
 */
public class SubmitImagePresenter {

    public static SubmitImagePresenter mSubmitImagePresenter = null;
    private IViewSubmitImage mIViewSubmitImage;
    private SubmitImageManager mSubmitImageManager;

    private SubmitImagePresenter(IViewSubmitImage mIViewSubmitImage) {
        this.mIViewSubmitImage = mIViewSubmitImage;
        mSubmitImageManager = SubmitImageManager.getInstance();
    }

    public static SubmitImagePresenter getInstance(IViewSubmitImage mIViewSubmitImage) {
        if (mSubmitImagePresenter == null) {
            mSubmitImagePresenter = new SubmitImagePresenter(mIViewSubmitImage);
        }
        return mSubmitImagePresenter;
    }


    public void go(String[] value, String[] filevalue) {
        String key[] = {"nickname", "content"};
        String filekey[] = {"avatar_image", "pic_image"};

        if (!checkData(value, filevalue))
            return;

        mSubmitImageManager.submitImage(key, value, filekey, filevalue, new SubmitImageManager.SubmitImageListener() {
            @Override
            public void onPrograss(int number) {
                mIViewSubmitImage.onPrograss(number);
            }

            @Override
            public void onSuccess(String message) {
                mIViewSubmitImage.showSuccess(message);
            }

            @Override
            public void onFailed(String message) {
                mIViewSubmitImage.showFailed(message);
            }
        });
    }

    private Boolean checkData(String[] value, String[] filevalue) {
        if (value[0].equals("") || value[0].length() == 0) {
            mIViewSubmitImage.showFailed("昵称不能为空");
            return false;
        }
        if (value[1].equals("") || value[1].length() == 0) {
            mIViewSubmitImage.showFailed("内容不能为空");
            return false;
        }
        if (filevalue[0].equals("")) {
            mIViewSubmitImage.showFailed("头像不能为空");
            return false;
        }
        if (filevalue[1].equals("")) {
            mIViewSubmitImage.showFailed("图片内容不能为空");
            return false;
        }
        return true;
    }


}
