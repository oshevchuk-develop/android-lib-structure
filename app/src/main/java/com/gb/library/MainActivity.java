package com.gb.library;

import android.view.View;

import androidx.annotation.LayoutRes;

import com.gb.lib.activity.base.ABase;
import com.gb.lib.adapters.rv.BaseAdapter;
import com.gb.lib.app.App;
import com.gb.lib.view.holders.VHBase;

public class MainActivity extends ABase<App> {

    protected @LayoutRes
    int getLayout() {
        return
                R.layout.activity_main;
    }

    private class Node implements BaseAdapter.IItem {

    }

    private class Hol extends VHBase {

        public Hol(View v) {
            super(
                    v);
        }
    }

    @Override
    public void created() {

        BaseAdapter<Node, Hol> adapter = new BaseAdapter<Node, Hol>(this, -1) {

            @Override
            public void bind(Hol holder, Node item, int i) {

            }
        };
    }
}