package com.myself.rxjavasamsples.TestCase.mvptest.model.interactor.impl;

import android.util.Log;

import com.myself.rxjavasamsples.ParameterConstants;
import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.DiscoveryResource;
import com.myself.rxjavasamsples.TestCase.mvptest.model.interactor.WonderfulInteractor;
import com.myself.rxjavasamsples.library.base.BaseCallback;
import com.myself.rxjavasamsples.library.base.BaseInteractorImpl;
import com.myself.rxjavasamsples.retrofit.ParamsBuilder;
import com.myself.rxjavasamsples.retrofit.RetrofitManager;
import com.myself.rxjavasamsples.retrofit.rx.DataHelper;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/14 17:29.
 */
public class WonderfulInteractorImpl extends BaseInteractorImpl implements WonderfulInteractor {

    @Override
    public void getResource(final BaseCallback<DiscoveryResource> callback) {
        HashMap<String, String> mParams = ParamsBuilder.start()
                .put(ParameterConstants.PARAM_CHILD_UID,"123")
                .build();

        Log.e("#####", "mParams=: " + mParams);

        Observer<DiscoveryResource> observer = new Observer<DiscoveryResource>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                callback.showErrorView();
            }

            @Override
            public void onNext(DiscoveryResource data) {
                callback.refreshData(data);
            }
        };

        subscription = RetrofitManager
                .getWeiDuApi()
                .getResourcesList2(mParams)
                .map(DataHelper.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
