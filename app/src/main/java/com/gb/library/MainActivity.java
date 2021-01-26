package com.gb.library;

import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.gb.lib.activity.base.ABase;
import com.gb.lib.adapters.rv.BaseAdapter;
import com.gb.lib.adapters.rv.holder.Holder;
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
            public void bind(Holder holder, Node item, int i) {

            }
        };

       /* new Post<Node>(() -> new ApiManager.JSONREST<Node>(Node.class) {


            @Override
            public Post.Response<Node> response(boolean success, int code, @NonNull String data, Class<Node> type) {
                return null;
            }
        }.run(MainActivity.this.app, null)).success(data -> {

        }).execute();*/
    }
}