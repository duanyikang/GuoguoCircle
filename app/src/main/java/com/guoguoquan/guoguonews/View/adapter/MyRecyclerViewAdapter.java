

package com.guoguoquan.guoguonews.View.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoguoquan.guoguonews.Bean.NewsBean;
import com.guoguoquan.guoguonews.R;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewBeanHolder> {



    public Context mContext;
    public SparseArray<NewsBean> mDatas;
    public LayoutInflater mLayoutInflater;

    public MyRecyclerViewAdapter(Context mContext, SparseArray<NewsBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public MyRecyclerViewBeanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = mLayoutInflater.inflate(R.layout.item_news_image, parent, false);
        MyRecyclerViewBeanHolder mViewHolder = new MyRecyclerViewBeanHolder(mView);
        return mViewHolder;
    }

    /**
     * 绑定ViewHoler，给item中的控件设置数据
     */
    @Override
    public void onBindViewHolder(final MyRecyclerViewBeanHolder holder, final int position) {

        if (mDatas.get(position).getBean_image_url().length() > 5) {
            holder.iv_giforimage.setAspectRatio(mDatas.get(position).getBean_image_pro());
            holder.iv_giforimage.setImageURI(Uri.parse(mDatas.get(position).getBean_image_url()));
            holder.iv_giforimage.setVisibility(View.VISIBLE);

        } else
            holder.iv_giforimage.setVisibility(View.GONE);


    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
