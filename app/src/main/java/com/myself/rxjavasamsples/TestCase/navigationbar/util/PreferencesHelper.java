package com.myself.rxjavasamsples.TestCase.navigationbar.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.myself.rxjavasamsples.BasicApplication;
import com.myself.rxjavasamsples.TestCase.navigationbar.model.BindChild;

import java.util.List;

/**
 * Created by riven_chris on 16/8/30.
 */
public class PreferencesHelper {

    public static final String SP_CHILD_ABILITY_SUFFIX = "sp_child_ability_suffix";

    public static int getChildAbilityLog(String child, String ability) {
        SharedPreferences sp = BasicApplication.getInstance().getSharedPreferences(
                child + PreferencesHelper.SP_CHILD_ABILITY_SUFFIX, Context.MODE_PRIVATE);
        return sp.getInt(child + ability, 0);
    }

    public static void saveChildAbilityLog(String child, String ability, int count) {
        SharedPreferences sp = BasicApplication.getInstance().getSharedPreferences(
                child + PreferencesHelper.SP_CHILD_ABILITY_SUFFIX, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(child + ability, count);
        editor.commit();
    }

    public static boolean hasNewChildAbilityLog(List<BindChild> bindChildren) {
        for (BindChild bindChild : bindChildren) {
            if (bindChild != null) {
                String childId = bindChild.getChildid();
                SharedPreferences sp = BasicApplication.getInstance().getSharedPreferences(
                        childId + PreferencesHelper.SP_CHILD_ABILITY_SUFFIX, Context.MODE_PRIVATE);
                if (sp.getAll().size() > 0)
                    return true;
            }
        }
        return false;
    }

    public static boolean childHasNewLog(String childId) {
        SharedPreferences sp = BasicApplication.getInstance().getSharedPreferences(
                childId + PreferencesHelper.SP_CHILD_ABILITY_SUFFIX, Context.MODE_PRIVATE);
        if (sp.getAll().size() > 0)
            return true;
        return false;
    }

    public static void removeChildAbilityLog(String childId, String ability) {
        SharedPreferences sp = BasicApplication.getInstance().getSharedPreferences(
                childId + PreferencesHelper.SP_CHILD_ABILITY_SUFFIX, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(childId + ability);
        editor.commit();
    }
}
