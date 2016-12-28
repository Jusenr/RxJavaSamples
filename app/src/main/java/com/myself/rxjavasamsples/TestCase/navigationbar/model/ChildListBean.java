package com.myself.rxjavasamsples.TestCase.navigationbar.model;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/10/20 15:44.
 */

public class ChildListBean implements Serializable {
//    "error_code": 0,
//    "list": []

    private int error_code;
    private List<BindChild> list;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<BindChild> getList() {
        return list;
    }

    public void setList(List<BindChild> list) {
        this.list = list;
    }
}
