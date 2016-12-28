package com.myself.rxjavasamsples.TestCase.mvptest.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/5/8.
 */
public class ResourceBannerAndTag implements Serializable {
    private List<ResourceBanner> banner;
    private List<ResourceTag> tag;

    public List<ResourceBanner> getBanner() {
        return banner;
    }

    public void setBanner(List<ResourceBanner> banner) {
        this.banner = banner;
    }

    public List<ResourceTag> getTag() {
        return tag;
    }

    public void setTag(List<ResourceTag> tag) {
        this.tag = tag;
    }
}
