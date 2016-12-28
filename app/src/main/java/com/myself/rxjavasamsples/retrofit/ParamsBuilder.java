package com.myself.rxjavasamsples.retrofit;

import java.util.HashMap;

/**
 * Created by Jusenr on 16/9/5.
 */
public class ParamsBuilder {
    public static final String PARAM_KEY_UID = "uid";                   //家长账户的UID
    public static final String PARAM_KEY_PARENT_UID = "parent_uid";     //家长账户的UID
    public static final String PARAM_KEY_APP_ID = "appid";              //平台id
    public static final String PARAM_KEY_TOKEN = "token";               //登录的token
    public static final String PARAM_KEY_DEVICE_ID = "device_id";       //设备id

    public static final String PARAM_KEY_SIGN = "sign";                 //令牌

    public static final String PARAM_KEY_PUSH_TOKEN = "push_token";     //推送时用的token
    public static final String PARAM_KEY_PUSH_APPID = "push_appid";     //推送时用的appid

    private HashMap<String, String> mParams;

    private static final String uid = "60001569";
    private static final String appid = "1109";
    private static final String token = "06706cb0828145509b8bdb86a3646624";
    private static final String device_id = "c3b820b2b8c4d92a";

    private static final String push_token = "";
    private static final String push_appid = "";

    /**
     * 添加固定参数 uid/parent_uid 、appid、token、device_id
     */
    private ParamsBuilder() {
        mParams = new HashMap<>();
        mParams.put(PARAM_KEY_UID, uid);
        mParams.put(PARAM_KEY_TOKEN, token);
        mParams.put(PARAM_KEY_APP_ID, appid);
        mParams.put(PARAM_KEY_DEVICE_ID, device_id);
    }

    /**
     * (由于参数字段不统一，因此需要再次添加相关字段参数)
     *
     * @return
     */
    public static ParamsBuilder start() {
        ParamsBuilder paramsBuilder = new ParamsBuilder();
        paramsBuilder.put(PARAM_KEY_PARENT_UID, uid);
        return paramsBuilder;
    }

    /**
     * 添加固定参数 push_token、push_appid
     * (由于参数字段不统一，因此需要再次添加相关字段参数)
     *
     * @return
     */
    public static ParamsBuilder gpush() {
        ParamsBuilder paramsBuilder = new ParamsBuilder();
        paramsBuilder.put(PARAM_KEY_PARENT_UID, uid);
        paramsBuilder.mParams.put(PARAM_KEY_PUSH_TOKEN, token);
        paramsBuilder.mParams.put(PARAM_KEY_PUSH_APPID, appid);
        return paramsBuilder;
    }


    public ParamsBuilder put(String k, String v) {
        if (v == null) return this;
        mParams.put(k, v);
        return this;
    }

    public ParamsBuilder put(String k, int v) {
        mParams.put(k, String.valueOf(v));
        return this;
    }

    public ParamsBuilder put(String k, long v) {
        mParams.put(k, String.valueOf(v));
        return this;
    }

    public ParamsBuilder mock(boolean mock) {
        if (mock) {
            mParams.clear();
        }
        return this;
    }

    public HashMap<String, String> build() {
        return mParams;
    }

}
