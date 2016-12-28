package com.myself.rxjavasamsples.TestCase.mvptest.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/8.
 */
public class ResourceTag implements Serializable{
    private String id;
    private String tag_name;
    private String tag_icon;
    private String display_type;

    public String getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(String display_type) {
        this.display_type = display_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag_icon() {
        return tag_icon;
    }

    public void setTag_icon(String tag_icon) {
        this.tag_icon = tag_icon;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    @Override
    public String toString() {
        return "ResourceTag{" +
                "display_type='" + display_type + '\'' +
                ", id='" + id + '\'' +
                ", tag_name='" + tag_name + '\'' +
                ", tag_icon='" + tag_icon + '\'' +
                '}';
    }
}
