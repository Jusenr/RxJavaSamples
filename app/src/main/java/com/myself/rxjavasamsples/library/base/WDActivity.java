package com.myself.rxjavasamsples.library.base;


import com.myself.rxjavasamsples.BasicApplication;
import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.navigationbar.WEBNavigationBar;
import com.myself.rxjavasamsples.library.controller.BasicFragmentActivity;
import com.myself.rxjavasamsples.library.utils.ToastUtils;

import butterknife.Bind;

/**
 * 葡萄纬度的基础FragmentActivity
 * Created by guchenkai on 2015/11/25.
 */
public abstract class WDActivity<App extends BasicApplication> extends BasicFragmentActivity<App> implements WEBNavigationBar.WEBActionsListener {
    @Bind(R.id.webNavigation_bar)
    public WEBNavigationBar webNavigation_bar;

    /**
     * 添加标题栏
     */
    protected void addNavigation() {
        webNavigation_bar.setWEBActionListener(this);
    }

    /**
     * 设置主标题文字
     *
     * @param text 标题文字
     */
    protected void setMainTitle(String text) {
        webNavigation_bar.setMainTitle(text);
    }

    /**
     * 设置主标题文字颜色
     *
     * @param color
     */
    protected void setMainTitleColor(int color) {
        webNavigation_bar.setMainTitleColor(color);
    }

    /**
     * 设置左标题文字
     *
     * @param text 标题文字
     */
    protected void setLeftTitle(String text) {
        webNavigation_bar.setLeftTitle(text);
    }

    /**
     * 设置左标题文字颜色
     *
     * @param color 颜色id
     */
    protected void setLeftTitleColor(int color) {
        webNavigation_bar.setLeftTitleColor(color);
    }

    /**
     * 设置左标题文字是否可以点击
     *
     * @param isClick 是否可以点击
     */
    protected void setLeftClickable(boolean isClick) {
        webNavigation_bar.setLeftClickable(isClick);
    }

    /**
     * 设置左标题2文字
     *
     * @param text 标题文字2
     */
    protected void setLeftTitle2(String text) {
        webNavigation_bar.setLeft2Visibility(true);
        webNavigation_bar.setLeftTitle2(text);
    }

    /**
     * 设置左标题2文字颜色
     *
     * @param color 颜色id
     */
    protected void setLeftTitle2Color(int color) {
        webNavigation_bar.setLeftTitle2Color(color);
    }

    /**
     * 设置左标题2文字是否可以点击
     *
     * @param isClick 是否可以点击
     */
    protected void setLeft2Clickable(boolean isClick) {
        webNavigation_bar.setLeft2Clickable(isClick);
    }

    /**
     * 设置左标题2文字是否显示
     *
     * @param visibility 是否显示
     */
    protected void setLeft2Visibility(boolean visibility) {
        webNavigation_bar.setLeft2Visibility(visibility);
    }

    /**
     * 设置右标题文字
     *
     * @param text 标题文字
     */
    protected void setRightTitle(String text) {
        webNavigation_bar.setRightTitle(text);
    }

    /**
     * 设置右标题文字颜色
     *
     * @param color 颜色id
     */
    protected void setRightTitleColor(int color) {
        webNavigation_bar.setRightTitleColor(color);
    }

    /**
     * 设置右标题文字是否可以点击
     *
     * @param isClick 是否可以点击
     */
    protected void setRightClickable(boolean isClick) {
        webNavigation_bar.setRightClickable(isClick);
    }

    /**
     * 设置右标题2文字
     *
     * @param text 标题文字
     */
    protected void setRightTitle2(String text) {
        webNavigation_bar.setRightTitle2(text);
    }

    /**
     * 设置右标题2文字颜色
     *
     * @param color 颜色id
     */
    protected void setRightTitle2Color(int color) {
        webNavigation_bar.setRightTitle2Color(color);
    }

    /**
     * 设置右标题2文字是否可以点击
     *
     * @param isClick 是否可以点击
     */
    protected void setRight2Clickable(boolean isClick) {
        webNavigation_bar.setRight2Clickable(isClick);
    }

    /**
     * 设置右标题icon是否隐藏
     *
     * @param isHide 是否隐藏
     */
    public void hideRightTitleIcon(boolean isHide) {
        webNavigation_bar.hideRightTitleIcon(isHide);
    }

    @Override
    public void onLeftAction() {
        finish();
    }

    @Override
    public void onLeft2Action() {
        ToastUtils.showToastShort(this, "onLeft2Action");
    }

    @Override
    public void onRightAction() {
        hideRightTitleIcon(true);
        ToastUtils.showToastShort(this, "onRightAction");
    }

    @Override
    public void onRight2Action() {
        ToastUtils.showToastShort(this, "onRight2Action");
    }

    @Override
    public void onMainAction() {
        ToastUtils.showToastShort(this, "onMainAction");
    }

    @Override
    public void onMain2Action() {
        ToastUtils.showToastShort(this, "onMain2Action");
    }
}
