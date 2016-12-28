package com.myself.rxjavasamsples.TestCase.navigationbar.model;

import java.io.Serializable;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/10/21 16:25.
 */

public class ChildAbility implements Serializable {
    /**
     * id : 1
     * ability : 抗挫力
     * icon :
     * ability_sum : 5
     * introduction : 能力介绍
     */

    private String id;
    private String ability;
    private String icon;
    private int ability_sum;
    private int noticeCount;
    private String introduction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getAbility_sum() {
        return ability_sum;
    }

    public void setAbility_sum(int ability_sum) {
        this.ability_sum = ability_sum;
    }

    public int getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(int noticeCount) {
        this.noticeCount = noticeCount;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
