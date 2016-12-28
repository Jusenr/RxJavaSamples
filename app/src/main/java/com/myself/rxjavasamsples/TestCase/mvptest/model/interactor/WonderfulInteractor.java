package com.myself.rxjavasamsples.TestCase.mvptest.model.interactor;

import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.DiscoveryResource;
import com.myself.rxjavasamsples.library.base.BaseCallback;
import com.myself.rxjavasamsples.library.model.mvp.base.IInteractor;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/14 17:27.
 */
public interface WonderfulInteractor extends IInteractor {

    void getResource(BaseCallback<DiscoveryResource> callback);
}
