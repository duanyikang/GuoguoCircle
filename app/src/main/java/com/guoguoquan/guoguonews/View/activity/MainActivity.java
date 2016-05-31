
package com.guoguoquan.guoguonews.View.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.guoguoquan.guoguonews.Presenter.utils.SnackbarUtil;
import com.guoguoquan.guoguonews.R;
import com.guoguoquan.guoguonews.View.adapter.MyViewPagerAdapter;
import com.guoguoquan.guoguonews.View.fragment.BaseFragment;
import com.guoguoquan.guoguonews.View.fragment.CircleFragment;
import com.guoguoquan.guoguonews.View.fragment.FunImageFragment;
import com.guoguoquan.guoguonews.View.fragment.JokeFragment;
import com.guoguoquan.guoguonews.View.fragment.SubmitFragment;
import com.guoguoquan.guoguonews.View.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;
import static android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, OnClickListener {

    //初始化各种控件，照着xml中的顺序写
    private DrawerLayout mDrawerLayout;
    private CoordinatorLayout mCoordinatorLayout;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private NavigationView mNavigationView;

    // TabLayout中的tab标题
    private String[] mTitles;
    // 填充到ViewPager中的Fragment
    private List<Fragment> mFragments;
    // ViewPager的数据适配器
    private MyViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        initViews();
        initData();
        configViews();

    }

    private void initData() {
        mTitles = getResources().getStringArray(R.array.tab_titles);
        mFragments = new ArrayList<>();
        mFragments.add(0, new JokeFragment());
        mFragments.add(1, new FunImageFragment());
        mFragments.add(2, new VideoFragment());
        mFragments.add(3, new CircleFragment());
        mFragments.add(4, new SubmitFragment());
    }

    private void configViews() {

        // 设置显示Toolbar
        setSupportActionBar(mToolbar);

        // 设置Drawerlayout开关指示器，即Toolbar最左边的那个icon
        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        //给NavigationView填充顶部区域，也可在xml中使用app:headerLayout="@layout/header_nav"来设置
        mNavigationView.inflateHeaderView(R.layout.header_nav);
        //给NavigationView填充Menu菜单，也可在xml中使用app:menu="@menu/menu_nav"来设置
        mNavigationView.inflateMenu(R.menu.menu_nav);

        // 自己写的方法，设置NavigationView中menu的item被选中后要执行的操作
        onNavgationViewMenuItemSelected(mNavigationView);

        // 初始化ViewPager的适配器，并设置给它
        mViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mTitles, mFragments);
        mViewPager.setAdapter(mViewPagerAdapter);
        // 设置ViewPager最大缓存的页面个数
        mViewPager.setOffscreenPageLimit(5);
        // 给ViewPager添加页面动态监听器（为了让Toolbar中的Title可以变化相应的Tab的标题）
        mViewPager.addOnPageChangeListener(this);

        mTabLayout.setTabMode(MODE_SCROLLABLE);
        // 将TabLayout和ViewPager进行关联，让两者联动起来
        mTabLayout.setupWithViewPager(mViewPager);
        // 设置Tablayout的Tab显示ViewPager的适配器中的getPageTitle函数获取到的标题
        mTabLayout.setTabsFromPagerAdapter(mViewPagerAdapter);

    }

    /**
     * 设置NavigationView中menu的item被选中后要执行的操作
     *
     * @param mNav
     */
    private void onNavgationViewMenuItemSelected(NavigationView mNav) {
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                String msgString = "";

                switch (menuItem.getItemId()) {
                    case R.id.nav_menu_home:
                        msgString = (String) menuItem.getTitle();
                        break;
                    case R.id.nav_menu_feedback:
                        msgString = (String) menuItem.getTitle();
                        break;
                }

                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                SnackbarUtil.show(mViewPager, msgString, 0);

                return true;
            }
        });
    }

    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.id_coordinatorlayout);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.id_appbarlayout);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mNavigationView = (NavigationView) findViewById(R.id.id_navigationview);

    }


    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    public void setCurrentPage(int i)
    {
        mViewPager.setCurrentItem(i);
        ((BaseFragment)mViewPagerAdapter.getItem(i)).onRefresh();
    }
}
