package com.myself.rxjavasamsples.TestCase.navigationbar.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/10/21 16:24.
 */

public class ChildAbilities implements Serializable {
    private String ability_pic;
    private ArrayList<ChildAbility> ability_list;

    public String getAbility_pic() {
        return ability_pic;
    }

    public void setAbility_pic(String ability_pic) {
        this.ability_pic = ability_pic;
    }

    public ArrayList<ChildAbility> getAbility_list() {
        return ability_list;
    }

    public void setAbility_list(ArrayList<ChildAbility> ability_list) {
        this.ability_list = ability_list;
    }
}
