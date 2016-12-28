package com.myself.rxjavasamsples.TestCase.mvptest.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/8.
 */
public class FindResource implements Serializable{
    private String id;//文章id
    private String title;//标题
    private String icon;//图片
    private String tag;//标签
    private String sid;//服务号 service_id
    private String link_url;//
    private boolean is_recommend;//是否推荐

    private boolean is_top;//是否置顶  ，（自定义，非接口中的参数）
    private boolean is_show_view;//是否显示分割线  ， （自定义，非接口中的参数）

    public boolean is_show_view() {
        return is_show_view;
    }

    public void setIs_show_view(boolean is_show_view) {
        this.is_show_view = is_show_view;
    }

    public boolean is_top() {
        return is_top;
    }

    public void setIs_top(boolean is_top) {
        this.is_top = is_top;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean is_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(boolean is_recommend) {
        this.is_recommend = is_recommend;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "FindResource{" +
                "icon='" + icon + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", sid='" + sid + '\'' +
                ", link_url='" + link_url + '\'' +
                ", is_recommend=" + is_recommend +
                '}';
    }
}
