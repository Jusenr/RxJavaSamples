package com.myself.rxjavasamsples.TestCase.progressbar.view;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.library.utils.Logger;

import java.net.URLDecoder;

/**
 * Description: 带进度条的Webivew
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/9 9:46.
 */
public class ProgressWebView extends WebView {
    public static final String TAG = ProgressWebView.class.getSimpleName();

    private Context mContext;
    private ProgressBar progressBar;


    public ProgressWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ProgressWebView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ProgressWebView(Context context) {
        this(context, null);
        this.mContext = context;

        progressBar = new ProgressBar(mContext, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 10, 0, 0));
        progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_states));
        addView(progressBar);

        initView();
    }


    private boolean isLoaderFinish = false;
    private OnWebViewLoadUrlCallback mOnWebViewLoadUrlCallback;

    /**
     * 加载完成回调
     */
    public void setOnWebViewLoadUrlCallback(OnWebViewLoadUrlCallback onWebViewLoadUrlCallback) {
        mOnWebViewLoadUrlCallback = onWebViewLoadUrlCallback;
    }

    /**
     * 设置WebSettings
     */
    private void setWebSettings() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);//开启对JavaScript的支持
        settings.setDefaultTextEncodingName("UTF-8");//设置字符编码
        settings.setSupportZoom(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);

        //缓存
        getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
        String appCachePath = mContext.getCacheDir().getAbsolutePath();
        getSettings().setAppCachePath(appCachePath);

        setWebViewClient(new WebViewClient());
        setWebChromeClient(new WebChromeClient());
    }

    /**
     * 初始化WebView
     */
    private void initView() {
        setWebSettings();

        setWebChromeClient(new WebChromeClient());

        setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String protocolHeader = getProtocolHeader(url);
                switch (protocolHeader) {
                    case ProtocolHeader.PROTOCOL_HEADER_HTTP:
                        view.loadUrl(url);
                        break;
                    case ProtocolHeader.PROTOCOL_HEADER_HTTPS:
                        view.loadUrl(url);
                        break;
                    case ProtocolHeader.PROTOCOL_HEADER_PUTAO:
                        String scheme = getScheme(url);
                        // Logger.d(scheme);
                        String content = getContentUrl(url);
                        if (mOnWebViewLoadUrlCallback != null) {
                            mOnWebViewLoadUrlCallback.onParsePutaoUrl(scheme, JSON.parseObject(content));
                            return true;
                        }
                        break;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (mOnWebViewLoadUrlCallback != null && isLoaderFinish)
                    mOnWebViewLoadUrlCallback.onWebPageLoaderFinish(url);
                isLoaderFinish = true;
            }
        });
    }

    public class WebChromeClient extends android.webkit.WebChromeClient {
        // 处理progress
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                progressBar.setVisibility(GONE);
            } else {
                if (progressBar.getVisibility() == GONE)
                    progressBar.setVisibility(VISIBLE);
                progressBar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }

        // 处理javascript中的console.log
        @Override
        public boolean onConsoleMessage(ConsoleMessage cm) {
            Logger.d(TAG, "webview console " + cm.lineNumber() + " of " + cm.sourceId() + " : " + cm.message());
            return true;
        }

        // 处理javascript中的alert()
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            showAlert(view, url, message, result);
            return true;
        }
    }

    /**
     * 弹窗提示
     *
     * @param view
     * @param url
     * @param message
     * @param result
     */
    private void showAlert(WebView view, String url, String message, final JsResult result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
                .setTitle("")
                .setMessage(message)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                        dialog.dismiss();
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        result.cancel();
                    }
                });
        builder.show();
    }

    /**
     * 获得协议头
     *
     * @param url url
     * @return 协议头
     */
    private String getProtocolHeader(String url) {
        return url.substring(0, url.indexOf(":"));
    }


    /**
     * 获得Scheme
     *
     * @param url url
     * @return Scheme
     */
    private String getScheme(String url) {
        return url.substring(url.indexOf(":") + 3, url.indexOf("{") - 1);
    }

    /**
     * 获得真实url内容
     *
     * @param url url
     * @return 真实url内容
     */
    public String getContentUrl(String url) {
        return URLDecoder.decode(url.substring(url.indexOf("{"), url.length()));
    }

    /**
     * WebView加载URL回调
     */
    public interface OnWebViewLoadUrlCallback {

        void onParsePutaoUrl(String scheme, JSONObject result);

        void onWebPageLoaderFinish(String url);
    }

    /**
     * 协议头定义
     */
    public static final class ProtocolHeader {
        public static final String PROTOCOL_HEADER_HTTP = "http";
        public static final String PROTOCOL_HEADER_HTTPS = "https";
        public static final String PROTOCOL_HEADER_PUTAO = "putao";
    }
}

