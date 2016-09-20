package com.guoguoquan.guoguonews.View.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

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
        startUrl = getIntent().getExtras().getString("url");
        if (TextUtils.isEmpty(startUrl)) {
            Toast.makeText(this, "网址不能为空", Toast.LENGTH_LONG).show();
            return;
        }

        //webview的一些简单设置
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);    //设置webview支持javascript
        settings.setLoadsImagesAutomatically(true);    //支持自动加载图片
        settings.setUseWideViewPort(true);    //设置webview推荐使用的窗口，使html界面自适应屏幕
        settings.setSaveFormData(true);    //设置webview保存表单数据
        settings.setSupportZoom(true);    //支持缩放
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT > 8) {
            settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        }

        mWebView.setWebViewClient(new WebViewClient() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (view != null)
                    view.loadUrl(String.valueOf(request.getUrl()));
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                tv_news_detail_titl.setText(view.getTitle());
                super.onPageFinished(view, url);
            }
        });

        mWebView.loadUrl(startUrl);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebView = null;
    }
}
