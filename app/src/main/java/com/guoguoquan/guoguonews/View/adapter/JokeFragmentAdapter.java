package com.guoguoquan.guoguonews.View.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guoguoquan.guoguonews.Bean.JokeBean;
import com.guoguoquan.guoguonews.R;

/**
 * ×÷Õß£ºduanyikang on 2016/9/20 0020 10:38
 * ÓÊÏä£ºduanyikang@yixia.com
 */
public class JokeFragmentAdapter extends AutoLoadAdapter<JokeBean, JokeFragmentAdapter.JokeViewHolder> {

    private Context mContext;

    public JokeFragmentAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public JokeFragmentAdapter.JokeViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = View.inflate(parent.getContext(), R.layout.layout_joke_normal_item, null);
        return new JokeViewHolder(v);
    }

    @Override
    public void onBindItemViewHolder(JokeFragmentAdapter.JokeViewHolder holder, int position) {
        holder.bindItem(getItem(position));
    }

    static class JokeViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView iv_user_avatar;
        TextView tv_user_name;
        TextView tv_item_content;
        SimpleDraweeView iv_giforimage;

        public JokeViewHolder(View itemView) {
            super(itemView);
            iv_user_avatar = (SimpleDraweeView) itemView.findViewById(R.id.iv_user_avatar);
            tv_user_name = (TextView) itemView.findViewById(R.id.tv_user_name);
            tv_item_content = (TextView) itemView.findViewById(R.id.tv_item_content);
            iv_giforimage = (SimpleDraweeView) itemView.findViewById(R.id.iv_giforimage);
        }

        public void bindItem(JokeBean jokeBean) {
            iv_user_avatar.setImageURI(Uri.parse("http://img1.imgtn.bdimg.com/it/u=367740859,2357929488&fm=21&gp=0.jpg"));
            tv_user_name.setText(jokeBean.getAuthor());
            tv_item_content.setText(jokeBean.getContent());
            if (jokeBean.getPicurl() != null) {
                iv_giforimage.setImageURI(Uri.parse(jokeBean.getPicurl()));
                iv_giforimage.setVisibility(View.VISIBLE);
            } else {
                iv_giforimage.setVisibility(View.GONE);
            }

        }
    }
}
