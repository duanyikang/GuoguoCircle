package com.guoguoquan.guoguonews.View.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.guoguoquan.guoguonews.R;

/**
 * Created by duanyikang on 16/9/18.
 */
public class WebActivity extends Activity {
    private TextView tv_news_detail_titl;
    private WebView mWebView;
    private String startUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
        initData();
    }

    private void initView() {
        tv_news_detail_titl = (TextView) findViewById(R.id.tv_news_detail_title);
        mWebView = (WebView) findViewById(R.id.webview);
    }
    private void initData() {
        startUrl=getIntent().getExtras().getString("url");
    }
}
