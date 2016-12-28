package com.myself.rxjavasamsples.TestCase.mytexttest;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.widget.TextView;

/**
 * Description: TextView工具类
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/7 16:32.
 */
public class MyTextUtils {

    private static SpannableString sp;
    private static int sIndex_1;
    private static int sIndex_2;
    private static int sIndex_3;


    private static void isEmpty(String allString) {
        if (allString.isEmpty() || "" == allString)
            new Exception("“" + allString + "不能为空！").printStackTrace();
    }

    /**
     * 给字符串设置下划线
     *
     * @param allString 字符串
     * @return
     */
    public static Spanned setUnderline(String allString) {
        isEmpty(allString);
        return Html.fromHtml("<u>" + allString + "</u>");
    }

    /**
     * 给字符串设置下划线
     *
     * @param tv        TextView对象
     * @param allString 字符串
     */
    public static void setUnderline(TextView tv, String allString) {
        isEmpty(allString);
        tv.setText(allString);
        tv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tv.getPaint().setAntiAlias(true);
    }

    /**
     * 给特定文字设置文字高亮
     *
     * @param allString     全部字符串
     * @param targetString  目标字符串
     * @param color         目标字符串的颜色
     * @param targetString2 目标字符串2
     * @param color2        目标字符串2的颜色
     * @param targetString3 目标字符串3
     * @param color3        目标字符串3的颜色
     * @return SpannableString对象
     */

    public static SpannableString setHighlight(String allString, String targetString, int color, String targetString2, int color2, String targetString3, int color3) {
        isEmpty(allString);
        sp = new SpannableString(allString);

        if (null == targetString) {
        } else if (allString.contains(targetString)) {
            sIndex_1 = allString.indexOf(targetString);
            sp.setSpan(new ForegroundColorSpan(color), sIndex_1, sIndex_1 + targetString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            new Exception("“" + allString + "” 不包含 “" + targetString + "”！").printStackTrace();
        }

        if (null == targetString2) {
        } else if (allString.contains(targetString2)) {
            sIndex_2 = allString.indexOf(targetString2);
            sp.setSpan(new ForegroundColorSpan(color2), sIndex_2, sIndex_2 + targetString2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            new Exception("“" + allString + "” 不包含 “" + targetString2 + "”！").printStackTrace();
        }

        if (null == targetString3) {
        } else if (allString.contains(targetString3)) {
            sIndex_3 = allString.indexOf(targetString3);
            sp.setSpan(new ForegroundColorSpan(color3), sIndex_3, sIndex_3 + targetString3.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            new Exception("“" + allString + "” 不包含 “" + targetString3 + "”！").printStackTrace();
        }

        return sp;
    }

    /**
     * 给特定文字设置字体加粗
     *
     * @param allString     全部字符串
     * @param targetString  目标字符串
     * @param targetString2 目标字符串2
     * @param targetString3 目标字符串3
     * @return SpannableString对象
     */
    public static SpannableString setBold(String allString, String targetString, String targetString2, String targetString3) {
        isEmpty(allString);
        sp = new SpannableString(allString);

        if (null == targetString) {
        } else if (allString.contains(targetString)) {
            sIndex_1 = allString.indexOf(targetString);
            sp.setSpan(new StyleSpan(Typeface.BOLD), sIndex_1, sIndex_1 + targetString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            new Exception("“" + allString + "” 不包含 “" + targetString + "”！").printStackTrace();
        }

        if (null == targetString2) {
        } else if (allString.contains(targetString2)) {
            sIndex_1 = allString.indexOf(targetString2);
            sp.setSpan(new StyleSpan(Typeface.BOLD), sIndex_1, sIndex_1 + targetString2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            new Exception("“" + allString + "” 不包含 “" + targetString2 + "”！").printStackTrace();
        }

        if (null == targetString3) {
        } else if (allString.contains(targetString3)) {
            sIndex_1 = allString.indexOf(targetString3);
            sp.setSpan(new StyleSpan(Typeface.BOLD), sIndex_1, sIndex_1 + targetString3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            new Exception("“" + allString + "” 不包含 “" + targetString3 + "”！").printStackTrace();
        }

        return sp;
    }

    /**
     * 给特定文字设置超链接
     *
     * @return
     */
    public static SpannableString setHyperlink(TextView tv, String allString, String targetString) {
        isEmpty(allString);
        sp = new SpannableString(allString);

        if (null == targetString) {
        } else if (allString.contains(targetString)) {
            sIndex_1 = allString.indexOf(targetString);
            sp.setSpan(new URLSpan("http://www.baidu.com"), sIndex_1, sIndex_1 + targetString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //设置TextView可点击
            tv.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            new Exception("“" + allString + "” 不包含 “" + targetString + "”！").printStackTrace();
        }
        return sp;
    }


}
