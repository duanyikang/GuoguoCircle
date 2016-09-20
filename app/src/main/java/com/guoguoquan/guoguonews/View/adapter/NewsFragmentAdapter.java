package com.guoguoquan.guoguonews.View.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoguoquan.guoguonews.Bean.NewsBean;
import com.guoguoquan.guoguonews.R;
import com.guoguoquan.guoguonews.View.activity.WebActivity;

import java.util.List;

/**
 * ×÷Õß£ºduanyikang on 2016/9/18 0018 09:45
 * ÓÊÏä£ºduanyikang@yixia.com
 */
public class NewsFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<NewsBean> NewsList;
    private String TAG = getClass().getName();

    public NewsFragmentAdapter(Context mContext, List<NewsBean> mList) {
        this.mContext = mContext;
        this.NewsList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = View.inflate(parent.getContext(), R.layout.layout_news_normal_item, null);
        return new NewsViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewsViewHolder mHolder = (NewsViewHolder) holder;
        mHolder.bindItem(NewsList.get(position));
        mHolder.rootView.setOnClickListener(v -> Log.i(TAG, NewsList.get(position).getArticle_url()));
        mHolder.tv_news_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WebActivity.class);
                intent.putExtra("url", NewsList.get(position).getArticle_url());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NewsList.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView tv_news_title;
        ImageView iv_news_img;
        View rootView;

        public NewsViewHolder(View rootView) {
            super(rootView);
            tv_news_title = (TextView) rootView.findViewById(R.id.tv_news_title);
            iv_news_img = (ImageView) rootView.findViewById(R.id.iv_news_img);
            this.rootView = rootView;
        }

        public void bindItem(NewsBean bean) {
            tv_news_title.setText(bean.getTitle());
            iv_news_img.setImageResource(R.mipmap.iv_add_pic);
        }
    }
}
