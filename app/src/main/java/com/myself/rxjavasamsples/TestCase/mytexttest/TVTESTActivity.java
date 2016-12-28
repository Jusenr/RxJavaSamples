package com.myself.rxjavasamsples.TestCase.mytexttest;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.library.base.PTWDActivity;
import com.myself.rxjavasamsples.library.utils.AppUtils;
import com.myself.rxjavasamsples.library.utils.StringUtils;
import com.myself.rxjavasamsples.library.utils.ToastUtils;
import com.myself.rxjavasamsples.share.OnShareClickListener;
import com.myself.rxjavasamsples.share.SharePopupWindow;
import com.myself.rxjavasamsples.share.ShareTools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.OnClick;

public class TVTESTActivity extends PTWDActivity implements View.OnClickListener {

    public static final String tv = "我们渴望像安迪一样成功，却未必能付出像小曲一样的努力；我们希望能过得像小曲一样随性，却常常只能像关关一样拘束；我们想要和关关一样有大家闺秀的气质，却遇事只能像小蚯蚓一样头脑一热不管不顾；我们许愿自己能如同小蚯蚓般单纯直接，却往往都是像樊姐一样思虑过多；我们想要自己学会樊姐的善解人意，却总是更像安迪不善交往。";
    @Bind(R.id.tv_describe)
    TextView tv_describe;
    @Bind(R.id.tv_effect_display)
    TextView tv_effect_display;
    @Bind(R.id.et_wallet_money)
    EditText et_wallet_money;   //自定义金额
    @Bind(R.id.tv_pt_coin)
    TextView tv_pt_coin;  //自定义葡萄币回显
    @Bind(R.id.btn_wallet_recharge)
    Button btn_wallet_recharge;  //充值

    private String total_fee;//充值金额
    private String putao_coin;//葡萄币

    private SharePopupWindow mSharePopupWindow;//分享弹框
    private String title, subtitle, shareUrl, imageUrl;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tvtest;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        mSharePopupWindow = new SharePopupWindow(mContext);
        addNavigation();
        StringUtils.setEditable(et_wallet_money, 6);

        title="分享";
        subtitle="1324";
        shareUrl="http://sharesdk.cn";
        imageUrl="http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg";

        addListener();

        /**
         * 添加输入框监听
         * */
        et_wallet_money.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0 && count > 0) {
                    String regEx = "^(0(?:[.](?:[1-9]\\d?|0[1-9]))|[1-9]\\d*(?:[.]\\d{1,2}|$))$";
                    Matcher matcher = Pattern.compile(regEx).matcher(s);
                    if (matcher.matches()) {
                        tv_pt_coin.setVisibility(View.VISIBLE);
                        btn_wallet_recharge.setEnabled(true);
                        btn_wallet_recharge.setBackgroundResource(R.drawable.btn_get_focus_sel);
                        putao_coin = s.toString().trim();
                        tv_pt_coin.setText("=" + putao_coin + "葡萄币");
                        tv_effect_display.setText("*" + putao_coin + "*");
                        Log.e("#####", "onTextChanged: " + putao_coin + "葡萄币");
                    }
                } else {
                    tv_pt_coin.setVisibility(View.GONE);
                    btn_wallet_recharge.setEnabled(false);
                    btn_wallet_recharge.setBackgroundResource(R.drawable.btn_los_focus);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("#####", "afterTextChanged: =" + putao_coin + "葡萄币");

                et_wallet_money.setSelection(s.length());
            }
        });
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_10, R.id.btn_11, R.id.btn_12, R.id.btn_13, R.id.btn_14})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                tv_describe.setText("给字符串设置下划线");
                tv_effect_display.setText(MyTextUtils.setUnderline(tv));
                et_wallet_money.setText("1");

                break;
            case R.id.btn_2:
                tv_describe.setText("给特定文字设置超链接");
                tv_effect_display.setText(MyTextUtils.setHyperlink(tv_effect_display, tv, "关关"));
                et_wallet_money.setText("2");

                break;
            case R.id.btn_3:
                tv_describe.setText("setTextColor");
                tv_effect_display.setTextColor(getResources().getColor(R.color.color_007AFF));
                tv_effect_display.setText(tv);
                et_wallet_money.setText("3");

                break;
            case R.id.btn_4:
                tv_describe.setText("setTop");
                tv_effect_display.setTop(Color.parseColor("#49484B"));
                tv_effect_display.setText(tv);
                et_wallet_money.setText("4");

                break;
            case R.id.btn_5:
                tv_describe.setText("");
                tv_effect_display.setText(tv);
                et_wallet_money.setText("5");

                break;
            case R.id.btn_6:
                if (null != mSharePopupWindow)
                mSharePopupWindow.show(btn_wallet_recharge);

                break;
            case R.id.btn_7:
                AppUtils.showShare(this);

                break;
            case R.id.btn_8:
                tv_describe.setText("");
                tv_effect_display.setText("");

                break;

            case R.id.btn_9:
                tv_describe.setText("");
                tv_effect_display.setText("");

                break;
            case R.id.btn_10:
                tv_describe.setText("");
                tv_effect_display.setText("");

                break;
            case R.id.btn_11:
                tv_describe.setText("");
                tv_effect_display.setText("");

                break;
            case R.id.btn_12:
                tv_describe.setText("");
                tv_effect_display.setText("");

                break;
            case R.id.btn_13:
                tv_describe.setText("");
                tv_effect_display.setText("");

                break;
            case R.id.btn_14:
                tv_describe.setText("");
                tv_effect_display.setText("");

                break;
        }
    }

    private void addListener() {
        mSharePopupWindow.setOnShareClickListener(false, new OnShareClickListener() {

            @Override
            public void onWechat() {
                ShareTools.wechatWebShare(TVTESTActivity.this, true, title, subtitle, imageUrl, shareUrl);
            }

            @Override
            public void onWechatFriend() {
                ShareTools.wechatWebShare(TVTESTActivity.this, false, title, subtitle, imageUrl, shareUrl);
            }

            @Override
            public void onQQFriend() {
                ShareTools.OnQQZShare(TVTESTActivity.this, true, title, subtitle, imageUrl, shareUrl);
            }

            @Override
            public void onQQZone() {
                ShareTools.OnQQZShare(TVTESTActivity.this, false, title, subtitle, imageUrl, shareUrl);
            }

            public void onSinaWeibo() {
                ShareTools.OnWeiboShare(TVTESTActivity.this, title, imageUrl, shareUrl);
            }

            @Override
            public void onCopyUrl() {
                ClipboardManager copy = (ClipboardManager) TVTESTActivity.this
                        .getSystemService(Context.CLIPBOARD_SERVICE);
                copy.setText(shareUrl);
                ToastUtils.showToastShort(TVTESTActivity.this, "复制成功");
            }
        }, shareUrl);
    }

}
