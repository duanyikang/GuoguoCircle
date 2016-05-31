package com.guoguoquan.guoguonews.View.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.guoguoquan.guoguonews.Presenter.SubmitImagePresenter;
import com.guoguoquan.guoguonews.Presenter.utils.Constant;
import com.guoguoquan.guoguonews.Presenter.utils.ImageUtil;
import com.guoguoquan.guoguonews.Presenter.utils.SnackbarUtil;
import com.guoguoquan.guoguonews.R;
import com.guoguoquan.guoguonews.View.IViewSubmitImage;

/**
 * @author 小段果果
 * @time 2016/5/25  11:06
 * @E-mail duanyikang@mumayi.com
 */

public class SubmitFragment extends BaseFragment implements View.OnClickListener ,IViewSubmitImage{

    private ImageView iv_submit_avatar, iv_submit_pic;
    private EditText ed_submit_nickname, ed_submit_content;
    private Button bt_submit;
    private String iv_avater_file="", iv_pic_file="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_submit_layout, container, false);
        initView();
        return mView;
    }

    public void initView() {
        iv_submit_avatar = (ImageView) mView.findViewById(R.id.iv_submit_avatar);
        iv_submit_pic = (ImageView) mView.findViewById(R.id.iv_submit_pic);
        ed_submit_nickname = (EditText) mView.findViewById(R.id.ed_submit_nickname);
        ed_submit_content = (EditText) mView.findViewById(R.id.ed_submit_content);
        bt_submit = (Button) mView.findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(this);
        iv_submit_pic.setOnClickListener(this);
        iv_submit_avatar.setOnClickListener(this);
    }


    private void submitJok() {

        String value[] = {ed_submit_nickname.getText().toString(), ed_submit_content.getText().toString()};
        String filevalue[]={iv_avater_file,iv_pic_file};
        SubmitImagePresenter.getInstance(this).go(value,filevalue);

    }

    private void OpenPhotoGallery(int CODE) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {
            Bitmap bm = null;
            bm = ImageUtil.getInstance().decodeBitmapFromFile(getRealPathFromURI(data.getData()),500, 500);
            if (requestCode == 200) {
                iv_submit_avatar.setImageBitmap(bm);
                ImageUtil.getInstance().saveBitmap("submit_avater.png", bm);
                iv_avater_file= Constant.FILE_BASE+"/submit_avater.png";
            }
            if (requestCode == 300) {
                iv_submit_pic.setImageBitmap(bm);
                ImageUtil.getInstance().saveBitmap("submit_pic.png", bm);
                iv_pic_file= Constant.FILE_BASE+"/submit_pic.png";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public String getRealPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_submit:
                submitJok();
                break;
            case R.id.iv_submit_avatar:
                OpenPhotoGallery(200);
                break;
            case R.id.iv_submit_pic:
                OpenPhotoGallery(300);
                break;
        }

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onPrograss(int number) {
        System.out.println("-----"+number);
    }

    @Override
    public void showSuccess(String message) {
        System.out.println("mmmmmmmmmmmm"+message);
    }

    @Override
    public void showFailed(String message) {
        System.out.println("ffffffffffffff"+message);
    }
}

