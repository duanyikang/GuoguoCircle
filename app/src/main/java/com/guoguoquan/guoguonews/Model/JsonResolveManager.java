package com.guoguoquan.guoguonews.Model;

import android.util.SparseArray;

import com.guoguoquan.guoguonews.Bean.NewsBean;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author 小段果果
 * @time 2016/5/30  14:34
 * @E-mail duanyikang@mumayi.com
 */

public class JsonResolveManager {
    public static JsonResolveManager mJsonResolveManager = null;

    private JsonResolveManager() {
    }

    public static JsonResolveManager getInstance() {
        if (mJsonResolveManager == null) {
            mJsonResolveManager = new JsonResolveManager();
        }
        return mJsonResolveManager;
    }


    public SparseArray<NewsBean> ResolveHomeList(String json) {
        SparseArray<NewsBean> mDatas = new SparseArray<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            if (jsonObject.getString("status").equals("000000")) {
                JSONArray jsonArray = jsonObject.getJSONArray("detail");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    NewsBean bean = new NewsBean(1, item.getString("id"), "", item.getString("author"), item.getString("content"), item.getString("picUrl"), 99, 100, 1f);
                    mDatas.append(i, bean);
                }

            } else {
                throw  new Exception(json.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return mDatas;
    }

    public SparseArray<NewsBean> ResolveImageList(String json) {
        SparseArray<NewsBean> mDatas = new SparseArray<>();
        try {
            JSONObject jsonObject = new JSONObject(json.toString());
            if (jsonObject.getInt("totalNum") > 0) {
                JSONArray jsonArray = jsonObject.getJSONArray("imgs");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);

                    Float por = ((float) item.getInt("thumbnailWidth")) / ((float) item.getInt("thumbnailHeight"));

                    NewsBean bean = new NewsBean(1, "", "", "小琳琳", "", item.getString("thumbnailUrl"), 99, 100, por);
                    mDatas.append(i, bean);
                }
            } else {
                throw  new Exception(json.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return mDatas;
    }

    public SparseArray<NewsBean> ResolveCircleList(String json)
    {
        SparseArray<NewsBean> mDatas = new SparseArray<>();
        try {
            JSONObject jsonObject = new JSONObject(json.toString());
            if (jsonObject.getString("status").equals("1")) {
                JSONArray jsonArray = jsonObject.getJSONArray("detail");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    NewsBean bean = new NewsBean(1, item.getString("id"), item.getString("avatar"), item.getString("nickname"), item.getString("content"), item.getString("pic"), 99, 100, Float.parseFloat(item.getString("ratio")));
                    mDatas.append(i,bean);
                }
            } else {
                throw  new Exception(json.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
           return null;
        }
        return mDatas;
    }
}

