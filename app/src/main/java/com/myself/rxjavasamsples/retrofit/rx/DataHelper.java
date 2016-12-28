package com.myself.rxjavasamsples.retrofit.rx;

import rx.functions.Func1;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/21 16:37.
 */
public class DataHelper<T> implements Func1<ReturnTypeData, T> {
    private static DataHelper INSTANCE = new DataHelper();

    private DataHelper() {
    }

    public static DataHelper getInstance() {
        return INSTANCE;
    }

    @Override
    public T call(ReturnTypeData returnTypeData) {
        return (T) returnTypeData.data;
    }
}
