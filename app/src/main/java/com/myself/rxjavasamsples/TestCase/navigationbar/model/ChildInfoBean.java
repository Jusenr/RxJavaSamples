package com.myself.rxjavasamsples.TestCase.navigationbar.model;

import com.myself.rxjavasamsples.retrofit.RetrofitAwfulList;

import java.io.Serializable;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/9/6 15:28.
 */
public class ChildInfoBean extends RetrofitAwfulList implements Serializable {
//    {
//        "error_code": 0,
//            "list": [
//        {
//            "authorize": "1",
//                "bind": "1",
//                "child_info": {
//            "avatar": "3a541607052916c84a4079edcb1adf937258d8ea.jpg",
//                    "birthday": "2015-08-01",
//                    "gender": "0",
//                    "nickname": "zxcvbn",
//                    "username": "zxcvbn"
//        },
//            "childid": "6083968",
//                "nick_name": "小女",
//                "relationship": "1"
//        }
//        ]
//    }

    public String childid;
    public String nick_name;
    public String relationship;
    public ChildInfo child_info;

    public String getChildid() {
        return childid;
    }

    public void setChildid(String childid) {
        this.childid = childid;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public ChildInfo getChild_info() {
        return child_info;
    }

    public void setChild_info(ChildInfo child_info) {
        this.child_info = child_info;
    }

    public class ChildInfo extends ChildInfoBean implements Serializable {
        public String avatar;
        public String birthday;
        public String gender;
        public String nickname;
        public String username;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "Childs{" +
                    "avatar='" + avatar + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", gender='" + gender + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", username='" + username + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ChildInfoBean{" +
                "childid='" + childid + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", relationship='" + relationship + '\'' +
                ", child_info=" + child_info +
                '}';
    }
}
