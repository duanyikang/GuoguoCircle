package com.guoguoquan.guoguonews.View.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.guoguoquan.guoguonews.View.base.BaseFragment;


import java.util.List;


public class ViewPagerFgAdapter extends FragmentPagerAdapter {

    private String tag;

    private List<BaseFragment> fragmentList;


    public ViewPagerFgAdapter(FragmentManager supportFragmentManager, List<BaseFragment> fragmentList, String tag) {
        super(supportFragmentManager);
        this.fragmentList = fragmentList;
        this.tag = tag;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        if (fragmentList != null) {
            return fragmentList.size();
        }
        return 0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (tag.equals("main_view_pager")) {
            switch (position) {
                case 0:
                    return "JOKE";
                case 1:
                    return "NEWS";
                case 2:
                    return "WETHER";
            }
        }
        return null;
    }
}
