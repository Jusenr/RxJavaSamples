package com.myself.rxjavasamsples.share;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.library.controller.BasicPopupWindow;
import com.myself.rxjavasamsples.library.utils.Logger;
import com.myself.rxjavasamsples.library.utils.StringUtils;
import com.myself.rxjavasamsples.library.utils.ToastUtils;

import java.util.List;

import butterknife.OnClick;

/**
 * 分享弹出框
 * Created by guchenkai on 2015/11/27.
 */
public class SharePopupWindow extends BasicPopupWindow implements View.OnClickListener {
    private boolean isCopy = true;
    private OnShareClickListener mOnShareClickListener;
    private TextView tv_collection;
    private ImageView iv_collection;
    private String mUrl;
    private String packageName = "";
    private String clazzName = "";
    private List<ResolveInfo> resolveInfoList;
    private boolean isHasBrowser = false;

    public void setOnShareClickListener(OnShareClickListener onShareClickListener, String url) {
        setOnShareClickListener(true, onShareClickListener, url);
    }

    public void setOnShareClickListener(boolean isCopy, OnShareClickListener onShareClickListener, String url) {
        this.isCopy = isCopy;
        this.mUrl = url;
        mOnShareClickListener = onShareClickListener;
        LinearLayout ll_second = (LinearLayout) mRootView.findViewById(R.id.ll_second);
        LinearLayout ll_qq_zone = (LinearLayout) mRootView.findViewById(R.id.ll_qq_zone);
        LinearLayout ll_share = (LinearLayout) mRootView.findViewById(R.id.ll_share);
        TextView tv_qq_zone = (TextView) mRootView.findViewById(R.id.tv_qq_zone);
        ImageView iv_qq_zone = (ImageView) mRootView.findViewById(R.id.iv_qq_zone);
        TextView tv_qq = (TextView) mRootView.findViewById(R.id.tv_qq);
        ImageView iv_qq = (ImageView) mRootView.findViewById(R.id.iv_qq);
        tv_collection = (TextView) mRootView.findViewById(R.id.tv_collection);
        iv_collection = (ImageView) mRootView.findViewById(R.id.iv_collection);
        if (!isCopy) {
            ll_qq_zone.setVisibility(View.GONE);
            ll_share.setVisibility(View.INVISIBLE);
            iv_collection.setImageResource(R.drawable.icon_40_03);
            tv_collection.setText("QQ好友");
            iv_qq.setImageResource(R.drawable.icon_40_04);
            tv_qq.setText("QQ空间");


//            //复制
//            ll_second.setVisibility(View.GONE);
//            //QQ空间
//            tv_qq_zone.setText("新浪微博");
//            iv_qq_zone.setImageResource(R.drawable.icon_40_05);
        } else {
            //复制
//            ll_second.setVisibility(View.VISIBLE);
//            //QQ空间
//            tv_qq_zone.setText("QQ空间");
//            iv_qq_zone.setImageResource(R.drawable.icon_40_04);
            ll_qq_zone.setVisibility(View.VISIBLE);
            ll_share.setVisibility(View.GONE);
            tv_collection.setText("收藏");
            iv_collection.setImageResource(R.drawable.icon_40_13);
            iv_qq.setImageResource(R.drawable.icon_40_03);
            tv_qq.setText("QQ好友");
        }
    }

    public SharePopupWindow(Context context) {
        super(context);
        setAnimationStyle(R.style.bottom_anim_style);
        getBrowsers();
    }

    public void getBrowsers() {
        String default_browser = "android.intent.category.DEFAULT";
        String browsable = "android.intent.category.BROWSABLE";
        String view = "android.intent.action.VIEW";

        Intent intent = new Intent(view);
        intent.addCategory(default_browser);
        intent.addCategory(browsable);
        Uri uri = Uri.parse("http://");
        intent.setDataAndType(uri, null);

        resolveInfoList = mContext.getPackageManager().queryIntentActivities(intent, PackageManager.GET_INTENT_FILTERS);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.popup_share;
    }

    @OnClick({
            R.id.ll_wechat,
            R.id.ll_wechat_friend_circle,
            R.id.ll_collection,
            R.id.ll_qq_friend,
            R.id.ll_qq_zone,
            R.id.ll_sina_weibo,
            R.id.ll_safari,
            R.id.ll_copy_url,
            R.id.tv_cancel
    })
    @Override
    public void onClick(View v) {
        if (mOnShareClickListener != null)
            switch (v.getId()) {
                case R.id.ll_wechat://微信
                    if (!checkShareUrl(R.id.ll_wechat))
                        return;
                    mOnShareClickListener.onWechat();
                    break;
                case R.id.ll_wechat_friend_circle://微信朋友圈
                    if (!checkShareUrl(R.id.ll_wechat_friend_circle))
                        return;
                    mOnShareClickListener.onWechatFriend();
                    break;
                case R.id.ll_collection://收藏
                    if (!checkShareUrl(R.id.ll_collection))
                        return;
                    if (isCopy) {
                        mOnShareClickListener.onCollection();
                    } else {
                        mOnShareClickListener.onQQFriend();
                    }
                    break;
                case R.id.ll_qq_friend://QQ好友
                    if (!checkShareUrl(R.id.ll_qq_friend))
                        return;
                    if (isCopy)
                        mOnShareClickListener.onQQFriend();
                    else
                        mOnShareClickListener.onQQZone();
                    break;
                case R.id.ll_qq_zone://QQ空间
                    if (!checkShareUrl(R.id.ll_qq_zone))
                        return;
                    if (isCopy) {
                        mOnShareClickListener.onQQZone();
                    } else {
                        mOnShareClickListener.onSinaWeibo();
                    }
                    break;
                case R.id.ll_sina_weibo://新浪微博
                    if (!checkShareUrl(R.id.ll_sina_weibo))
                        return;
                    mOnShareClickListener.onSinaWeibo();
                    break;
                case R.id.ll_safari://用本机浏览器打开
                    if (resolveInfoList == null || !(resolveInfoList.size() > 0)) {
                        return;
                    }
                    if (!checkShareUrl(R.id.ll_safari))
                        return;

                    if (!getDefaultBrowser()) {
                        return;
                    }

                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    Uri content_url = Uri.parse(mUrl);
                    intent.setData(content_url);
//                    intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                    intent.setClassName(packageName, clazzName);
                    mContext.startActivity(intent);
                    break;
                case R.id.ll_copy_url://复制链接
                    if (!checkShareUrl(R.id.ll_copy_url))
                        return;
                    mOnShareClickListener.onCopyUrl();
                    break;
            }
        dismiss();
    }

    private boolean getDefaultBrowser() {
        for (ResolveInfo info : resolveInfoList) {
            Logger.d(info.activityInfo.packageName + ":::::" + info.activityInfo.name);
            if (StringUtils.equals(info.activityInfo.packageName, "com.android.browser") && StringUtils.equals(info.activityInfo.name, "com.android.browser.BrowserActivity")) {
                packageName = info.activityInfo.packageName;
                clazzName = info.activityInfo.name;
                return true;
            }
        }

        if (StringUtils.isEmpty(packageName)) {
            for (ResolveInfo info : resolveInfoList) {
                Logger.d(info.activityInfo.packageName + ":::::" + info.activityInfo.name);
                if (StringUtils.equals(info.activityInfo.packageName, "com.UCMobile") && StringUtils.equals(info.activityInfo.name, "com.UCMobile.main.UCMobile")) {
                    packageName = info.activityInfo.packageName;
                    clazzName = info.activityInfo.name;
                    return true;
                }
            }
        }
        if (StringUtils.isEmpty(packageName)) {
            for (ResolveInfo info : resolveInfoList) {
                Logger.d(info.activityInfo.packageName + ":::::" + info.activityInfo.name);
                if (StringUtils.equals(info.activityInfo.packageName, "com.tencent.mtt") && StringUtils.equals(info.activityInfo.name, "com.tencent.mtt.MainActivity")) {
                    packageName = info.activityInfo.packageName;
                    clazzName = info.activityInfo.name;
                    return true;
                }
            }
        }
        if (StringUtils.isEmpty(packageName)) {
            ToastUtils.showToastShort(mContext, "手机尚未安装相关浏览器");
            return false;
        }
        return false;
    }


    private boolean checkShareUrl(int rId) {
        if (StringUtils.isEmpty(mUrl)) {
            if (rId == R.id.ll_collection) {
                if (isCopy)
                    ToastUtils.showToastShort(mContext, "链接错误，收藏失败");
                else
                    ToastUtils.showToastShort(mContext, "链接错误，分享失败");

            } else if (rId == R.id.ll_safari) {
                ToastUtils.showToastShort(mContext, "链接错误，浏览器打开失败");
            } else if (rId == R.id.ll_copy_url) {
                ToastUtils.showToastShort(mContext, "链接错误，复制失败");
            } else {
                ToastUtils.showToastShort(mContext, "链接错误，分享失败");
            }
            return false;
        }
        return true;
    }

    @Override
    public void dismiss() {
        if (mOnShareClickListener != null)
            mOnShareClickListener.onCancel();
        super.dismiss();
    }

    public void setCollectState(boolean isCollect) {
        if (isCollect) {
            tv_collection.setText("取消收藏");
            iv_collection.setImageResource(R.drawable.icon_40_14);

        } else {
            iv_collection.setImageResource(R.drawable.icon_40_13);
            tv_collection.setText("收藏");
        }
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }
}