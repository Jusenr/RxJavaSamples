package com.myself.rxjavasamsples;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.myself.rxjavasamsples.TestCase.buglytest.BuglyTActivity;
import com.myself.rxjavasamsples.TestCase.mvptest.test.Banner2Activity;
import com.myself.rxjavasamsples.TestCase.mvptest.ui.activity.Banner3Activity;
import com.myself.rxjavasamsples.TestCase.mvptest.ui.activity.BannerActivity;
import com.myself.rxjavasamsples.TestCase.mytexttest.TVTESTActivity;
import com.myself.rxjavasamsples.TestCase.mytexttest.TextViewLinkActivity;
import com.myself.rxjavasamsples.TestCase.navigationbar.TestActivity;
import com.myself.rxjavasamsples.TestCase.navigationbar.WEBNAVTestActivity;
import com.myself.rxjavasamsples.TestCase.navigationbar.data.Paramets;
import com.myself.rxjavasamsples.TestCase.navigationbar.model.ChildListBean;
import com.myself.rxjavasamsples.TestCase.progressbar.Main2Activity;
import com.myself.rxjavasamsples.TestCase.rxjava.RxActivity;
import com.myself.rxjavasamsples.TestCase.rxjava.RxJavaTestActivity;
import com.myself.rxjavasamsples.TestCase.stickytest.StickyTestActivity;
import com.myself.rxjavasamsples.library.base.PTWDActivity;
import com.myself.rxjavasamsples.library.utils.ToastUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class FunctionActivity extends PTWDActivity implements View.OnClickListener {
    @Bind(R.id.btn_1)
    Button mButton_1;
    @Bind(R.id.btn_2)
    Button mButton_2;
    @Bind(R.id.btn_3)
    Button mButton_3;
    @Bind(R.id.btn_4)
    Button mButton_4;
    @Bind(R.id.btn_5)
    Button mButton_5;
    @Bind(R.id.btn_6)
    Button mButton_6;
    @Bind(R.id.btn_7)
    Button mButton_7;
    @Bind(R.id.btn_8)
    Button mButton_8;
    @Bind(R.id.btn_9)
    Button mButton_9;
    @Bind(R.id.btn_10)
    Button mButton_10;
    @Bind(R.id.btn_11)
    Button mButton_11;
    @Bind(R.id.btn_12)
    Button mButton_12;
    @Bind(R.id.btn_13)
    Button mButton_13;
    @Bind(R.id.btn_14)
    Button mButton_14;
    @Bind(R.id.btn_15)
    Button mButton_15;
    @Bind(R.id.btn_16)
    Button mButton_16;
    @Bind(R.id.btn_17)
    Button mButton_17;
    @Bind(R.id.btn_18)
    Button mButton_18;
    @Bind(R.id.btn_19)
    Button mButton_19;
    @Bind(R.id.btn_20)
    Button mButton_20;

    private ChildListBean mChildListBean;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_function;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();
        initData();
        initView();
    }

    private void initData() {
        Gson gson = new Gson();

        String json_1 = Paramets.json_list_1;
        mChildListBean = gson.fromJson(json_1, ChildListBean.class);

    }

    private void initView() {
        setMainTitle("Demo测试");
        mButton_1.setText("1-进度加载");
        mButton_2.setText("2-标题栏");
        mButton_3.setText("3-字体属性");
        mButton_4.setText("4-字体设置");
        mButton_5.setText("5-Rx简使用");
        mButton_6.setText("6-RxDemo");
        mButton_7.setText("7-轮播图1");
        mButton_8.setText("8-轮播图2");
        mButton_9.setText("9-轮播图3");
        mButton_10.setText("10-Bugly");
        mButton_11.setText("11-粘性头部");
        mButton_12.setText("12-WEB导航栏");
        mButton_13.setText("13");
        mButton_14.setText("14");
        mButton_15.setText("15");
        mButton_16.setText("16");
        mButton_17.setText("17");
        mButton_18.setText("18");
        mButton_19.setText("19");
        mButton_20.setText("20");


    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_10, R.id.btn_11, R.id.btn_12, R.id.btn_13, R.id.btn_14, R.id.btn_15, R.id.btn_16, R.id.btn_17, R.id.btn_18, R.id.btn_19, R.id.btn_20})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                YouMengHelper.onEvent(this, "1-进度加载", "1-进度加载");
                startActivity(new Intent(this, Main2Activity.class));

                break;
            case R.id.btn_2:
                YouMengHelper.onEvent(this, "2-标题栏", "2-标题栏");
                startActivity(new Intent(this, TestActivity.class));

                break;
            case R.id.btn_3:
                YouMengHelper.onEvent(this, "3-字体属性", "3-字体属性");
                startActivity(new Intent(this, TVTESTActivity.class));

                break;
            case R.id.btn_4:
                YouMengHelper.onEvent(this, "4-字体设置", "4-字体设置");
                startActivity(new Intent(this, TextViewLinkActivity.class));

                break;
            case R.id.btn_5:
                YouMengHelper.onEvent(this, "5-Rx简使用", "5-Rx简使用");
                startActivity(new Intent(this, RxJavaTestActivity.class));

                break;
            case R.id.btn_6:
                YouMengHelper.onEvent(this, "6-RxDemo");
                startActivity(new Intent(this, RxActivity.class));

                break;
            case R.id.btn_7:
                YouMengHelper.onEvent(this, "7-轮播图1");
                startActivity(new Intent(this, BannerActivity.class));

                break;
            case R.id.btn_8:
                YouMengHelper.onEvent(this, "8-轮播图2");
                startActivity(new Intent(this, Banner2Activity.class));

                break;
            case R.id.btn_9:
                YouMengHelper.onEvent(this, "9-轮播图3");
                startActivity(new Intent(this, Banner3Activity.class));

                break;
            case R.id.btn_10:
                YouMengHelper.onEvent(this, "10-Bugly测试");
                startActivity(new Intent(this, BuglyTActivity.class));

                break;
            case R.id.btn_11:
                YouMengHelper.onEvent(this, "11-粘性头部测试", "11-粘性头部测试");
                startActivity(new Intent(this, StickyTestActivity.class));

                break;
            case R.id.btn_12:
                YouMengHelper.onEvent(this, "12-WEB导航栏");
                Bundle bundle = new Bundle();
                bundle.putSerializable(BundleConstants.BUNDLE_CHILD_LIST_BEAN, mChildListBean);
                startActivity(WEBNAVTestActivity.class, bundle);
                break;
            case R.id.btn_13:
//                startActivity(new Intent(this, Main2Activity.class));
                ToastUtils.showToastShort(this, "13");
                break;
            case R.id.btn_14:
//                startActivity(new Intent(this, Main2Activity.class));
                ToastUtils.showToastShort(this, "14");
                break;
            case R.id.btn_15:
//                startActivity(new Intent(this, Main2Activity.class));
                ToastUtils.showToastShort(this, "15");
                break;
            case R.id.btn_16:
//                startActivity(new Intent(this, Main2Activity.class));
                ToastUtils.showToastShort(this, "16");
                break;
            case R.id.btn_17:
//                startActivity(new Intent(this, Main2Activity.class));
                ToastUtils.showToastShort(this, "17");
                break;
            case R.id.btn_18:
//                startActivity(new Intent(this, Main2Activity.class));
                ToastUtils.showToastShort(this, "18");
                break;
            case R.id.btn_19:
//                startActivity(new Intent(this, Main2Activity.class));
                ToastUtils.showToastShort(this, "19");
                break;
            case R.id.btn_20:
//                startActivity(new Intent(this, Main2Activity.class));
                ToastUtils.showToastShort(this, "20");
                break;

        }
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }
}
