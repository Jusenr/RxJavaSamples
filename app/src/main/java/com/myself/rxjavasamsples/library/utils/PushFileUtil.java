package com.myself.rxjavasamsples.library.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by riven_chris on 16/6/27.
 */
public class PushFileUtil {

    public enum GPushMode {
        HOST_FORMAL(DEFAULT_SERVER, GPUSH_APP_ID, GPUSH_KEY, GPUSH_TOKEN),
        HOST_DEV(DEFAULT_SERVER_DEBUG, GPUSH_APP_ID_DEBUG, GPUSH_KEY_DEBUG, GPUSH_TOKEN_DEBUG),
        HOST_TEST(DEFAULT_SERVER_TEST, GPUSH_APP_ID_TEST, GPUSH_KEY_TEST, GPUSH_TOKEN_TEST);

        private String server;
        private String appIdName;
        private String keyName;
        private String tokenName;

        GPushMode(String server, String appIdName, String keyName, String tokenName) {
            this.server = server;
            this.appIdName = appIdName;
            this.keyName = keyName;
            this.tokenName = tokenName;
        }

        String server() {
            return server;
        }

        String appIdName() {
            return appIdName;
        }

        String keyName() {
            return keyName;
        }

        String tokenName() {
            return tokenName;
        }
    }

    static final String PLATFORM = "android";

    private static final String DEFAULT_SERVER_DEBUG = "http://10.1.11.171:10090/mqtt_server";
    private static final String DEFAULT_SERVER = "http://push-gateway.putaocloud.com/mqtt_server";
    private static final String DEFAULT_SERVER_TEST = "http://push-gateway-test.putaocloud.com/mqtt_server";

    private static final String GPUSH_APP_ID_DEBUG = "GPUSH_APP_ID_DEBUG";
    private static final String GPUSH_APP_ID = "GPUSH_APP_ID";
    private static final String GPUSH_APP_ID_TEST = "GPUSH_APP_ID_TEST";

    private static final String GPUSH_KEY_DEBUG = "GPUSH_KEY_DEBUG";
    private static final String GPUSH_KEY = "GPUSH_KEY";
    private static final String GPUSH_KEY_TEST = "GPUSH_KEY_TEST";

    private static final String GPUSH_TOKEN_DEBUG = "GPUSH_TOKEN_DEBUG";
    private static final String GPUSH_TOKEN = "GPUSH_TOKEN";
    private static final String GPUSH_TOKEN_TEST = "GPUSH_TOKEN_TEST";

    /**
     * 保存推送日志到sd卡gpushlig.txt
     *
     * @param fPath
     * @param str
     */
    public static void saveLog(String fPath, String str) {
        File file = new File(fPath);
        String contentstr = "";
        if (file.exists() == true) {
            contentstr = readFile(fPath);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date(System
                .currentTimeMillis()));
        str = dateString + " " + str;
        contentstr = str + "\n" + contentstr;
        if (contentstr.length() > 5000)
            contentstr = contentstr.substring(0, 5000);
        saveFile(fPath, contentstr);
        formatter = null;
    }

    private static void saveFile(String fileName, String str) {
        File file = new File(fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bytes = str.getBytes();
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String fileName) {
        String res = "";
        try {
            File fileDir = new File(fileName);
            FileInputStream is = new FileInputStream(fileDir);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] array = new byte[1024];
            int len = -1;

            while ((len = is.read(array)) != -1) {
                bos.write(array, 0, len);
            }
            bos.close();
            is.close();
            res = bos.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
