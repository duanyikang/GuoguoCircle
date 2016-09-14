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

import java.util.List;


/**
 * 作者：duanyikang on 2016/9/14 0014 11:12
 * 邮箱：duanyikang@yixia.com
 */
public class JokeFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<JokeBean> jokeList;

    public JokeFragmentAdapter(Context context, List<JokeBean> jokeList) {
        this.mContext = context;
        this.jokeList = jokeList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = View.inflate(parent.getContext(), R.layout.layout_joke_normal_item, null);
        return new JokeViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        JokeViewHolder mHolder = (JokeViewHolder) holder;
        mHolder.bindItem(jokeList.get(position));
    }

    @Override
    public int getItemCount() {
        return jokeList.size();
    }


    class JokeViewHolder extends RecyclerView.ViewHolder {

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
            iv_user_avatar.setImageURI(Uri.parse("http://7xopn5.com1.z0.glb.clouddn.com/头像.jpg"));
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
