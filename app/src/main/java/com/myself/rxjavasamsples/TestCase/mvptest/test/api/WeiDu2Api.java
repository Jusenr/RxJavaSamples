package com.myself.rxjavasamsples.TestCase.mvptest.test.api;


import com.myself.rxjavasamsples.retrofit.rx.ReturnTypeData;
import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.ResourceBanner;
import com.myself.rxjavasamsples.retrofit.api.BaseApi;

import java.util.List;
import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/7/4 10:34
 */
public interface WeiDu2Api {
    /**
     * 轮播图列表
     */
    @FormUrlEncoded
    @POST(BaseApi.Url.URL_BANNER)
    Observable<ReturnTypeData<List<ResourceBanner>>> getBannerList(@FieldMap Map<String, String> map);

}