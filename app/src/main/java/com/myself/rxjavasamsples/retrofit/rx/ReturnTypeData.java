// (c)2016 Flipboard Inc, All Rights Reserved.

package com.myself.rxjavasamsples.retrofit.rx;

import com.google.gson.annotations.SerializedName;

public class ReturnTypeData<T> {
//    {
//        "data": [
//        ......
//        ],
//        "http_code": 200,
//            "msg": ""
//    }

    public int http_code;
    public String msg;
    public
    @SerializedName("data")
    T data;
}
