package com.gb.lib.servcie;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import androidx.core.app.NotificationCompat;

import com.gb.lib.servcie.i.IForeService;

public abstract class FService extends BService implements IForeService {

    @Override
    public void created(
    ) {
        this.manager().createNotificationChannel(
                this.channelOptions(
                        this.channel()
                )
        );

        this.startForeground(
                this.idForeground(),
                this.startNotificationOptions(new NotificationCompat.Builder(this, this.channelId()).setPriority(this.notificationImportance()))
        );
    }

    protected NotificationChannel channel(

    ) {
        return new NotificationChannel(this.channelId(), "service", this.channelImportance());
    }

    protected NotificationManager manager(

    ) {
        return this.getSystemService(NotificationManager.class);
    }

    protected void notify(Notification notification) {
        this.manager(

        ).notify(this.idForeground(), notification);
    }
}
