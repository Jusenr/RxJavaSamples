// (c)2016 Flipboard Inc, All Rights Reserved.

package com.myself.rxjavasamsples.TestCase.rxjava.network;

import com.myself.rxjavasamsples.TestCase.rxjava.network.api.ChildInfoApi;
import com.myself.rxjavasamsples.TestCase.rxjava.network.api.FakeApi;
import com.myself.rxjavasamsples.TestCase.rxjava.network.api.GankApi;
import com.myself.rxjavasamsples.TestCase.rxjava.network.api.ZhuangbiApi;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static ZhuangbiApi zhuangbiApi;
    private static GankApi gankApi;
    private static FakeApi fakeApi;
    private static ChildInfoApi childInfoApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static ZhuangbiApi getZhuangbiApi() {
        if (zhuangbiApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://zhuangbi.info/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            zhuangbiApi = retrofit.create(ZhuangbiApi.class);
        }
        return zhuangbiApi;
    }

    public static GankApi getGankApi() {
        if (gankApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://gank.io/api/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            gankApi = retrofit.create(GankApi.class);
        }
        return gankApi;
    }

    public static ChildInfoApi getChildInfoApi() {
        if (childInfoApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://10.1.11.31:9083/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            childInfoApi = retrofit.create(ChildInfoApi.class);
        }
        return childInfoApi;
    }

    public static FakeApi getFakeApi() {
        if (fakeApi == null) {
            fakeApi = new FakeApi();
        }
        return fakeApi;
    }
}
