package com.myself.rxjavasamsples;

import android.os.Bundle;
import android.widget.TextView;

import com.myself.rxjavasamsples.bean.FirInfoBean;
import com.myself.rxjavasamsples.library.base.PTWDActivity;
import com.myself.rxjavasamsples.library.utils.DateUtils;
import com.myself.rxjavasamsples.library.utils.FileUtils;

import butterknife.Bind;

public class AppInfoActivity extends PTWDActivity {
    public static final String APP_INFO = "APP_INFO";

    @Bind(R.id.tv_appname)
    TextView tv_appname;
    @Bind(R.id.tv_version)
    TextView tv_version;
    @Bind(R.id.tv_versionShort)
    TextView tv_versionShort;
    @Bind(R.id.tv_fsize)
    TextView tv_fsize;
    @Bind(R.id.tv_updatetime)
    TextView tv_updatetime;
    @Bind(R.id.tv_changelog)
    TextView tv_changelog;
    @Bind(R.id.tv_update_url)
    TextView tv_update_url;
    @Bind(R.id.tv_installUrl)
    TextView tv_installUrl;

    private FirInfoBean mBean;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_app_info;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();

        mBean = (FirInfoBean) args.getSerializable(APP_INFO);

        initView();
    }

    private void initView() {
        tv_appname.setText(mBean.getName());
        tv_version.setText(mBean.getBuild());
        tv_versionShort.setText(mBean.getVersionShort());
        tv_fsize.setText(FileUtils.convertFileSize(mBean.getBinary().getFsize()));
        tv_updatetime.setText(DateUtils.millisecondToDate(mBean.getUpdated_at(), DateUtils.YMD_HMS_PATTERN));
        tv_changelog.setText(mBean.getChangelog());
        tv_update_url.setText(mBean.getUpdate_url());
        tv_installUrl.setText(mBean.getInstallUrl());
    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }
}
