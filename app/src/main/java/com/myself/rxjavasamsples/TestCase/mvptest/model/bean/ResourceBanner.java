package com.myself.rxjavasamsples.TestCase.mvptest.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/8.
 */
public class ResourceBanner implements Serializable {
    private String id;
    private String banner;
    private String location_type;
    private String location;
    private String banner_title;
    private String icon;
    private String sid;
    private String link_url;

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public String getBanner_title() {
        return banner_title;
    }

    public void setBanner_title(String banner_title) {
        this.banner_title = banner_title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    @Override
    public String toString() {
        return "ResourceBanner{" +
                "banner='" + banner + '\'' +
                ", id='" + id + '\'' +
                ", location_type='" + location_type + '\'' +
                ", location='" + location + '\'' +
                ", banner_title='" + banner_title + '\'' +
                ", icon='" + icon + '\'' +
                ", sid='" + sid + '\'' +
                ", link_url='" + link_url + '\'' +
                '}';
    }
}
