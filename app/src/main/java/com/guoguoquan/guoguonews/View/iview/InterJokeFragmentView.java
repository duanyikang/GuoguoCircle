package com.guoguoquan.guoguonews.View.iview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * 作者：duanyikang on 2016/9/13 0013 15:43
 * 邮箱：duanyikang@yixia.com
 */
public interface InterJokeFragmentView {

    void setDataRefresh(Boolean b);

    RecyclerView getRecyclerView();

    LinearLayoutManager getLayoutManager();
}
