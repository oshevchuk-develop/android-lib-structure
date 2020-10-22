package com.gb.lib.activity.service.i;

import android.content.ComponentName;
import android.content.Intent;

public interface IAService<SERVICE> {

    Intent service(

    );

    void connected(
            ComponentName name, SERVICE service
    );

    void disconnected(
            ComponentName name
    );

    void receive(
            Intent intent
    );

}
