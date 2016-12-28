package com.myself.rxjavasamsples.TestCase.stickytest;

import android.os.Bundle;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.library.base.PTWDActivity;

public class StickyTestActivity extends PTWDActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sticky_test;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {

    }

    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }
}
