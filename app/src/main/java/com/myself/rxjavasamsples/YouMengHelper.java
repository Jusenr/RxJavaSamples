package com.myself.rxjavasamsples;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

/**
 * Description: 友盟Api 定义所有友盟统计 相关页面、统计事件名称
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/19 14:26.
 */
public class YouMengHelper {
    /**
     * 点击注册、找回密码按钮次数
     */
    public static final String Login_action = "Login_action";


    /**
     * 记录打点数据
     */
    public static void onEvent(Context context, String name, String tag) {
        MobclickAgent.onEvent(context, name, tag);
    }

    /**
     * 记录打点数据
     */
    public static void onEvent(Context context, String name) {
        MobclickAgent.onEvent(context, name);
    }

}
