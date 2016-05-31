package com.guoguoquan.guoguonews.Model.http;


import com.guoguoquan.guoguonews.Model.http.inter.DaoHttpInter;
import com.guoguoquan.guoguonews.Model.http.listener.RequestCallback;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cz.msebera.android.httpclient.Header;

/**
 * @author 小段果果
 * @time 2016/5/19  10:27
 * @E-mail duanyikang@mumayi.com
 */

public class DaoHttpImpl implements DaoHttpInter {

    private static DaoHttpImpl mDaoHttpImpl = null;
    AsyncHttpClient client = new AsyncHttpClient();

    private DaoHttpImpl() {
    }

    public static DaoHttpImpl getInstance() {
        if (mDaoHttpImpl == null) {
            mDaoHttpImpl = new DaoHttpImpl();

        }
        return mDaoHttpImpl;
    }


    @Override
    public void POSTHttp(String[] key, String[] value, String[] filekey, String[] file, String URL, final RequestCallback callback) {
        client.post(URL, getParams(key,value,filekey,file), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    callback.onSuccess(new String(responseBody, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onProgress(long bytesWritten, long totalSize) {
               callback.onProgress((int) (((double)bytesWritten/(double)totalSize)*100));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                callback.onFail(responseBody.toString());
            }
        });
    }

    @Override
    public void GETHttp(final String URL, final String[] key, final String[] value, final com.guoguoquan.guoguonews.Model.http.listener.RequestCallback callback) {
        client.get(getUrlContent(URL, key, value), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    callback.onSuccess(new String(responseBody, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                callback.onFail(responseBody.toString());
            }
        });
    }

    public String getUrlContent(String url, String[] newKey, String[] newValue) {
        StringBuffer sb = new StringBuffer();
        if (url.contains("?")) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        try {
            for (int i = 0; i < newKey.length; i++) {
                if (i == 0) {
                    sb.append(newKey[i] + "=" + URLEncoder.encode(newValue[i], "UTF-8"));
                } else {
                    sb.append("&" + newKey[i] + "=" + URLEncoder.encode(newValue[i], "UTF-8"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return url + sb.toString();
    }


    public RequestParams getParams(String[] key, String[] value, String[] filekey, String[] file)
    {
        RequestParams params = new RequestParams();
        if(key!=null&&key.length>0&&value.length>0&& key.length==value.length)
        {
            for(int i=0;i<key.length;i++)
            {
                params.add(key[i],value[i]);
            }
        }
        if(filekey!=null&&filekey.length>0&&file.length>0&& filekey.length==file.length)
        {
            for(int i=0;i<key.length;i++)
            {
                try {
                    File img = new File(file[i]);
                    params.put(filekey[i],img);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return params;

    }

}

