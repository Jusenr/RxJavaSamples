package com.myself.rxjavasamsples.TestCase.navigationbar.util;

import com.myself.rxjavasamsples.TestCase.navigationbar.model.ChildInfoBean;
import com.myself.rxjavasamsples.TestCase.navigationbar.model.ChildInfoResult;
import com.myself.rxjavasamsples.TestCase.navigationbar.model.Childs;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;

public class ChildInfoResultToItemsMapper implements Func1<ChildInfoResult, List<Childs>> {
    private static ChildInfoResultToItemsMapper INSTANCE = new ChildInfoResultToItemsMapper();

    private ChildInfoResultToItemsMapper() {
    }

    public static ChildInfoResultToItemsMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Childs> call(ChildInfoResult mChild) {
        List<ChildInfoBean> mChilds = mChild.mChildInfos;
        List<Childs> items = new ArrayList<>(mChilds.size());
        for (ChildInfoBean mInfo : mChilds) {
            Childs child = new Childs();
            child.childid = mInfo.childid;
            child.nick_name = mInfo.nick_name;
            child.relationship = mInfo.relationship;
            ChildInfoBean.ChildInfo childInfo = mInfo.getChild_info();
            child.username = childInfo.username;
            child.avatar = childInfo.avatar;
            child.birthday = childInfo.birthday;
            child.gender = childInfo.gender;
            child.nickname = childInfo.nickname;

            items.add(child);
        }
        return items;
    }
}
