package com.myself.rxjavasamsples.TestCase.mvptest.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/8.
 */
public class Resources implements Serializable {
    private String id;//文章id
    private String title;//标题
    private String icon;//文章icon
    private String tag;//所属标签
    private String sid;//所属服务号/订阅号
    private String link_url;//跳转链接


    private String mainTle ;//（自定义）增加的字段用于比较    标签

    public String getMainTle() {
        return mainTle;
    }

    public void setMainTle(String mainTle) {
        this.mainTle = mainTle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }
}
