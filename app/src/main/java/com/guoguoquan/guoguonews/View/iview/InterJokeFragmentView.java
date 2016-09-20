package com.guoguoquan.guoguonews.View.iview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.guoguoquan.guoguonews.Bean.JokeBean;

import java.util.List;

/**
 * 作者：duanyikang on 2016/9/13 0013 15:43
 * 邮箱：duanyikang@yixia.com
 */
public interface InterJokeFragmentView {

    /**
     * 别人笑我太疯癫，我笑他人看不穿
     * <p>
     * 突然想到一个问题，刷新和加载更多是两个概念
     * 刷新和加载更多UI方面都是主动的，当不需要的时候关键点是收到回调
     */

    /*void refreshSuccess(List<JokeBean> list);
    void loadMoreSuccess(List)*/

    void setDataRefresh(Boolean b);

    RecyclerView getRecyclerView();

    LinearLayoutManager getLayoutManager();
}
