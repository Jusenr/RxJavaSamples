package com.myself.rxjavasamsples.TestCase.rxjava.network.api;

import com.myself.rxjavasamsples.TestCase.rxjava.model.GankBeautyResult;

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
 * Date       : 2016/9/6 11:22.
 */
public interface ChildInfoApi {
    @FormUrlEncoded
    @POST("api/bind_list")
    Observable<GankBeautyResult> getChildInfo(@FieldMap Map<String, String> map);
//    mParams = new HashMap<>();
}
