package com.myself.rxjavasamsples.retrofit.api;

/**
 * Created by xiaopeng on 16/7/11.
 * create at 16/7/11 下午1:51
 */

public class BaseApi {

    public static final int HOST_FORMAL = 1;//正式环境
    public static final int HOST_DEV = 2;//开发环境
    public static final int HOST_TEST = 3;//测试环境

    public static int HOST_NOW;//当前环境
    /*所有的BASE URL*/
    /**
     * weidu_base_url
     */
    public static String WEIDU_BASE_URL = "";
    /**
     * data_base_url
     */
    public static String GANK_IO_URL = "";
    /**
     * 文件下载
     */
    public static String PT_CLOUD_FILE = "";

    /**
     * environment: 1，外网 2，开发内网，3，测试内网
     */
    public static void init(int environment) {
        HOST_NOW = environment;
        switch (environment) {
            case 1:
                WEIDU_BASE_URL = "http://api-weidu.putao.com/";
                GANK_IO_URL = "http://gank.io/api/";
                PT_CLOUD_FILE = "http://weidu.file.putaocloud.com/file/";


                break;
            case 2:
                WEIDU_BASE_URL = "http://api-weidu.ptdev.cn/";
                GANK_IO_URL = "http://gank.io/api/";
                PT_CLOUD_FILE = "http://weidu.file.dev.putaocloud.com/file/";


                break;
            case 3:
                WEIDU_BASE_URL = "http://api-weidu-test.ptdev.cn/";
                GANK_IO_URL = "http://gank.io/api/";
                PT_CLOUD_FILE = "http://weidu.file.dev.putaocloud.com/file/";


                break;
        }
    }

    /**
     * 是否是Debug环境
     *
     * @return
     */
    public static boolean isDebug() {
        return HOST_NOW == HOST_DEV || HOST_NOW == HOST_TEST;
    }

    /*所有的相对URL*/
    public static class Url {
        //============================Gank2Api--START==================================//
        /**
         * 资源--资源列表
         */
        public static final String URL_RESOURCES = "resources/resources";
        /**
         * 资源--轮播图
         */
        public static final String URL_BANNER = "resources/banner";
        /**
         * 资源--大图
         */
        public static final String URL_TOP = "resources/top";
        /**
         * 资源列表
         */
        public static final String URL_WELFARE = "data/福利/{number}/{page}";
    }

}
