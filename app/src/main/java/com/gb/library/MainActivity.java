package com.gb.library;

import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.gb.lib.activity.base.ABase;
import com.gb.lib.adapters.rv.BaseAdapter;
import com.gb.lib.api.connection.Post;
import com.gb.lib.api.connection.manager.ApiManager;
import com.gb.lib.app.App;
import com.gb.lib.view.holders.VHBase;

public class MainActivity extends ABase<App> {

    protected @LayoutRes
    int getLayout() {
        return
                R.layout.activity_main;
    }

    private static class Node extends BaseAdapter.Item {

    }

    private static class Hol extends VHBase {

        public Hol(View v) {
            super(
                    v);
        }
    }

    private static class NodeRes extends ApiManager.JSONRPC2.Result {

    }


    @Override
    public void created() {

        BaseAdapter<Node, Hol> adapter = new BaseAdapter<Node, Hol>(this, -1) {

            @Override
            public void bind(Hol holder, Node item, int i) {

            }
        };

        new Post<>(new Post.IDo() {
            @Override
            public Post.Response get() {
                return new ApiManager.JSONREST<String>(String.class) {
                    @Override
                    public Post.Response response(boolean success, int code, @NonNull String data) {

                        return null;
                    }
                }.run(MainActivity.this.app, null);
            }
        }).execute();
    }
}