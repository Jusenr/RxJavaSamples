package com.myself.rxjavasamsples.TestCase.rxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.buglytest.ActivationPopupWindow;
import com.myself.rxjavasamsples.library.base.PTWDActivity;
import com.myself.rxjavasamsples.library.utils.ToastUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class RxJavaTestActivity extends PTWDActivity implements View.OnClickListener {

    @Bind(R.id.ll_main)
    LinearLayout ll_main;
    @Bind(R.id.tv_effect_display)
    TextView mTextView;

    private ActivationPopupWindow popupWindow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rx_java_test;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }

    @OnClick({R.id.btn_1, R.id.btn_2,})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                mTextView.setText("1234");
                ToastUtils.showToastShort(this, "1");
                break;
            case R.id.btn_2:
                mTextView.setText("5678");
                ToastUtils.showToastShort(this, "2");
                break;
        }
    }

    @Override
    public void onRightAction() {
        super.onRightAction();
        if (null == popupWindow) {
            popupWindow = new ActivationPopupWindow(this);
        }
        popupWindow.show(ll_main);
//        PopupWindowUtil.showPopupWindow(popupWindow);
    }
}
