package com.myself.rxjavasamsples.retrofit;

import com.myself.rxjavasamsples.retrofit.api.TestApi;
import com.myself.rxjavasamsples.retrofit.api.WeiDuApi;

/**
 * Created by riven_chris on 16/7/3.
 */
public class RetrofitManager {
    private static RetrofitManager instance = null;

    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null)
                    instance = new RetrofitManager();
            }
        }
        return instance;
    }

    public static WeiDuApi getWeiDuApi() {
        return RetrofitFactory.getWeiDuRetrofit().create(WeiDuApi.class);
    }

    public static TestApi getTestApi() {
        return RetrofitFactory.getTestRetrofit().create(TestApi.class);
    }
}
