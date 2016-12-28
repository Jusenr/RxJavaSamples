package com.myself.rxjavasamsples.TestCase.mvptest.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/5/4.
 */
public class DiscoveryResource implements Serializable {
    private FindResource top;
    private List<FindResource> list;

    public List<FindResource> getList() {
        return list;
    }

    public void setList(List<FindResource> list) {
        this.list = list;
    }

    public FindResource getTop() {
        return top;
    }

    public void setTop(FindResource top) {
        this.top = top;
    }
}
