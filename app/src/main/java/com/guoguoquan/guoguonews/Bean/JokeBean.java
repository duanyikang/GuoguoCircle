package com.guoguoquan.guoguonews.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author 小段果果
 * @time 2016/5/18  11:44
 * @E-mail duanyikang@mumayi.com
 */

public class JokeBean implements Parcelable {
    private int id;
    private int xhid;
    private String author;
    private String content;
    private String picurl;
    private String status;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setXhid(int xhid) {
        this.xhid = xhid;
    }

    public int getXhid() {
        return xhid;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.xhid);
        dest.writeString(this.author);
        dest.writeString(this.content);
        dest.writeString(this.picurl);
        dest.writeString(this.status);
    }

    public JokeBean() {
    }

    protected JokeBean(Parcel in) {
        this.id = in.readInt();
        this.xhid = in.readInt();
        this.author = in.readString();
        this.content = in.readString();
        this.picurl = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<JokeBean> CREATOR = new Parcelable.Creator<JokeBean>() {
        @Override
        public JokeBean createFromParcel(Parcel source) {
            return new JokeBean(source);
        }

        @Override
        public JokeBean[] newArray(int size) {
            return new JokeBean[size];
        }
    };
}

