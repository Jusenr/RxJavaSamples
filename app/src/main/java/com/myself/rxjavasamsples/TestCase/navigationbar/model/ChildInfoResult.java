package com.myself.rxjavasamsples.TestCase.navigationbar.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/6 15:54.
 */
public class ChildInfoResult {
    public int error_code;
    public
    @SerializedName("list")
    List<ChildInfoBean> mChildInfos;

}
