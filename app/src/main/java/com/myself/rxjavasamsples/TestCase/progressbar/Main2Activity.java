package com.myself.rxjavasamsples.TestCase.progressbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.progressbar.view.LoadingDialog;
import com.myself.rxjavasamsples.TestCase.progressbar.view.LoadingImgDialog;
import com.myself.rxjavasamsples.library.base.PTWDActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class Main2Activity extends PTWDActivity implements View.OnClickListener {

    @Bind(R.id.pb_bar)
    ProgressBar mPb_bar;
    @Bind(R.id.progressBar)
    ProgressBar mPb_bar1;

    LoadingDialog loadingDialog;
    LoadingImgDialog loadingColorDialog;
    LoadingImgDialog loadingColorDialog2;

    private int[] data = new int[100];
    int hasData = 0;
    int status = 0;

    // 创建一个负责更新的进度的Handler
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0x111) {
                mPb_bar.setProgress(status);
                mPb_bar1.setProgress(status);
            }
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();

        // 启动线程来执行任务
        new Thread(new Runnable() {
            public void run() {
                while (status < 100) {
                    status = doWork(); // 获取耗操作的完成百分比
                    handler.sendEmptyMessage(0x111); // 发送消息
                }
            }
        }).start();

        loadingDialog = new LoadingDialog(this);
        loadingColorDialog = new LoadingImgDialog(this, R.drawable.img_loadding);
        loadingColorDialog2 = new LoadingImgDialog(this, R.drawable.img_loading2);
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }

    // 模拟一个耗时任务
    public int doWork() {
        data[hasData++] = (int) (Math.random() * 100);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }

    @OnClick({R.id.bt_loading_dialog, R.id.bt_loading_img_dialog, R.id.bt_loading_img_dialog2, R.id.btn_webview, R.id.btn_webview2})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_loading_dialog:
                loadingDialog.show();
                break;
            case R.id.bt_loading_img_dialog:
                loadingColorDialog.show();
                break;
            case R.id.bt_loading_img_dialog2:
                loadingColorDialog2.show();
                break;
            case R.id.btn_webview:
                startActivity(new Intent(this, WEBViewActivity.class));
                break;
            case R.id.btn_webview2:
                startActivity(new Intent(this, ProgressBarTestActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loadingColorDialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        } else if (loadingColorDialog.isShowing()) {
            loadingColorDialog.dismiss();
        } else if (loadingColorDialog2.isShowing()) {
            loadingColorDialog2.dismiss();
        } else {
            finish();
        }
    }
}
