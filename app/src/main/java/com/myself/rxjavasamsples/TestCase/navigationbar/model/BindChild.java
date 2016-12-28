package com.myself.rxjavasamsples.TestCase.navigationbar.model;

import java.io.Serializable;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/10/21 16:04.
 */

public class BindChild implements Serializable {
    private String bind;
    private ChildInfoBean child_info;
    private String childid;
    private String first_relation;
    private String nick_name;
    private String relationship;
    private String authorize;

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    public ChildInfoBean getChild_info() {
        return child_info;
    }

    public void setChild_info(ChildInfoBean child_info) {
        this.child_info = child_info;
    }

    public String getChildid() {
        return childid;
    }

    public void setChildid(String childid) {
        this.childid = childid;
    }

    public String getFirst_relation() {
        return first_relation;
    }

    public void setFirst_relation(String first_relation) {
        this.first_relation = first_relation;
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

    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
    }

    @Override
    public String toString() {
        return "BindChild{" +
                "bind='" + bind + '\'' +
                ", child_info=" + child_info +
                ", childid='" + childid + '\'' +
                ", first_relation='" + first_relation + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", relationship='" + relationship + '\'' +
                ", authorize='" + authorize + '\'' +
                '}';
    }

    public static class ChildInfoBean implements Serializable {
        private String avatar;
        private String birthday;
        private String gender;
        private String nickname;
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

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

        @Override
        public String toString() {
            return "ChildInfoBean{" +
                    "avatar='" + avatar + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", gender='" + gender + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", username='" + username + '\'' +
                    '}';
        }
    }
}
