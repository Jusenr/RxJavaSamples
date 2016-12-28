package com.myself.rxjavasamsples.TestCase.mvptest.view;

import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.DiscoveryResource;
import com.myself.rxjavasamsples.library.model.mvp.base.IView;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/14 17:13.
 */
public interface WonderfulView extends IView {

    void showResource(DiscoveryResource data);

    void showLoadingView();

    void hideLoadingView();
}
