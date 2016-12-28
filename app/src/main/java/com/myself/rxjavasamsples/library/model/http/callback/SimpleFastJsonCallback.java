package com.myself.rxjavasamsples.library.model.http.callback;


import com.myself.rxjavasamsples.BasicApplication;
import com.myself.rxjavasamsples.library.utils.Logger;
import com.myself.rxjavasamsples.library.utils.StringUtils;
import com.myself.rxjavasamsples.library.utils.ToastUtils;
import com.myself.rxjavasamsples.library.view.LoadingHUD;

import java.io.Serializable;

/**
 * 简单封装FastJsonCallback
 * Created by guchenkai on 2015/11/17.
 */
public abstract class SimpleFastJsonCallback<T extends Serializable> extends FastJsonCallback<T> {
    private LoadingHUD loading;

    public SimpleFastJsonCallback(Class<? extends Serializable> clazz, LoadingHUD loading) {
        super(clazz);
        this.loading = loading;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onCacheSuccess(String url, T result) {

    }

    @Override
    public void onFailure(String url, int statusCode, String msg) {
        Logger.e("请求错误:url=" + url + ",statusCode=" + statusCode + ",错误信息=" + msg);
        if (!StringUtils.isEmpty(msg) && statusCode != -200)
            ToastUtils.showToastLong(BasicApplication.getInstance(), msg);
        if (loading != null) loading.dismiss();
    }

    @Override
    public void onFinish(String url, boolean isSuccess, String msg) {
        if (!isSuccess)
            Logger.w("服务器消息:" + msg);
        if (loading != null) loading.dismiss();
    }
}
