package com.guoguoquan.guoguonews.View.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guoguoquan.guoguonews.R;



public class MyRecyclerViewBeanHolder extends RecyclerView.ViewHolder {


  public SimpleDraweeView iv_user_avatar,iv_giforimage;
  public TextView tv_user_name;
  public TextView tv_item_content;

  public MyRecyclerViewBeanHolder(View itemView) {
    super(itemView);
    iv_user_avatar=(SimpleDraweeView)itemView.findViewById(R.id.iv_user_avatar);
    tv_user_name=(TextView)itemView.findViewById(R.id.tv_user_name);
    tv_item_content=(TextView)itemView.findViewById(R.id.tv_item_content);
    iv_giforimage=(SimpleDraweeView)itemView.findViewById(R.id.iv_giforimage);
  }
}
