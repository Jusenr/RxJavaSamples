package com.myself.rxjavasamsples.TestCase.progressbar.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.library.base.PTWDActivity;
import com.myself.rxjavasamsples.library.utils.Logger;

import butterknife.Bind;

public class ShowWEBActivity extends PTWDActivity {
    public static final String TAG = ShowWEBActivity.class.getSimpleName();

    @Bind(R.id.progressBar)
    ProgressWebView mProgressWebView;
    @Bind(R.id.pb_progress)
    ProgressBar pb_progress;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_web;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();
        init();
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }

    private void init() {
        mProgressWebView.getSettings().setJavaScriptEnabled(true);

        mProgressWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        mProgressWebView.setWebChromeClient(new WebChromeClient() {
            // 处理progress
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.d(TAG, "newProgress" + newProgress);
                if (newProgress >= 100) {
                    pb_progress.setVisibility(View.GONE);
                } else {
                    if (pb_progress.getVisibility() == View.GONE)
                        pb_progress.setVisibility(View.VISIBLE);
                    pb_progress.setProgress(newProgress + 30);
                }
//            setScrollBarStyle(SCROLLBARS_INSIDE_OVERLAY);
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
        });


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String url = bundle.getString("url");
        if (url != null) {
            mProgressWebView.loadUrl(url);
        }
    }

    /**
     * 下载文件时使用
     */
    private void download() {
        mProgressWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                if (url != null && url.startsWith("http://"))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
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
}
