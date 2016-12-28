package com.myself.rxjavasamsples.TestCase.navigationbar;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.rxjava.model.Item;
import com.myself.rxjavasamsples.library.base.PTWDActivity;
import com.myself.rxjavasamsples.library.utils.Logger;
import com.myself.rxjavasamsples.library.view.CleanableEditText;
import com.myself.rxjavasamsples.library.view.image.BitmapLoader;
import com.myself.rxjavasamsples.library.view.image.ImageDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Observer;

public class TestActivity extends PTWDActivity implements View.OnClickListener {

    @Bind(R.id.tv_1)
    TextView tv_1;
    @Bind(R.id.et_account)
    CleanableEditText et_account;
    @Bind(R.id.iv_icon)
    ImageDraweeView mIcon;
    @Bind(R.id.iv_icon_2)
    SimpleDraweeView iv_icon_2;
    @Bind(R.id.iv_icon_1)
    ImageView iv_icon_1;
    @Bind(R.id.iv_icon_3)
    ImageView iv_icon_3;

    String url = "http://weidu.file.dev.putaocloud.com/file/d6d7ca0a3ffbb48a4f2f706c351b2dd714f81db1.png";
    String url_1 = "http://weidu.file.dev.putaocloud.com/file/c0b10c2d376d14139c2a7f5b92c6cb569d2dce83.jpg";

    Observer<List<Item>> observer = new Observer<List<Item>>() {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(TestActivity.this, R.string.loading_failed, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(List<Item> images) {

            Logger.d(images.toString());
        }
    };

    private NAVPopupWindow mNavPopupWindow;

    @Override
    protected int getLayoutId() {
        Fresco.initialize(this);

        return R.layout.activity_test;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();

        initData();
    }

    protected void initData() {
        mIcon.setImageURL(url_1);//自定义控件 ImageDraweeView


        iv_icon_2.setImageURI(Uri.parse(url_1));//Fresco


        Glide.with(this)
                .load(url_1)//图片地址
                .centerCrop()
                .placeholder(R.drawable.img_loadding)//缺省的占位图片，一般可以设置成一个加载中的进度GIF图
                .crossFade()
                .into(iv_icon_1);//ImageView对象 Glide


        BitmapLoader.newInstance(this).load(url_1, new BitmapLoader.BitmapCallback() {
            @Override
            public void onResult(Bitmap bitmap) {
                iv_icon_3.setImageBitmap(bitmap);//BitmapLoader
            }
        });
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                Editable text = et_account.getText();
                tv_1.setText(text);
                break;
            case R.id.btn_2:

                break;
            case R.id.btn_3:
                tv_1.setText("3");
                break;
            case R.id.btn_4:
                tv_1.setText("4");
                break;
        }
    }

    @Override
    public void onRightAction() {
        super.onRightAction();
        //实例化NAVPopupWindow
        mNavPopupWindow = new NAVPopupWindow(this, itemsOnClick);
        //显示窗口
        mNavPopupWindow.showAtLocation(this.findViewById(R.id.navigation_bar), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
    }

    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mNavPopupWindow.dismiss();
            switch (v.getId()) {
                case R.id.btn_take_photo:
                    break;
                case R.id.btn_pick_photo:
                    break;
            }
        }
    };
}
