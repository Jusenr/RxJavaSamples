package com.myself.rxjavasamsples.TestCase.mvptest.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.ResourceBanner;
import com.myself.rxjavasamsples.TestCase.mvptest.presenter.BannerPresenter;
import com.myself.rxjavasamsples.TestCase.mvptest.presenter.impl.BannerPresenterImpl;
import com.myself.rxjavasamsples.TestCase.mvptest.view.BannerView;
import com.myself.rxjavasamsples.library.base.PTNavActivity;
import com.myself.rxjavasamsples.library.utils.DensityUtil;
import com.myself.rxjavasamsples.library.view.image.ImageDraweeView;
import com.myself.rxjavasamsples.library.view.viewpager.banner.ConvenientBanner;
import com.myself.rxjavasamsples.library.view.viewpager.banner.holder.CBViewHolderCreator;
import com.myself.rxjavasamsples.library.view.viewpager.banner.holder.Holder;

import java.util.List;

import butterknife.Bind;

public class BannerActivity extends PTNavActivity<BannerPresenter> implements BannerView, View.OnClickListener {
    @Bind(R.id.cb_banner)
    ConvenientBanner cb_banner;//轮播图


    private List<ResourceBanner> banners;
    private ImageHolderView mImageHolderView;
    private CBViewHolderCreator<ImageHolderView> mCBViewHolderCreator;

    @Override
    protected BannerPresenter createPresenter() {
        return new BannerPresenterImpl(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_banner;
    }


    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();

        mPresenter.getBannerList();
    }

    @Override
    public void showBannerList(List<ResourceBanner> list) {
        banners = list;
        if (null != banners) {
            setBanner();
        }
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
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void showLoadingView() {
        loading.show();
    }

    @Override
    public void hideLoadingView() {
        loading.hide();
    }
}
