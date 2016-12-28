package com.myself.rxjavasamsples.TestCase.mvptest.model.interactor.impl;

import android.util.Log;

import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.ResourceBanner;
import com.myself.rxjavasamsples.TestCase.mvptest.model.interactor.BannerInteractor;
import com.myself.rxjavasamsples.library.base.BaseCallback;
import com.myself.rxjavasamsples.library.base.BaseInteractorImpl;
import com.myself.rxjavasamsples.retrofit.ParamsBuilder;
import com.myself.rxjavasamsples.retrofit.RetrofitManager;
import com.myself.rxjavasamsples.retrofit.rx.DataHelper;

import java.util.HashMap;
import java.util.List;

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
public class BannerInteractorImpl2 extends BaseInteractorImpl implements BannerInteractor {

    @Override
    public void getResourceBanner(final BaseCallback<List<ResourceBanner>> callback) {
        HashMap<String, String> mParams = ParamsBuilder.start().build();

        Log.e("#####", "mParams=: " + mParams);

        Observer<List<ResourceBanner>> observer = new Observer<List<ResourceBanner>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                callback.showErrorView();
            }

            @Override
            public void onNext(List<ResourceBanner> list) {
                callback.refreshData(list);
            }
        };

        subscription = RetrofitManager
                .getWeiDuApi()
                .getBannerList2(mParams)
                .map(DataHelper.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
