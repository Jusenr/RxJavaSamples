package com.myself.rxjavasamsples;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.myself.rxjavasamsples.library.model.http.OkHttpManager;
import com.myself.rxjavasamsples.library.model.http.interceptor.CacheStrategyInterceptor;
import com.myself.rxjavasamsples.library.model.http.interceptor.NetworkInterceptor;
import com.myself.rxjavasamsples.library.model.http.interceptor.ResponseInfoInterceptor;
import com.myself.rxjavasamsples.library.utils.CrashHandler;
import com.myself.rxjavasamsples.library.utils.DiskFileCacheHelper;
import com.myself.rxjavasamsples.library.utils.ImageLoaderUtil;
import com.myself.rxjavasamsples.library.utils.Logger;
import com.myself.rxjavasamsples.library.utils.SDCardUtils;
import com.myself.rxjavasamsples.library.utils.hawk.Hawk;
import com.myself.rxjavasamsples.library.utils.hawk.LogLevel;
import com.myself.rxjavasamsples.retrofit.api.BaseApi;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;

import java.io.File;
import java.util.Map;

import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;
import cn.sharesdk.framework.ShareSDK;
import im.fir.sdk.FIR;
import okhttp3.OkHttpClient;

/**
 * 基础Application
 * Created by guchenkai on 2015/11/19.
 */
public class BasicApplication extends Application {
    private static final String KEY_APP_ID = "app_id";
    public static String app_id = "1109";

    private static final String JPUSH_APP_KEY = "67d50f78b590174b34661579";
    private static final String JPUSH_MASTER_SECRET = "ed353e9e30a20d4a4a228907";

    private static final String UMENG_APP_KEY = "57df54e5e0f55ad0560029f6";

    public static final String FIR_API_TOKEN = "1b91eb3eaaea5f64ed127882014995dd";

    public static final String BUGLY_APPID = "900055516";

    private static Context mContext;
    private static OkHttpClient mOkHttpClient;//OkHttpClient

    private static int maxAge;//网络缓存最大时间
    private static DiskFileCacheHelper mDiskFileCacheHelper;//磁盘文件缓存器
    public static boolean isDebug;

    public static String sdCardPath;//SdCard路径
    public static String shareImagePath;
    public static String blurIndex;
    public static String resourcePath;
    public static String scheduleIconsFileDirectory;
    public static MobclickAgent.UMAnalyticsConfig mUMeng_Config;

    public static Map<String, String> emojis;//表情包映射

    public static Map<String, String> getEmojis() {
        return emojis;
    }

    public static void setEmojis(Map<String, String> emojis) {
        BasicApplication.emojis = emojis;
    }

    /*jpUSH*/
//开发者标识(DevKey)： 85f5be7b0972830dba34c2c4   仅限于 API 调用时使用
//    API DevSecret： 6c2758d2e42152a05d2abc1a   仅限于 API 调用时使用


    @Override
    public void onCreate() {
        super.onCreate();
        //设置模式
        isDebug = isDebug();
        //Context对象
        mContext = getApplicationContext();
        //sdCard缓存路径
        sdCardPath = getSdCardPath();
/********************************************************************************************/
         /*网络环境切换*/
        BaseApi.init(BaseApi.HOST_TEST);

        /*JPush配置*/
        JPushInterface.setDebugMode(isDebug);
        JPushInterface.init(this);

        /*Bugly SDK初始化*/
        CrashReport.initCrashReport(getApplicationContext(), BUGLY_APPID, true);

        /*FIR-SDK设置*/
        FIR.init(this);

        /*UMeng友盟配置*/
        mUMeng_Config = new MobclickAgent.UMAnalyticsConfig(this, UMENG_APP_KEY, null);
        MobclickAgent.startWithConfigure(mUMeng_Config);
        MobclickAgent.enableEncrypt(true);

        /*Fresco配置*/
        Fresco.initialize(getApplicationContext());
//        Fresco.initialize(getApplicationContext(),
//                ImagePipelineConfigFactory.getOkHttpImagePipelineConfig(getApplicationContext(), getOkHttpClient()));

        /*shareSDK配置*/
        ShareSDK.initSDK(getApplicationContext());

        /*偏好设置*/
        Hawk.init(getApplicationContext(), getPackageName(), isDebug() ? LogLevel.FULL : LogLevel.FULL);

        /*日志输出设置*/
        Logger.init(getLogTag()).hideThreadInfo().setLogLevel(isDebug() ? Logger.LogLevel.FULL : Logger.LogLevel.FULL);

        /*图片工具设置*/
        ImageLoaderUtil.initImageLoader(this);

        shareImagePath = sdCardPath + File.separator + "screenshot.jpg";
        blurIndex = sdCardPath + File.separator + "screenindex.jpg";
        resourcePath = sdCardPath + File.separator + "patch";
        scheduleIconsFileDirectory = "asset:///schedule_icons/";

        //ButterKnife的Debug模式
        ButterKnife.setDebug(isDebug());
        //OkHttp初始化
        mOkHttpClient = OkHttpManager.getInstance(getNetworkCacheDirectoryPath(), getNetworkCacheSize())
                .addInterceptor(new NetworkInterceptor())
                .addInterceptor(new ResponseInfoInterceptor())
                .addInterceptor(new CacheStrategyInterceptor())
                .build();

        //网络缓存最大时间
        maxAge = getNetworkCacheMaxAgeTime();
        //磁盘文件缓存器
        mDiskFileCacheHelper = DiskFileCacheHelper.get(getApplicationContext(), getLogTag());
        //app_id配置
//        app_id = AppUtils.getMetaData(getApplicationContext(), KEY_APP_ID);
        //捕捉系统崩溃异常
        CrashHandler.getInstance().init(getApplicationContext(), new CrashHandler.OncrashHandler() {

            @Override
            public void onCrashHandler(Throwable ex) {
                onCrash(ex);
            }
        });
    }

    public static Context getInstance() {
        return mContext;
    }

    public static OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    public static int getMaxAge() {
        return maxAge;
    }

    public static DiskFileCacheHelper getDiskFileCacheHelper() {
        return mDiskFileCacheHelper;
    }

    /**
     * debug模式
     *
     * @return 是否开启
     */
    protected boolean isDebug() {
        return BaseApi.isDebug();
    }

    /**
     * 填写工程包名
     *
     * @return 工程包名
     */
    public String getPackageName() {
        return "com.myself.rxjavasamples";
    }

    /**
     * 设置调试日志标签名
     *
     * @return 调试日志标签名
     */
    protected String getLogTag() {
        return "rxjava_samples";
    }

    /**
     * 设置sdCard路径
     *
     * @return sdCard路径
     */
    protected String getSdCardPath() {
        Logger.d(SDCardUtils.getSDCardPath() + File.separator + getLogTag());
        return SDCardUtils.getSDCardPath() + File.separator + getLogTag();
    }

    /**
     * 网络缓存文件夹路径
     *
     * @return 缓存文件夹路径
     */
    protected String getNetworkCacheDirectoryPath() {
        return sdCardPath + File.separator + "http_cache";
    }

    /**
     * 网络缓存文件大小
     *
     * @return 缓存文件大小
     */
    protected int getNetworkCacheSize() {
        return 20 * 1024 * 1024;
    }

    /**
     * 网络缓存最大时间
     *
     * @return 缓存最大时间
     */
    protected int getNetworkCacheMaxAgeTime() {
        return 0;
    }

    /**
     * 异常信息处理
     *
     * @param ex 异常信息
     */
    protected void onCrash(Throwable ex) {
        Logger.e("APP崩溃了,错误信息是" + ex.getMessage());
        ex.printStackTrace();
        killProcess(getApplicationContext());
    }

    /**
     * 单点登录
     *
     * @param msg
     */
    public void singleSign(String msg) {

    }

    /**
     * 退出应用程序
     */
    public void killProcess(Context context) {
        try {
            android.app.ActivityManager activityMgr = (android.app.ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            MobclickAgent.onKillProcess(this);
            JPushInterface.onKillProcess(this);
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
