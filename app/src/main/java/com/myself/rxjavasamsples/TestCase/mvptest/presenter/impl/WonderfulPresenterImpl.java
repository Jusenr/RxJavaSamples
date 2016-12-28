package com.myself.rxjavasamsples.TestCase.mvptest.presenter.impl;

import android.util.Log;

import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.DiscoveryResource;
import com.myself.rxjavasamsples.TestCase.mvptest.model.interactor.WonderfulInteractor;
import com.myself.rxjavasamsples.TestCase.mvptest.model.interactor.impl.WonderfulInteractorImpl;
import com.myself.rxjavasamsples.TestCase.mvptest.presenter.WonderfulPresenter;
import com.myself.rxjavasamsples.TestCase.mvptest.view.WonderfulView;
import com.myself.rxjavasamsples.library.base.BasePresenterImpl;
import com.myself.rxjavasamsples.library.base.SimpleBaseCallback;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/14 17:32.
 */
public class WonderfulPresenterImpl extends BasePresenterImpl<WonderfulView, WonderfulInteractor> implements WonderfulPresenter {


    public WonderfulPresenterImpl(WonderfulView view) {
        super(view);
    }

    @Override
    protected WonderfulInteractor createInteractor() {
        return new WonderfulInteractorImpl();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void getResource() {
        mView.showLoadingView();
        mInteractor.getResource(new SimpleBaseCallback<DiscoveryResource>() {
            @Override
            public void refreshData(DiscoveryResource data) {
                super.refreshData(data);
                mView.showResource(data);
                mView.hideLoadingView();

                Log.e("#####", "DiscoveryResource=: " + data);
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
