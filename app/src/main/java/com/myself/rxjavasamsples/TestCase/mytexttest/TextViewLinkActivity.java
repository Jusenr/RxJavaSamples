package com.myself.rxjavasamsples.TestCase.mytexttest;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.library.base.PTWDActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class TextViewLinkActivity extends PTWDActivity implements View.OnClickListener {
    public static final String TEXT = "字体测试字体大小一半两倍前景色背景色正常粗体斜体粗斜体下划线删除线x1x2电话邮件网站短信彩信地图X轴综合/bot";
    public static final String tv = "我们渴望像安迪一样成功，却未必能付出像小曲一样的努力；我们希望能过得像小曲一样随性，却常常只能像关关一样拘束；我们想要和关关一样有大家闺秀的气质，却遇事只能像小蚯蚓一样头脑一热不管不顾；我们许愿自己能如同小蚯蚓般单纯直接，却往往都是像樊姐一样思虑过多；我们想要自己学会樊姐的善解人意，却总是更像安迪不善交往。";

    @Bind(R.id.tv_effect_display)
    TextView mTextView;

    private SpannableString sp;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_text_view_link;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }

    private void textviewLink() {
        String mText_1 = "安迪";
        String mText_2 = "小曲";
        String mText_3 = "关关";
        String mText_4 = "小蚯蚓";
        String mText_5 = "樊姐";
        String mText_6 = "大家闺秀";
        String mText_7 = "单纯直接";
        String mText_8 = "不管不顾";
        String mText_9 = "善解人意";
        String mText_10 = "随性";
        String mText_11 = "拘束";
        int mIndex_1 = tv.indexOf(mText_1);
        int mIndex_2 = tv.indexOf(mText_2);
        int mIndex_3 = tv.indexOf(mText_3);
        int mIndex_4 = tv.indexOf(mText_4);
        int mIndex_5 = tv.indexOf(mText_5);
        int mIndex_6 = tv.indexOf(mText_6);
        int mIndex_7 = tv.indexOf(mText_7);
        int mIndex_8 = tv.indexOf(mText_8);
        int mIndex_9 = tv.indexOf(mText_9);
        int mIndex_10 = tv.indexOf(mText_10);
        int mIndex_11 = tv.indexOf(mText_11);
        int tv_length = tv.length();

        //创建一个 SpannableString对象
        sp = new SpannableString(tv);

        /**************************** 设置字体及大小 ************************************/
        /*** 字体 ***/
        //设置字体(default,default-bold,monospace,serif,sans-serif)
        sp.setSpan(new TypefaceSpan("sans-serif"), mIndex_1, mIndex_1 + mText_1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 1 ***/
        //设置字体大小（绝对值,单位：像素）
        sp.setSpan(new AbsoluteSizeSpan(30), mIndex_1, mIndex_1 + mText_1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new AbsoluteSizeSpan(40), mIndex_2, mIndex_2 + mText_2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 2 ***/
        //第二个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素，同上。
        sp.setSpan(new AbsoluteSizeSpan(20, true), mIndex_3, mIndex_3 + mText_3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new AbsoluteSizeSpan(26, true), mIndex_4, mIndex_4 + mText_4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 3 ***/
        //设置字体大小（相对值,单位：像素） 参数表示为默认字体大小的多少倍
        //1.5f表示默认字体大小的1.5倍
        sp.setSpan(new RelativeSizeSpan(1.5f), mIndex_5, mIndex_5 + mText_5.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 字体宽度 ***/
        //设置字体大小（相对值,单位：像素） 参数表示为默认字体宽度的多少倍
        //2.0f表示默认字体宽度的两倍，即X轴方向放大为默认字体的两倍，而高度不变
        sp.setSpan(new ScaleXSpan(2.0f), mIndex_8, mIndex_8 + mText_8.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        /**************************** 设置字体颜色 ************************************/
        /*** 前景色-洋红色 ***/
        sp.setSpan(new ForegroundColorSpan(Color.MAGENTA), mIndex_1, mIndex_1 + mText_1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 背景色-青色 ***/
        sp.setSpan(new BackgroundColorSpan(Color.CYAN), mIndex_2, mIndex_2 + mText_2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        /**************************** 设置字体样式 ************************************/
        /*** 正常 ***/
        sp.setSpan(new StyleSpan(android.graphics.Typeface.NORMAL), mIndex_3, mIndex_3 + mText_3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 粗体 ***/
        sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), mIndex_4, mIndex_4 + mText_4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 斜体 ***/
        sp.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), mIndex_5, mIndex_5 + mText_5.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 粗斜体 ***/
        sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), mIndex_9, mIndex_9 + mText_9.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 下划线 ***/
        sp.setSpan(new UnderlineSpan(), mIndex_8, mIndex_8 + mText_8.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 删除线 ***/
        sp.setSpan(new StrikethroughSpan(), mIndex_7, mIndex_7 + mText_7.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 下标 ***/
        sp.setSpan(new SubscriptSpan(), mIndex_10, mIndex_10 + mText_10.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 上标 ***/
        sp.setSpan(new SuperscriptSpan(), mIndex_11, mIndex_11 + mText_11.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        /**************************** 设置字体超链接 ************************************/
        //超级链接（需要添加setMovementMethod方法附加响应）
        /*** 电话 ***/
        sp.setSpan(new URLSpan("tel:13166325064"), mIndex_1, mIndex_1 + mText_1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 邮件 ***/
        sp.setSpan(new URLSpan("mailto:13166325064@163.com"), mIndex_2, mIndex_2 + mText_2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 网络 ***/
        sp.setSpan(new URLSpan("http://blog.csdn.net/github_35033182/"), mIndex_3, mIndex_3 + mText_3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 短信   使用sms:或者smsto: ***/
        sp.setSpan(new URLSpan("sms:13166325064"), mIndex_4, mIndex_4 + mText_4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 彩信   使用mms:或者mmsto: ***/
        sp.setSpan(new URLSpan("mms:13166325064"), mIndex_5, mIndex_5 + mText_5.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        /*** 地图 ***/
        sp.setSpan(new URLSpan("geo:38.899533,-77.036476"), mIndex_6, mIndex_6 + mText_6.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        /**************************** 设置项目符号 ************************************/
        //第一个参数表示项目符号占用的宽度，第二个参数为项目符号的颜色
        sp.setSpan(new BulletSpan(android.text.style.BulletSpan.STANDARD_GAP_WIDTH, Color.GREEN), 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        /**************************** 设置图片 ************************************/
        //第一个参数表示项目符号占用的宽度，第二个参数为项目符号的颜色
        Drawable drawable = getResources().getDrawable(R.drawable.icon_16_09);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        sp.setSpan(new ImageSpan(drawable), tv_length - 1, tv_length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTextView.setText(sp);
        //设置字体可点击
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void textviewLink(String text) {
        //创建一个 SpannableString对象
        sp = new SpannableString(text);

        //设置字体(default,default-bold,monospace,serif,sans-serif)
        sp.setSpan(new TypefaceSpan("sans-serif"), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new TypefaceSpan("serif"), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体大小（绝对值,单位：像素）
        sp.setSpan(new AbsoluteSizeSpan(20), 4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //第二个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素，同上。
        sp.setSpan(new AbsoluteSizeSpan(20, true), 6, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体大小（相对值,单位：像素） 参数表示为默认字体大小的多少倍
        //0.5f表示默认字体大小的一半
        sp.setSpan(new RelativeSizeSpan(0.5f), 8, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //2.0f表示默认字体大小的两倍
        sp.setSpan(new RelativeSizeSpan(2.0f), 10, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体前景色为洋红色
        sp.setSpan(new ForegroundColorSpan(Color.MAGENTA), 12, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体背景色为青色
        sp.setSpan(new BackgroundColorSpan(Color.CYAN), 15, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体样式正常
        sp.setSpan(new StyleSpan(android.graphics.Typeface.NORMAL), 18, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体样式粗体
        sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 20, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体样式斜体
        sp.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 22, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体样式粗斜体
        sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 24, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置下划线
        sp.setSpan(new UnderlineSpan(), 27, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置删除线
        sp.setSpan(new StrikethroughSpan(), 30, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置上下标
        sp.setSpan(new SubscriptSpan(), 34, 35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new SuperscriptSpan(), 36, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //超级链接（需要添加setMovementMethod方法附加响应）
        //电话
        sp.setSpan(new URLSpan("tel:13166325064"), 37, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //邮件
        sp.setSpan(new URLSpan("mailto:13166325064@163.com"), 39, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //网络
        sp.setSpan(new URLSpan("http://blog.csdn.net/github_35033182/"), 41, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //短信   使用sms:或者smsto:
        sp.setSpan(new URLSpan("sms:13166325064"), 43, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //彩信   使用mms:或者mmsto:
        sp.setSpan(new URLSpan("mms:13166325064"), 45, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //地图
        sp.setSpan(new URLSpan("geo:38.899533,-77.036476"), 47, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体大小（相对值,单位：像素） 参数表示为默认字体宽度的多少倍
        //2.0f表示默认字体宽度的两倍，即X轴方向放大为默认字体的两倍，而高度不变
        sp.setSpan(new ScaleXSpan(2.0f), 49, 51, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置项目符号
        //第一个参数表示项目符号占用的宽度，第二个参数为项目符号的颜色
        sp.setSpan(new BulletSpan(android.text.style.BulletSpan.STANDARD_GAP_WIDTH, Color.GREEN), 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置图片
        Drawable drawable = getResources().getDrawable(R.drawable.icon_16_05);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        sp.setSpan(new ImageSpan(drawable), 53, 57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTextView.setText(sp);

        //设置字体可点击
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @OnClick({R.id.btn_1, R.id.btn_2,})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                textviewLink(TEXT);
                break;
            case R.id.btn_2:
                textviewLink();
                break;
        }
    }
}
