// (c)2016 Flipboard Inc, All Rights Reserved.

package com.myself.rxjavasamsples.TestCase.mvptest.test.api;

import com.myself.rxjavasamsples.BasicApplication;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkApi {
    private static WeiDu2Api weiduiApi;
    private static Gank2Api gankApi;
//    private static OkHttpClient okHttpClient = new OkHttpClient();
        private static OkHttpClient okHttpClient = BasicApplication.getOkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static WeiDu2Api getWeiDu2Api() {
        if (weiduiApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://api-weidu-test.ptdev.cn/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            weiduiApi = retrofit.create(WeiDu2Api.class);
        }
        return weiduiApi;
    }

    public static Gank2Api getGank2Api() {
        if (gankApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://gank.io/api/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            gankApi = retrofit.create(Gank2Api.class);
        }
        return gankApi;
    }
}
