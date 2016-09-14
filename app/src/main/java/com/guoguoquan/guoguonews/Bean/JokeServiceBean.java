package com.guoguoquan.guoguonews.Bean;

import java.util.List;

/**
 * 作者：duanyikang on 2016/9/14 0014 10:29
 * 邮箱：duanyikang@yixia.com
 */
public class JokeServiceBean {
    private String status;
    private String desc;
    private List<JokeBean> detail;

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

    public void setDetail(List<JokeBean> detail) {
        this.detail = detail;
    }

    public List<JokeBean> getDetail() {
        return detail;
    }
}
