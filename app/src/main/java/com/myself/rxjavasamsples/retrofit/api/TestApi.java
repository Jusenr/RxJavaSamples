package com.myself.rxjavasamsples.retrofit.api;


import com.myself.rxjavasamsples.TestCase.rxjava.model.GankBeautyResult;
import com.myself.rxjavasamsples.retrofit.RetrofitAwfulList;
import com.myself.rxjavasamsples.retrofit.RetrofitBean;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Description: 葡萄钱包接口
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/7/4 10:34
 */
public interface TestApi {

    /**
     * 福利
     */
    @GET(BaseApi.Url.URL_WELFARE)
    Observable<GankBeautyResult> getBeauties(@Path("number") int number, @Path("page") int page);

    /**
     * 充值
     */
    @FormUrlEncoded
    @POST(BaseApi.Url.URL_RESOURCES)
    Call<RetrofitBean<JSONObject>> recharge(@FieldMap Map<String, String> map);

    /**
     * 金额列表
     */
    @FormUrlEncoded
    @POST(BaseApi.Url.URL_RESOURCES)
    Call<RetrofitAwfulList<List<String>>> getAmountList(@FieldMap Map<String, String> map);
}