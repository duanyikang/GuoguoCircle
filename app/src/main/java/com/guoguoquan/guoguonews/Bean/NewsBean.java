package com.guoguoquan.guoguonews.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author 小段果果
 * @time 2016/5/18  11:44
 * @E-mail duanyikang@mumayi.com
 */

public class NewsBean implements Parcelable {

    public int type; //当前bean的类型，一共有有4种类型详见Constant.class
    public String bean_id;//bean在数据库中的id
    public String bean_avatar_url;//bean头像地址
    public String bean_name_str;//bean名字
    public String bean_content_str;//bean主体内容
    public String bean_image_url;
    public Float bean_image_pro;


    public Float getBean_image_pro() {
        return bean_image_pro;
    }

    public void setBean_image_pro(Float bean_image_pro) {
        this.bean_image_pro = bean_image_pro;
    }


    public String getBean_image_url() {
        return bean_image_url;
    }

    public void setBean_image_url(String bean_image_url) {
        this.bean_image_url = bean_image_url;
    }

    public int happly;//该bean被点赞次数
    public int unhapply;//该bean被嘲讽次数

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBean_id() {
        return bean_id;
    }

    public void setBean_id(String bean_id) {
        this.bean_id = bean_id;
    }

    public String getBean_avatar_url() {
        return bean_avatar_url;
    }

    public void setBean_avatar_url(String bean_avatar_url) {
        this.bean_avatar_url = bean_avatar_url;
    }

    public String getBean_name_str() {
        return bean_name_str;
    }

    public void setBean_name_str(String bean_name_str) {
        this.bean_name_str = bean_name_str;
    }

    public String getBean_content_str() {
        return bean_content_str;
    }

    public void setBean_content_str(String bean_content_str) {
        this.bean_content_str = bean_content_str;
    }

    public int getHapply() {
        return happly;
    }

    public void setHapply(int happly) {
        this.happly = happly;
    }

    public int getUnhapply() {
        return unhapply;
    }

    public void setUnhapply(int unhapply) {
        this.unhapply = unhapply;
    }

    public NewsBean() {
    }

    public NewsBean(int type, String bean_id, String bean_avatar_url,
                    String bean_name_str, String bean_content_str, String bean_image_url,
                    int happly, int unhapply, Float bean_image_pro) {
        this.type = type;
        this.bean_id = bean_id;
        this.bean_avatar_url = bean_avatar_url;
        this.bean_name_str = bean_name_str;
        this.bean_content_str = bean_content_str;
        this.happly = happly;
        this.unhapply = unhapply;
        this.bean_image_url = bean_image_url;
        this.bean_image_pro = bean_image_pro;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeString(this.bean_id);
        dest.writeString(this.bean_avatar_url);
        dest.writeString(this.bean_name_str);
        dest.writeString(this.bean_content_str);
        dest.writeString(this.bean_image_url);
        dest.writeValue(this.bean_image_pro);
        dest.writeInt(this.happly);
        dest.writeInt(this.unhapply);
    }

    protected NewsBean(Parcel in) {
        this.type = in.readInt();
        this.bean_id = in.readString();
        this.bean_avatar_url = in.readString();
        this.bean_name_str = in.readString();
        this.bean_content_str = in.readString();
        this.bean_image_url = in.readString();
        this.bean_image_pro = (Float) in.readValue(Float.class.getClassLoader());
        this.happly = in.readInt();
        this.unhapply = in.readInt();
    }

    public static final Creator<NewsBean> CREATOR = new Creator<NewsBean>() {
        public NewsBean createFromParcel(Parcel source) {
            return new NewsBean(source);
        }

        public NewsBean[] newArray(int size) {
            return new NewsBean[size];
        }
    };
}

