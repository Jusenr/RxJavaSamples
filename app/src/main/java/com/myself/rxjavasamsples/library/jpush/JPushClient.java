package com.myself.rxjavasamsples.library.jpush;

import android.content.Context;

import com.myself.rxjavasamsples.retrofit.api.BaseApi;

import cn.jpush.android.api.JPushInterface;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/29 16:12.
 */

public class JPushClient {

    public static void init(Context context) {
        JPushInterface.init(context);
    }

    public static void resumePush(Context context) {
        JPushInterface.resumePush(context);
    }

    public static void stopPush(Context context) {
        JPushInterface.stopPush(context);
    }

    public static void isPushStopped(Context context) {
        JPushInterface.isPushStopped(context);
    }

    public static void setDebugMode() {
        JPushInterface.setDebugMode(BaseApi.isDebug());
    }

}
