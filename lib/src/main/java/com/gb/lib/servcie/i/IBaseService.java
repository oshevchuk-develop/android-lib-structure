package com.gb.lib.servcie.i;

import android.content.Intent;
import android.os.IBinder;

public interface IBaseService {

    IBinder bind(
            Intent intent);

    int command(
            Intent intent, int flags, int start);

    int commandCode(
            Intent intent, int flags, int start);

    void created(

    );

    void destroy(

    );

    String broadcastAction(

    );
}
