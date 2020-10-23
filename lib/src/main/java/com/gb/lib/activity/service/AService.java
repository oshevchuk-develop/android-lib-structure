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

    public SERVICE service;

    public AService start(

    ) {
        this.startService(this.intent(

        ));
        return
                this;
    }

    public AService stop(

    ) {
        this.stopService(this.intent());
        return
                this;
    }

    public AService bind(
            int flags) {
        this.bindService(this.intent(), this.connection, flags);
        return
                this;

    }

    public AService unbind(

    ) {
        this.unbindService(this.connection);
        return
                this;
    }

    public AService receive(
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

    public AService unreceive(

    ) {
        this.unregisterReceiver(this.receiver);
        return
                this;
    }

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(
                ComponentName name, IBinder binder) {
            AService.this.bound(
                    name,
                    (AService.this.service = ((BService.LocalBinder<SERVICE>) binder).getService())
            );
        }

        @Override
        public void onServiceDisconnected(
                ComponentName name) {
            AService.this
                    .service = null;
            AService.this.unbound(
                    name
            );

        }
    };

    private final BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(
                Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                AService.this.received(
                        intent.getAction(),
                        intent
                );
            }
        }
    };


}
