package com.gb.lib.servcie.i;

import android.app.NotificationChannel;

public interface IForeService extends IBaseService {

    String channelId(

    );

    int channelImportance(

    );

    NotificationChannel channelOptions(
            NotificationChannel channel
    );

    int idForeground();

}
