package com.guoguoquan.guoguonews.View.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guoguoquan.guoguonews.R;

/**
 * @author 小段果果
 * @time 2016/5/25  10:28
 * @E-mail duanyikang@mumayi.com
 */

public class MyRecyclerViewImageHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView iv_giforimage;


    public MyRecyclerViewImageHolder(View itemView) {
        super(itemView);
        iv_giforimage=(SimpleDraweeView)itemView.findViewById(R.id.iv_giforimage);
    }
}

