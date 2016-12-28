package com.myself.rxjavasamsples.TestCase.mvptest.test;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.mvptest.test.api.NetworkApi;
import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.ResourceBanner;
import com.myself.rxjavasamsples.library.base.PTWDActivity;
import com.myself.rxjavasamsples.library.utils.DensityUtil;
import com.myself.rxjavasamsples.library.utils.ToastUtils;
import com.myself.rxjavasamsples.library.view.image.ImageDraweeView;
import com.myself.rxjavasamsples.library.view.viewpager.banner.ConvenientBanner;
import com.myself.rxjavasamsples.library.view.viewpager.banner.holder.CBViewHolderCreator;
import com.myself.rxjavasamsples.library.view.viewpager.banner.holder.Holder;
import com.myself.rxjavasamsples.retrofit.rx.DataHelper;
import com.myself.rxjavasamsples.retrofit.ParamsBuilder;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Banner2Activity extends PTWDActivity {
    @Bind(R.id.cb_banner)
    ConvenientBanner cb_banner;//轮播图
    @Bind(R.id.iv_icon)
    ImageDraweeView iv_icon;
    @Bind(R.id.iv_icon_1)
    ImageDraweeView iv_icon_1;
    @Bind(R.id.iv_icon_2)
    ImageDraweeView iv_icon_2;

    private static ResourceBanner sBanner;

    private List<ResourceBanner> banners;
    private ImageHolderView mImageHolderView;
    private CBViewHolderCreator<ImageHolderView> mCBViewHolderCreator;

    HashMap<String, String> mParams = ParamsBuilder.start().build();

    Observer<List<ResourceBanner>> observer = new Observer<List<ResourceBanner>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            ToastUtils.showToastShort(Banner2Activity.this, getString(R.string.loading_failed));
        }

        @Override
        public void onNext(List<ResourceBanner> list) {
            Log.e("#####", "List<ResourceBanner>=: " + list);

            banners = list;

            setBanner();

            iv_icon.setImageURL(sBanner.getBanner());
            iv_icon_1.setImageURL(sBanner.getBanner());
            iv_icon_2.setImageURL(sBanner.getBanner());
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_banner;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();

        String url_1 = "http://weidu.file.dev.putaocloud.com/file/c0b10c2d376d14139c2a7f5b92c6cb569d2dce83.jpg";
        String url_2 = "http://weidu.file.dev.putaocloud.com/file/1c151fd6f09411ddac8696c5b4f368e071199106.jpg";
        String url_3 = "http://weidu.file.dev.putaocloud.com/file/1885c91e518113afd75ab9be9a6e6aeb0a31db95.jpg";
        String url_4 = "http://weidu.file.dev.putaocloud.com/file/2933fd6d786ba052e5dc330bb4f24853b77e9c9f.png";

        unsubscribe();
        subscription = NetworkApi.getWeiDu2Api()
                .getBannerList(mParams)
                .map(DataHelper.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 设置轮播图适配器
     */
    private void setBanner() {
        if (null == mImageHolderView)
            mImageHolderView = new ImageHolderView();

        if (null == mCBViewHolderCreator)
            mCBViewHolderCreator = new CBViewHolderCreator<ImageHolderView>() {
                @Override
                public ImageHolderView createHolder() {
                    return mImageHolderView;
                }
            };
        cb_banner.setPages(mCBViewHolderCreator, banners);
    }

    /**
     * 广告页(轮播图)
     */
    static class ImageHolderView implements Holder<ResourceBanner> {
        private ImageDraweeView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageDraweeView(context);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) DensityUtil.px2dp(context, 200));
            imageView.setLayoutParams(params);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, ResourceBanner data) {
            imageView.setImageURL(data.getBanner());
            sBanner = data;
        }
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }
}
