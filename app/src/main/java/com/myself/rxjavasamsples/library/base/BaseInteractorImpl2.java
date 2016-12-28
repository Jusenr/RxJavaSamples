package com.myself.rxjavasamsples.library.base;


import rx.Subscription;

/**
 * Created by riven_chris on 16/7/4.
 */
public class BaseInteractorImpl2 {
    protected static Subscription subscription;

    /*RxJava*/
    public void unSubscribe() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

    public void onDestroy() {
        unSubscribe();
    }
}
