package com.myself.rxjavasamsples.retrofit;

import android.support.annotation.NonNull;

import com.myself.rxjavasamsples.library.utils.Logger;

import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by riven_chris on 16/7/7.
 */
public class HttpHelper {

    private static HttpHelper instance = null;
    private ConcurrentHashMap<String, Call> callMap;
    private ConcurrentHashMap<String, Observable> ObservableMap;

    public static HttpHelper getInstance() {
        if (instance == null) {
            synchronized (HttpHelper.class) {
                if (instance == null) {
                    instance = new HttpHelper();
                }
            }
        }
        return instance;
    }

    private void putCall(Call call) {
        if (callMap == null) {
            callMap = new ConcurrentHashMap<>();
        }
        callMap.put(call.toString(), call);
    }

    private void removeCall(Call call) {
        if (callMap != null) {
            callMap.remove(call.toString());
        }
    }

    private void putObservable(Observable observer) {
        if (ObservableMap == null) {
            ObservableMap = new ConcurrentHashMap<>();
        }
        ObservableMap.put(observer.toString(), observer);
    }

    private void removeObservable(Observable observer) {
        if (ObservableMap != null) {
            ObservableMap.remove(observer.toString());
        }
    }

    public void clearCalls() {
        if (callMap != null)
            for (String key : callMap.keySet()) {
                callMap.get(key).cancel();
                callMap.remove(key);
            }
    }

    public <T> void newCall(Call call, @NonNull final ApiCallback<T> callback) {
        putCall(call);
        call.enqueue(new Callback<RetrofitBean<T>>() {
            @Override
            public void onResponse(Call<RetrofitBean<T>> call, Response<RetrofitBean<T>> response) {
                removeCall(call);
                int code = response.code();
                RetrofitBean<T> bean = response.body();
                boolean success = false;
                if (bean != null)
                    success = bean.getHttp_code() == 200 || bean.getHttp_status_code() == 200
                            || (bean.getHttp_code() == 0 && bean.getHttp_status_code() == 0 && code == 200);
                if (success) {
                    if (bean != null) {
                        T data = bean.getData();
                        if (data != null) {
                            callback.onSuccess(false, data);
                        } else {
                            callback.onSuccessEmpty();
                        }
                    } else {
                        callback.onSuccessEmpty();
                    }
                } else {
                    callback.onFailed(code, bean != null ? bean.getMsg() : "");
                }
                callback.onCompleted(success, bean != null ? bean.getMsg() : "");
            }

            @Override
            public void onFailure(Call<RetrofitBean<T>> call, Throwable t) {
                removeCall(call);
                try {
                    callback.onFailed(-1, "");
                    callback.onCompleted(false, t.getMessage());
                    Logger.d(call.request().url().toString() + ", " + t.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public <T> void newObservable(final Observable observer,@NonNull final ApiCallback<T> callback) {
        putObservable(observer);
        observer.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RetrofitBean<T>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        removeObservable(observer);
                        callback.onFailed(-1, "");
                        callback.onCompleted(false, e.getMessage());
                    }

                    @Override
                    public void onNext(RetrofitBean<T> bean) {
                        int code = bean.hashCode();
                        boolean success = false;
                        if (bean != null)
                            success = bean.getHttp_code() == 200 || bean.getHttp_status_code() == 200
                                    || (bean.getHttp_code() == 0 && bean.getHttp_status_code() == 0 && code == 200);
                        if (success) {
                            if (bean != null) {
                                T data = bean.getData();
                                if (data != null) {
                                    callback.onSuccess(false, data);
                                } else {
                                    callback.onSuccessEmpty();
                                }
                            } else {
                                callback.onSuccessEmpty();
                            }
                        } else {
                            callback.onFailed(code, bean != null ? bean.getMsg() : "");
                        }
                        callback.onCompleted(success, bean != null ? bean.getMsg() : "");
                    }
                });
    }

    public <T> void newCallForAwfulList(Call call, @NonNull final ApiCallback<T> callback) {
        putCall(call);
        call.enqueue(new Callback<RetrofitAwfulList<T>>() {
            @Override
            public void onResponse(Call<RetrofitAwfulList<T>> call, Response<RetrofitAwfulList<T>> response) {
                removeCall(call);
                try {
                    RetrofitAwfulList<T> body = response.body();
                    int error_code = body.getError_code();
                    String msg = body.getMsg();
                    boolean success = error_code == 0;
                    if (success) {
                        T data = body.getList();
                        if (data != null) {
                            callback.onSuccess(false, data);
                        } else {
                            callback.onSuccessEmpty();
                        }
                    } else {
                        callback.onFailed(error_code, msg != null ? msg : "");
                    }
                    callback.onCompleted(success, msg != null ? msg : "");
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onFailed(-1, "");
                    callback.onCompleted(false, e.getMessage());
                    Logger.d(call.request().url().toString() + ", " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<RetrofitAwfulList<T>> call, Throwable t) {
                removeCall(call);
                try {
                    callback.onFailed(-1, "");
                    callback.onCompleted(false, t.getMessage());
                    Logger.d(call.request().url().toString() + ", " + t.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public <T extends RetrofitAwfulBean> void newCallForAwfulBean(Call call, @NonNull final ApiCallback<T> callback) {
        putCall(call);
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                removeCall(call);
                try {
                    T body = response.body();
                    int errorCode = body.getError_code();
                    String msg = body.getMsg();
                    boolean success = errorCode == 0;
                    if (success) {
                        callback.onSuccess(false, body);
                    } else {
                        callback.onFailed(errorCode, msg != null ? msg : "");
                    }
                    callback.onCompleted(success, msg != null ? msg : "");
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onFailed(-1, "");
                    callback.onCompleted(false, e.getMessage());
                    Logger.d(call.request().url().toString() + ", " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                removeCall(call);
                try {
                    callback.onFailed(-1, "");
                    callback.onCompleted(false, t.getMessage());
                    Logger.d(call.request().url().toString() + ", " + t.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
