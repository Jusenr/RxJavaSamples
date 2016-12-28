package com.myself.rxjavasamsples.TestCase.progressbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.progressbar.view.ProgressWebView;
import com.myself.rxjavasamsples.TestCase.progressbar.view.ShowWEBActivity;
import com.myself.rxjavasamsples.library.base.PTWDActivity;
import com.myself.rxjavasamsples.library.view.BasicWebView;

import butterknife.Bind;
import butterknife.OnClick;

public class ProgressBarTestActivity extends PTWDActivity implements View.OnClickListener {
    public static final String url = "http://blog.csdn.net/github_35033182/article/details/52133685";
    public static final String url_1 = "http://static-store.ptdev.cn/ptwd/pages/artical.html?wd_mid=1559&tp=0&sid=50008";
    public static final String url_2 = "http://pic24.nipic.com/20121029/5056611_120019351000_2.jpg";

    @Bind(R.id.progressBar)
    ProgressWebView mProgressWebView;
    @Bind(R.id.progressBar_1)
    BasicWebView mWebView;
    @Bind(R.id.progressBar_3)
    WebView progressBar_3;

    @Bind(R.id.pb_progress)
    ProgressBar pb_progress;


    private Intent mIntent;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_progress_bar_test;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();
        init3();
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                init1();

                break;
            case R.id.btn_2:
                init2();

                break;
            case R.id.btn_3:
                init3();

                break;
        }
    }

    protected void init1() {
        mWebView.setVisibility(View.GONE);
        progressBar_3.setVisibility(View.GONE);
        mProgressWebView.setVisibility(View.VISIBLE);

        mIntent = new Intent(this, ShowWEBActivity.class);
        mIntent.putExtra("url", url_1);
        startActivity(mIntent);
    }

    protected void init2() {
        mProgressWebView.setVisibility(View.GONE);
        progressBar_3.setVisibility(View.GONE);
        mWebView.setVisibility(View.VISIBLE);

        mWebView.setWebChromeClient(new WebChromeClient() {
            // 处理progress
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.d("@@@@", "newProgress" + newProgress);
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
        });

        mWebView.loadUrl(url);
    }

    protected void init3() {
        mProgressWebView.setVisibility(View.GONE);
        mWebView.setVisibility(View.GONE);
        progressBar_3.setVisibility(View.VISIBLE);

        progressBar_3.setWebChromeClient(new WebChromeClient() {
            // 处理progress
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.d("@@@@", "newProgress" + newProgress);
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
        });

        progressBar_3.loadUrl(url_2);
    }
}
