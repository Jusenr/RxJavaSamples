package com.myself.rxjavasamsples.retrofit;

import com.myself.rxjavasamsples.BasicApplication;
import com.myself.rxjavasamsples.retrofit.api.BaseApi;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by riven_chris on 16/7/3.
 */
public class RetrofitFactory {
    private static OkHttpClient okHttpClient = BasicApplication.getOkHttpClient();
//    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static Retrofit getWeiDuRetrofit() {
        return WeiDuRetrofitPlaceHolder.RETROFIT;
    }

    public static Retrofit getTestRetrofit() {
        return TestRetrofitPlaceHolder.RETROFIT;
    }

    public static class WeiDuRetrofitPlaceHolder {
        static final Retrofit RETROFIT = new Retrofit.Builder()
                .baseUrl(BaseApi.WEIDU_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    public static class TestRetrofitPlaceHolder {
        static final Retrofit RETROFIT = new Retrofit.Builder()
                .baseUrl(BaseApi.GANK_IO_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }
}
