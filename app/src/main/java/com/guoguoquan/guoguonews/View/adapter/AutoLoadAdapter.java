package com.guoguoquan.guoguonews.View.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.guoguoquan.guoguonews.R;
import com.guoguoquan.guoguonews.View.base.BaseAdapter;
import com.guoguoquan.guoguonews.View.listener.OnLoadMoreListener;

/**
 * ×÷Õß£ºduanyikang on 2016/9/20 0020 09:50
 * ÓÊÏä£ºduanyikang@yixia.com
 */
public abstract class AutoLoadAdapter<M, VH extends RecyclerView.ViewHolder> extends BaseAdapter<M, RecyclerView.ViewHolder> {

    private boolean canLoading = true;
    private OnLoadMoreListener loadMoreListener;

    private enum ITEM_TYPE {
        ITEM_TYPE_LOAD,
        ITEM_TYPE_ITEM
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*if(viewType==ITEM_TYPE.ITEM_TYPE_LOAD.ordinal()){
            return new FooterViewHolder(View.inflate(parent.getContext(), R.layout.foot_loading,null));
        }
        else
        {
            return onCreateViewHolder(parent);
        }*/
        return onCreateViewHolder(parent);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        /*if(getItemViewType(position)==ITEM_TYPE.ITEM_TYPE_LOAD.ordinal())
        {
            if (loadMoreListener!=null)
                loadMoreListener.onLoadMore();
        }
        else {
            onBindItemViewHolder((VH)holder,position);
    }*/
        onBindItemViewHolder((VH) holder, position);
    }

   /* @Override
    public int getItemViewType(int position) {
        return canLoading&&position==items.size()?ITEM_TYPE.ITEM_TYPE_LOAD.ordinal():ITEM_TYPE.ITEM_TYPE_ITEM.ordinal();
    }*/

    @Override
    public int getItemCount() {
        //return canLoading? getItemsSize()+1:getItemsSize();
        return getItemsSize();
    }


    public void setCanLoading(boolean b) {
        this.canLoading = b;
    }

    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public abstract VH onCreateViewHolder(ViewGroup parent);

    public abstract void onBindItemViewHolder(VH holder, int position);
}
