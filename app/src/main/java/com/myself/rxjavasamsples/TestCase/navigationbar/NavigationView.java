package com.myself.rxjavasamsples.TestCase.navigationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.myself.rxjavasamsples.R;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/10/24 10:54.
 */

public class NavigationView extends RelativeLayout implements View.OnClickListener {

    public NavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initNavigationView(context, attrs);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    /**
     * 初始化视图
     *
     * @param context
     * @param attrs
     */
    private void initNavigationView(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_navigation_view, this, true);
    }

    @Override
    public void onClick(View v) {

    }
}
