package com.myself.rxjavasamsples.TestCase.mvptest.presenter.impl;

import android.util.Log;

import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.ResourceBanner;
import com.myself.rxjavasamsples.TestCase.mvptest.model.interactor.BannerInteractor;
import com.myself.rxjavasamsples.TestCase.mvptest.model.interactor.impl.BannerInteractorImpl2;
import com.myself.rxjavasamsples.TestCase.mvptest.presenter.BannerPresenter;
import com.myself.rxjavasamsples.TestCase.mvptest.view.BannerView;
import com.myself.rxjavasamsples.library.base.BasePresenterImpl;
import com.myself.rxjavasamsples.library.base.SimpleBaseCallback;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/14 17:32.
 */
public class BannerPresenterImpl2 extends BasePresenterImpl<BannerView, BannerInteractor> implements BannerPresenter {


    public BannerPresenterImpl2(BannerView view) {
        super(view);
    }

    @Override
    protected BannerInteractor createInteractor() {
        return new BannerInteractorImpl2();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void getBannerList() {
        mView.showLoadingView();
        mInteractor.getResourceBanner(new SimpleBaseCallback<List<ResourceBanner>>() {
            @Override
            public void refreshData(List<ResourceBanner> data) {
                super.refreshData(data);
                mView.showBannerList(data);
                mView.hideLoadingView();

                Log.e("#####", "List<ResourceBanner>=: " + data);
            }

            @Override
            public void showErrorView() {
                super.showErrorView();
                mView.hideLoadingView();
            }

            @Override
            public void complete() {
                super.complete();
            }

        });
    }
}
