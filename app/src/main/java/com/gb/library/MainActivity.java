package com.gb.library;

import androidx.annotation.LayoutRes;

import com.gb.lib.activity.base.ABase;
import com.gb.lib.app.App;

public class MainActivity extends ABase<App> {

    protected @LayoutRes
    int getLayout() {
        return
                R.layout.activity_main;
    }
}