package com.myself.rxjavasamsples.TestCase.navigationbar.data;

/**
 * Description: 1.3.8产品 参数常量
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/10/13 11:33
 */
public class Paramets {
    public static final String PARAM_CID = "cid";//-------------------------子账号的UID
    /*产品首页*/
    public static final String PARAM_GOODS_ID = "goods_id";//---------------------产品id

    /*产品列表*/
    public static final String PARAM_type = "type";//-----------------------------默认不传则返回全部产品 active=已激活 unactivated=未激活

    public static final String url = "http://a2.qpic.cn/psb?/V135ExbB3PutRF/M98sdWk1ok3EoI*L5pDRyxxzsQotTANeWp*yiN8Aj4I!/b/dAkBAAAAAAAA";
    public static final String url_0 = "http://pic33.nipic.com/20130910/10341645_114359329000_2.jpg";
    public static final String Url_1 = "http://a3.qpic.cn/psb?/V135ExbB3PutRF/*TZBTCN5kPYYrf97B4drV0wSZ6nuuEp5DQlgO.lEJAI!/b/dPgAAAAAAAAA";
    public static final String Url_2 = "http://pic.58pic.com/58pic/10/97/33/81u58PICTkw.jpg";
    public static final String Url_3 = "http://pic.58pic.com/58pic/14/27/45/71r58PICmDM_1024.jpg";
    public static final String Url_4 = "http://a2.qpic.cn/psb?/V135ExbB3PutRF/VplUwbrhCrhSOOG8YiM.T1g.cXLX9lI4lUyyZPFJJ64!/b/dOUAAAAAAAAA";
    public static final String Url_5 = "http://a1.qpic.cn/psb?/V135ExbB3PutRF/MTT2OPW.vKtJxxciyBuI0aEmiGHKd4WNceMKFLWTe.8!/b/dK4AAAAAAAAA";
    public static final String Url_6 = "http://pic30.nipic.com/20130618/12106414_153125248362_2.jpg";
    public static final String Url_7 = "http://a2.qpic.cn/psb?/V135ExbB3PutRF/ogTBEjb3JpeXhLarKHWZl7OMEIzYcJrg2Hw2K0m9SWc!/b/dAkBAAAAAAAA";
    public static final String Url_8 = "http://img.taopic.com/uploads/allimg/140326/235113-1403260SI415.jpg";
    public static final String Url_9 = "http://pic33.nipic.com/20130910/10341645_114359329000_2.jpg";

    //图片
    public static final String[] IMG_URLS = new String[]{url, url_0, Url_1, Url_2, Url_3, Url_4, Url_5, Url_6, Url_7, Url_8,Url_9};


    //激活列表数据测试
    public static final String json_list =
            "{\n" +
                    "    \"data\": [\n" +
                    "        {\n" +
                    "            \"goods_list\": [\n" +
                    "                {\n" +
                    "                    \"appid\": 1101,\n" +
                    "                    \"goods_cover\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_icon\": \"http://weidu.file.dev.putaocloud.com/file/d6f8c358be5cf69530bf58e17952a778e27e1b11.png\",\n" +
                    "                    \"goods_id\": 1,\n" +
                    "                    \"goods_name\": \"PAIBOT\",\n" +
                    "                    \"is_active\": 0,\n" +
                    "                    \"service_id\": 1236\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"appid\": 1102,\n" +
                    "                    \"goods_cover\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_icon\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_id\": 2,\n" +
                    "                    \"goods_name\": \"PAIBOT_1\",\n" +
                    "                    \"is_active\": 1,\n" +
                    "                    \"service_id\": 4586\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"appid\": 1103,\n" +
                    "                    \"goods_cover\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_icon\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_id\": 3,\n" +
                    "                    \"goods_name\": \"PAIBOT_2\",\n" +
                    "                    \"is_active\": 0,\n" +
                    "                    \"service_id\": 6927\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"appid\": 1104,\n" +
                    "                    \"goods_cover\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_icon\": \"http://weidu.file.dev.putaocloud.com/file/d6f8c358be5cf69530bf58e17952a778e27e1b11.png\",\n" +
                    "                    \"goods_id\": 4,\n" +
                    "                    \"goods_name\": \"PAIBAND\",\n" +
                    "                    \"is_active\": 0,\n" +
                    "                    \"service_id\": 4576\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"type_name\": \"PAI系列\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"goods_list\": [\n" +
                    "                {\n" +
                    "                    \"appid\": 1100,\n" +
                    "                    \"goods_cover\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_icon\": \"http://weidu.file.dev.putaocloud.com/file/d6f8c358be5cf69530bf58e17952a778e27e1b11.png\",\n" +
                    "                    \"goods_id\": 1,\n" +
                    "                    \"goods_name\": \"Hello编程\",\n" +
                    "                    \"is_active\": 0,\n" +
                    "                    \"service_id\": 3567\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"appid\": 1101,\n" +
                    "                    \"goods_cover\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_icon\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_id\": 2,\n" +
                    "                    \"goods_name\": \"Hello编程\",\n" +
                    "                    \"is_active\": 1,\n" +
                    "                    \"service_id\": 8756\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"appid\": 1102,\n" +
                    "                    \"goods_cover\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_icon\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_id\": 3,\n" +
                    "                    \"goods_name\": \"Hello编程\",\n" +
                    "                    \"is_active\": 0,\n" +
                    "                    \"service_id\": 2496\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"appid\": 1103,\n" +
                    "                    \"goods_cover\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_icon\": \"http://weidu.file.dev.putaocloud.com/file/d6f8c358be5cf69530bf58e17952a778e27e1b11.png\",\n" +
                    "                    \"goods_id\": 4,\n" +
                    "                    \"goods_name\": \"Hello编程\",\n" +
                    "                    \"is_active\": 0,\n" +
                    "                    \"service_id\": 5688\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"type_name\": \"科技产品\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"goods_list\": [\n" +
                    "                {\n" +
                    "                    \"appid\": 1103,\n" +
                    "                    \"goods_cover\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_icon\": \"http://weidu.file.dev.putaocloud.com/file/74a547db5b0971b9b17e28fe4ad191b8f5880bdd.png\",\n" +
                    "                    \"goods_id\": 1,\n" +
                    "                    \"goods_name\": \"浏览器\",\n" +
                    "                    \"is_active\": 1,\n" +
                    "                    \"service_id\": 9834\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"type_name\": \"应用\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"http_code\": 200,\n" +
                    "    \"msg\": \"\"\n" +
                    "}";
    //产品信息数据测试
    public static final String json_list_0 =
            "{\n" +
                    "  \"data\": {\n" +
                    "    \"appid\": 1100,\n" +
                    "    \"banner\": [\n" +
                    "      {\n" +
                    "        \"cover\": \"http://weidu.file.dev.putaocloud.com/file/780789dda3071e8dce6b907b7f239ce4649b73b1.jpg\",\n" +
                    "        \"location_action\": \"action_9\",\n" +
                    "        \"location_type\": \"local\",\n" +
                    "        \"media_type\": \"image\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"bluetooth\": {\n" +
                    "      \"device_id\": \"aa-bb-cc-dd-ee-ff\",\n" +
                    "      \"is_bluetooth\": 1\n" +
                    "    },\n" +
                    "    \"goods_id\": 1,\n" +
                    "    \"goods_name\": \"Hello编程\",\n" +
                    "    \"icon\": \"http://weidu.file.dev.putaocloud.com/file/d6f8c358be5cf69530bf58e17952a778e27e1b11.png\",\n" +
                    "    \"introduce\": {\n" +
                    "      \"author\": \"匿名\",\n" +
                    "      \"content\": \"这是一个用编程改变世界的时代，学会编程，还有什么不！可！能？\"\n" +
                    "    },\n" +
                    "    \"is_active\": 0,\n" +
                    "    \"menu\": [\n" +
                    "      {\n" +
                    "        \"icon\": \"http://weidu.file.dev.putaocloud.com/file/04827c12b81262f9da5c0b0013e132ea91e41cf9.png\",\n" +
                    "        \"location_action\": \"http://putao.com\",\n" +
                    "        \"location_type\": \"h5\",\n" +
                    "        \"name\": \"产品介绍\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"icon\": \"http://weidu.file.dev.putaocloud.com/file/04827c12b81262f9da5c0b0013e132ea91e41cf9.png\",\n" +
                    "        \"location_action\": \"action_2\",\n" +
                    "        \"location_type\": \"local\",\n" +
                    "        \"name\": \"配套教具\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"service_id\": 123\n" +
                    "  },\n" +
                    "  \"http_code\": 200,\n" +
                    "  \"msg\": \"\"\n" +
                    "}";

    //孩子列表数据测试
    public static final String json_list_1 =
            "{\n" +
                    "    \"error_code\": 0,\n" +
                    "    \"list\": [\n" +
                    "        {\n" +
                    "            \"authorize\": \"1\",\n" +
                    "            \"bind\": \"1\",\n" +
                    "            \"child_info\": {\n" +
                    "                \"avatar\": \"3a541607052916c84a4079edcb1adf937258d8ea.jpg\",\n" +
                    "                \"birthday\": \"251913600\",\n" +
                    "                \"gender\": \"0\",\n" +
                    "                \"nickname\": \"xiaohua\",\n" +
                    "                \"username\": \"xiaohua\"\n" +
                    "            },\n" +
                    "            \"childid\": \"6012731\",\n" +
                    "            \"nick_name\": \"小花\",\n" +
                    "            \"relationship\": \"1\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"authorize\": \"1\",\n" +
                    "            \"bind\": \"1\",\n" +
                    "            \"child_info\": {\n" +
                    "                \"avatar\": \"b98ba790f3156b55a643174cb3c3c002a2614d11.jpg\",\n" +
                    "                \"birthday\": \"1346342400\",\n" +
                    "                \"gender\": \"0\",\n" +
                    "                \"nickname\": \"xiaowen\",\n" +
                    "                \"username\": \"xiaowen\"\n" +
                    "            },\n" +
                    "            \"childid\": \"6012979\",\n" +
                    "            \"nick_name\": \"小文\",\n" +
                    "            \"relationship\": \"1\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"authorize\": \"1\",\n" +
                    "            \"bind\": \"1\",\n" +
                    "            \"child_info\": {\n" +
                    "                \"avatar\": \"3c28a915d14412d6423e806a46c6f0e5302dd0a3.jpg\",\n" +
                    "                \"birthday\": \"2003-08-31\",\n" +
                    "                \"gender\": \"0\",\n" +
                    "                \"nickname\": \"xiaobudian\",\n" +
                    "                \"username\": \"xiaobudian\"\n" +
                    "            },\n" +
                    "            \"childid\": \"6012987\",\n" +
                    "            \"nick_name\": \"小不点\",\n" +
                    "            \"relationship\": \"1\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
}
