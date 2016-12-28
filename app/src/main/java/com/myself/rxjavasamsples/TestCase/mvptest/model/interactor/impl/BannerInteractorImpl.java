package com.myself.rxjavasamsples.TestCase.mvptest.model.interactor.impl;

import android.util.Log;

import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.ResourceBanner;
import com.myself.rxjavasamsples.TestCase.mvptest.model.interactor.BannerInteractor;
import com.myself.rxjavasamsples.library.base.BaseCallback;
import com.myself.rxjavasamsples.library.base.BaseInteractorImpl;
import com.myself.rxjavasamsples.retrofit.ApiCallback;
import com.myself.rxjavasamsples.retrofit.HttpHelper;
import com.myself.rxjavasamsples.retrofit.ParamsBuilder;
import com.myself.rxjavasamsples.retrofit.RetrofitManager;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/14 17:29.
 */
@Deprecated
public class BannerInteractorImpl extends BaseInteractorImpl implements BannerInteractor {

    @Override
    public void getResourceBanner(final BaseCallback<List<ResourceBanner>> callback) {
        HashMap<String, String> mParams = ParamsBuilder.start().build();

//        String sign = StringUtils.generateSign(mParams, "sign"); //令牌
//        mParams.put(ParamsBuilder.PARAM_KEY_SIGN, sign);

        Log.e("#####", "mParams=: " + mParams);

        final Call call = RetrofitManager.getWeiDuApi().getBannerList(mParams);

        HttpHelper.getInstance().newCall(call, new ApiCallback<List<ResourceBanner>>() {
            @Override
            public void onSuccess(boolean intermediate, List<ResourceBanner> response) {
                callback.refreshData(response);
            }

            @Override
            public void onSuccessEmpty() {
                callback.showEmptyView();
            }

            @Override
            public void onFailed(int code, String msg) {
                callback.showErrorView();
            }

            @Override
            public void onCompleted(boolean success, String msg) {
            }
        });
    }
}
