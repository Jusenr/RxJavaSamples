package com.myself.rxjavasamsples;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.myself.rxjavasamsples.TestCase.jpushtest.JPActivity;
import com.myself.rxjavasamsples.TestCase.navigationbar.data.Paramets;
import com.myself.rxjavasamsples.bean.FirInfoBean;
import com.myself.rxjavasamsples.library.controller.BasicFragmentActivity;
import com.myself.rxjavasamsples.library.utils.FileUtils;
import com.myself.rxjavasamsples.library.utils.Logger;
import com.myself.rxjavasamsples.library.utils.ToastUtils;
import com.myself.rxjavasamsples.library.view.image.ImageDraweeView;

import butterknife.Bind;
import butterknife.OnClick;
import im.fir.sdk.FIR;
import im.fir.sdk.VersionCheckCallback;

public class MainActivity extends BasicFragmentActivity implements View.OnClickListener {

    @Bind(R.id.idv_img)
    ImageDraweeView idv_img;
    @Bind(R.id.left_title)
    TextView left_title;
    @Bind(R.id.main_title)
    TextView main_title;
    @Bind(R.id.right_title)
    TextView right_title;

    private FirInfoBean mBean;
    private int index = 0;
    private String[] mImgUrls;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        getfir();

        mImgUrls = Paramets.IMG_URLS;

        idv_img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                getfir();
                return false;
            }
        });
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }

    @OnClick({R.id.left_title, R.id.right_title, R.id.main_title, R.id.idv_img})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_title:
                startActivity(new Intent(this, FunctionActivity.class));
                break;
            case R.id.main_title:
                startActivity(new Intent(this, JPActivity.class));
//                ToastUtils.showToastShort(this, "哈哈哈哈");
                break;
            case R.id.right_title:
                if (null != mBean) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(AppInfoActivity.APP_INFO, mBean);
                    startActivity(AppInfoActivity.class, bundle);
                } else
                    ToastUtils.showToastShort(this, "获取应用信息失败！");
                break;
            case R.id.idv_img:
                if (index < mImgUrls.length) {
                    idv_img.setImageURL(mImgUrls[index]);
                    ToastUtils.showToastShort(this, index+"");
                } else {
                    index = 0;
                }
                index++;
                break;
        }
    }

    /**
     * Fir获取版本信息测试(FIR)
     */
    public void getfir() {
        FIR.checkForUpdateInFIR(BasicApplication.FIR_API_TOKEN, new VersionCheckCallback() {
            @Override
            public void onSuccess(String versionJson) {
                Log.i("FIR", "check from fir.im success! " + "\n" + versionJson);

                mBean = new Gson().fromJson(versionJson, FirInfoBean.class);
                String fsize = FileUtils.convertFileSize(mBean.getBinary().getFsize());
                String installUrl = mBean.getInstallUrl();
                String version = mBean.getVersion();
                String changelog = mBean.getChangelog();
                String versionShort = mBean.getVersionShort();

                Logger.d("fsize=" + fsize + "\ninstallUrl=" + installUrl + "\nversion=" + version + "\nversionShort=" + versionShort + "\nchangelog=" + changelog);

            }

            @Override
            public void onFail(Exception exception) {
                Log.i("FIR", "check fir.im fail! " + "\n" + exception.getMessage());
                Toast.makeText(getApplicationContext(), R.string.not_network_try_again, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStart() {
                Toast.makeText(getApplicationContext(), "正在获取", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                if (null != mBean)
                    Toast.makeText(getApplicationContext(), "当前版本：" + mBean.getVersionShort(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 返回键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return exit();
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public String getVersionName() {
        try {
            PackageInfo info = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}