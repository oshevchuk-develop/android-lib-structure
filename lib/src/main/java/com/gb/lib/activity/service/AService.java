package com.gb.lib.activity.service;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.gb.lib.activity.base.ABase;
import com.gb.lib.activity.service.i.IAService;
import com.gb.lib.servcie.BService;

public abstract class AService<APP extends Application, SERVICE extends BService> extends ABase<APP> implements IAService<SERVICE> {

    protected SERVICE service;

    protected AService start(

    ) {
        this.startService(this.service(

        ));
        return
                this;
    }

    protected AService stop(

    ) {
        this.stopService(this.service());
        return
                this;
    }

    protected AService bind(
            int flags) {
        this.bindService(this.service(), this.connection, flags);
        return
                this;

    }

    protected AService unbind(

    ) {
        this.unbindService(this.connection);
        return
                this;
    }

    protected AService receive(
            String[] channels
    ) {

        IntentFilter f = new IntentFilter();
        if (
                channels != null) {
            for (String channel : channels) {
                if (channel != null && !channel.isEmpty()) {
                    f.addAction(channel);
                }
            }
        }

        this.registerReceiver(this.receiver, f);
        return
                this;
    }

    protected AService unreceive(

    ) {
        this.unregisterReceiver(this.receiver);
        return
                this;
    }

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(
                ComponentName name, IBinder binder) {
            AService.this.connected(
                    name,
                    (AService.this.service = ((BService.LocalBinder<SERVICE>) binder).getService())
            );
        }

        @Override
        public void onServiceDisconnected(
                ComponentName name) {
            AService.this
                    .service = null;
            AService.this.disconnected(
                    name
            );

        }
    };

    private final BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(
                Context context, Intent intent) {
            AService.this.receive(
                    intent
            );
        }
    };


}
