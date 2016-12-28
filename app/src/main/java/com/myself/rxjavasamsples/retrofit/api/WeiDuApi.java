package com.myself.rxjavasamsples.retrofit.api;


import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.DiscoveryResource;
import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.ResourceBanner;
import com.myself.rxjavasamsples.retrofit.RetrofitBean;
import com.myself.rxjavasamsples.retrofit.rx.ReturnTypeData;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Description: 葡萄-接口
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/7/4 10:34
 */
public interface WeiDuApi {
/***********************************  Call *************************************/
    /**
     * 轮播图列表
     */
    @FormUrlEncoded
    @POST(BaseApi.Url.URL_BANNER)
    Call<RetrofitBean<List<ResourceBanner>>> getBannerList(@FieldMap Map<String, String> map);

    /**
     * 资源列表
     */
    @FormUrlEncoded
    @POST(BaseApi.Url.URL_RESOURCES)
    Call<RetrofitBean<DiscoveryResource>> getResourcesList(@FieldMap Map<String, String> map);

/***********************************  Observable *************************************/
    /**
     * 轮播图列表
     */
    @FormUrlEncoded
    @POST(BaseApi.Url.URL_BANNER)
    Observable<ReturnTypeData<List<ResourceBanner>>> getBannerList2(@FieldMap Map<String, String> map);

    /**
     * 资源列表
     */
    @FormUrlEncoded
    @POST(BaseApi.Url.URL_RESOURCES)
    Observable<ReturnTypeData<DiscoveryResource>> getResourcesList2(@FieldMap Map<String, String> map);
}