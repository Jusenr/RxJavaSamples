package com.myself.rxjavasamsples.TestCase.mvptest.test;

import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.ResourceBanner;
import com.myself.rxjavasamsples.retrofit.rx.ReturnTypeData;

import java.util.List;

import rx.functions.Func1;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/20 14:59.
 */
@Deprecated
public class ResultDataHelper implements Func1<ReturnTypeData, List<ResourceBanner>> {
    private static ResultDataHelper INSTANCE = new ResultDataHelper();

    private ResultDataHelper() {
    }

    public static ResultDataHelper getInstance() {
        return INSTANCE;
    }

    @Override
    public List<ResourceBanner> call(ReturnTypeData result) {

        return (List<ResourceBanner>) result.data;
    }
}
