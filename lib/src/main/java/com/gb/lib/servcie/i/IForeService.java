package com.gb.lib.servcie.i;

import android.app.Notification;
import android.app.NotificationChannel;

import androidx.core.app.NotificationCompat;

public interface IForeService extends IBaseService {

    String channelId(

    );

    int channelImportance(

    );

    NotificationChannel channelOptions(
            NotificationChannel channel
    );

    int idForeground();

    Notification startNotificationOptions(
            NotificationCompat.Builder notification
    );

    int notificationImportance(

    );

}
