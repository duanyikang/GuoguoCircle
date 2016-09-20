package com.guoguoquan.guoguonews.View.base;

import android.support.v7.widget.RecyclerView;

import com.guoguoquan.guoguonews.Presenter.base.BasePresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 作者：duanyikang on 2016/9/20 0020 09:24
 * 邮箱：duanyikang@yixia.com
 */
public abstract class BaseAdapter<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<M> items = Collections.synchronizedList(new ArrayList<M>());
    protected RecyclerView recyclerView;

    public BaseAdapter() {
    }


    //向列表中添加对象
    public void add(M object) {
        items.add(object);
    }

    public void add(int index, M object) {
        items.add(index, object);
    }

    public void addAll(Collection<? extends M> collection) {
        if (collection != null) {
            items.addAll(collection);
        }
    }

    public void addAll(M... items) {
        addAll(Arrays.asList(items));
    }


    //清除列表中的对象
    public void clear() {
        items.clear();
    }

    public void remove(int position) {
        items.remove(position);
    }

    public void remove(M object) {
        items.remove(object);
    }

    //设置列表中的某一项
    public void set(int position, M m) {
        items.set(position, m);
    }

    //获取列表或者列表中的某一项
    public M getItem(int position) {
        return items.get(position);
    }

    public List<M> getItems() {
        return items;
    }

    public int getItemsSize() {
        return items.size();
    }


}
