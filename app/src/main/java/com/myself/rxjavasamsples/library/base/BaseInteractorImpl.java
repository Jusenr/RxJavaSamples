package com.myself.rxjavasamsples.library.base;


import com.myself.rxjavasamsples.retrofit.HttpHelper;

import rx.Subscription;

/**
 * Created by riven_chris on 16/7/4.
 */
public class BaseInteractorImpl {
    protected static Subscription subscription;

    public void unSubscribe() {
        /*RxJava*/
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        /*Call*/
        HttpHelper.getInstance().clearCalls();
    }

    public void onDestroy() {
        unSubscribe();
    }
}
