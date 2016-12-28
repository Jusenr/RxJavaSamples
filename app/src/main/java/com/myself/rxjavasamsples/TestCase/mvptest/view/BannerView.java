package com.myself.rxjavasamsples.TestCase.mvptest.view;

import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.ResourceBanner;
import com.myself.rxjavasamsples.library.model.mvp.base.IView;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/14 17:13.
 */
public interface BannerView extends IView {

    void showBannerList(List<ResourceBanner> list);

    void showLoadingView();

    void hideLoadingView();
}
