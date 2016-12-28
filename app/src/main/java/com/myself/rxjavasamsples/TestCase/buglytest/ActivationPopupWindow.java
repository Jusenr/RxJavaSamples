package com.myself.rxjavasamsples.TestCase.buglytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.library.controller.BasicPopupWindow;
import com.myself.rxjavasamsples.library.view.image.ImageDraweeView;
import com.tencent.bugly.crashreport.CrashReport;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * Description: 激活弹窗
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/7/8 14:10
 */
public class ActivationPopupWindow extends BasicPopupWindow implements View.OnClickListener {
    public static final String EVENT_ACTIVATION = "event_activation";//激活


    @Bind(R.id.iv_product_icon)
    ImageDraweeView ivProductIcon;
    @Bind(R.id.iv_player)
    ImageView ivPlayer;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_subtitle)
    TextView tvSubTitle;
    @Bind(R.id.iv_details)
    ImageView ivDetails;
    @Bind(R.id.tab_first)
    TextView tabFirst;
    @Bind(R.id.tv_first)
    TextView tvFirst;
    @Bind(R.id.ll_first)
    LinearLayout llFirst;
    @Bind(R.id.iv_first)
    ImageDraweeView ivFirst;
    @Bind(R.id.tv_second)
    TextView tvSecond;
    @Bind(R.id.ll_second)
    LinearLayout llSecond;
    @Bind(R.id.iv_second)
    ImageDraweeView ivSecond;


    private Context mContext;

    public ActivationPopupWindow(Context context) {
        super(context);
        this.mContext = context;

        //设置PopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.mypopwindow_anim_style);

        CrashReport.testJavaCrash();

        initDataFormPop();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.popup_product_activation;
    }

    /**
     * 初始化数据
     */
    private void initDataFormPop() {

        //测试
        ivProductIcon.setImageResource(R.drawable.img_p_dataempty_07);
    }

    /**
     * 响应结果回调
     */
    public void setPaySpec() {

        dismiss();
    }


    @OnClick({R.id.img_close, R.id.iv_details})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_close:
                //退出弹窗
                dismiss();
                break;
            case R.id.iv_details:
                /*立即激活--跳转至激活指南*/
                Bundle bundle = new Bundle();
                bundle.putString("", "");
                Intent intent = new Intent(mContext, BuglyTActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
                dismiss();
                break;
        }
    }
}