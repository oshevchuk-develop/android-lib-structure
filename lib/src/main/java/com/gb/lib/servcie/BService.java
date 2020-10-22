package com.gb.lib.servcie;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.gb.lib.app.utils.Utils;
import com.gb.lib.servcie.i.IBaseService;

public abstract class BService extends Service implements IBaseService {

    @Override
    public IBinder onBind(Intent intent) {
        return
                this.bind(intent);
    }

    @Override
    public int onStartCommand(
            Intent intent, int flags, int start) {
        return
                this.command(intent, flags, start);
    }

    @Override
    public void onCreate(

    ) {
        this.created();
    }

    @Override
    public void onDestroy(

    ) {
        this.destroy();
    }

    public Intent buffer(String channel) {
        return new Intent(
                this.broadcastAction() + "." + Utils.Strings.val(channel)
        );
    }

    public static abstract class LocalBinder<T> extends Binder implements ILBinder<T> {

    }

    interface ILBinder<T> {
        T getService(

        );
    }

}
