package com.myself.rxjavasamsples.TestCase.progressbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.library.base.PTWDActivity;


import butterknife.Bind;

public class WEBViewActivity extends PTWDActivity {

    @Bind(R.id.wv_webview)
    WebView webview;
    @Bind(R.id.progress)
    ProgressBar mProgress;

    private void setWebSettings() {
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);//开启对JavaScript的支持
        settings.setDefaultTextEncodingName("UTF-8");//设置字符编码

        settings.setSupportZoom(true);
        // 开启alert
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 开启按钮按下显示
        settings.setLightTouchEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        webview.requestFocus();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();
        setWebSettings();
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                mProgress.setProgress(progress);
                if (progress == 100) {
                    Log.e("#####", "progress: " + progress);
                    mProgress.setVisibility(View.GONE);
                }
            }
        });
        webview.loadUrl("http://static-store.ptdev.cn/ptwd/pages/artical.html?wd_mid=1559&tp=0&sid=50008");
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }
}
