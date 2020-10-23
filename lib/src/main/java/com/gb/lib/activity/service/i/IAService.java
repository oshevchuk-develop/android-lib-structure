package com.gb.lib.activity.service.i;

import android.content.ComponentName;
import android.content.Intent;

import androidx.annotation.NonNull;

public interface IAService<SERVICE> {

    Intent intent(

    );

    void bound(
            ComponentName name, SERVICE service
    );

    void unbound(
            ComponentName name
    );

    void received(
            @NonNull String action, @NonNull Intent intent
    );

}
