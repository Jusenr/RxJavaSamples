package com.myself.rxjavasamsples.TestCase.mvptest.model.interactor;

import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.ResourceBanner;
import com.myself.rxjavasamsples.library.base.BaseCallback;
import com.myself.rxjavasamsples.library.model.mvp.base.IInteractor;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/14 17:27.
 */
public interface BannerInteractor extends IInteractor {

    void getResourceBanner(BaseCallback<List<ResourceBanner>> callback);
}
