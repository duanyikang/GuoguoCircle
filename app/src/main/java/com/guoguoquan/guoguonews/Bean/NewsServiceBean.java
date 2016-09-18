package com.guoguoquan.guoguonews.Bean;

import java.util.List;

/**
 * ×÷Õß£ºduanyikang on 2016/9/18 0018 09:48
 * ÓÊÏä£ºduanyikang@yixia.com
 */
public class NewsServiceBean {
    private String status;
    private String desc;
    private List<NewsBean> detail;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDetail(List<NewsBean> detail) {
        this.detail = detail;
    }

    public List<NewsBean> getDetail() {
        return detail;
    }

}
