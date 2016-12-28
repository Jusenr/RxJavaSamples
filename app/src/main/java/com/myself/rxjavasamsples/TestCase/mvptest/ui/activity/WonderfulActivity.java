package com.myself.rxjavasamsples.TestCase.mvptest.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.DiscoveryResource;
import com.myself.rxjavasamsples.TestCase.mvptest.presenter.WonderfulPresenter;
import com.myself.rxjavasamsples.TestCase.mvptest.presenter.impl.WonderfulPresenterImpl;
import com.myself.rxjavasamsples.TestCase.mvptest.view.WonderfulView;
import com.myself.rxjavasamsples.library.model.mvp.base.PTActivity;

public class WonderfulActivity extends PTActivity<WonderfulPresenter> implements WonderfulView, View.OnClickListener {


    private DiscoveryResource mData;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wonderful;
    }

    @Override
    protected WonderfulPresenter createPresenter() {
        return new WonderfulPresenterImpl(this);
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {

    }

    @Override
    public void showResource(DiscoveryResource data) {
        if (null != data) {
            mData = data;

        }
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void showLoadingView() {
        loading.show();
    }

    @Override
    public void hideLoadingView() {
        loading.hide();
    }
}