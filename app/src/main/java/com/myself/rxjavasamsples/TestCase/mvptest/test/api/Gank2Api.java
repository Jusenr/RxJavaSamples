package com.myself.rxjavasamsples.TestCase.mvptest.test.api;


import com.myself.rxjavasamsples.TestCase.rxjava.model.GankBeautyResult;
import com.myself.rxjavasamsples.retrofit.api.BaseApi;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/7/4 10:34
 */
public interface Gank2Api {

    /**
     * 福利
     */
    @GET(BaseApi.Url.URL_WELFARE)
    Observable<GankBeautyResult> getBeauties(@Path("number") int number, @Path("page") int page);

}