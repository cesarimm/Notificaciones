package com.example.cesarivanmtz.onderapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

public class MyNotificacion {

    private Context ctx;
    public static final int NOTIFICACION_ID = 224;

    public MyNotificacion(Context ctx) {
        this.ctx = ctx;
    }

    public void showNotificacion(String from, String notificacion, Intent intent){
        PendingIntent pendingIntent = PendingIntent.getActivity(
           ctx,
           NOTIFICACION_ID,
           intent,
           PendingIntent.FLAG_UPDATE_CURRENT
        );
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx);
        Notification mNotificacion = builder.setSmallIcon(R.mipmap.ic_launcher).
                setAutoCancel(true).setContentIntent(pendingIntent).
                setContentTitle(from).setContentText(notificacion).
                setLargeIcon(
                        BitmapFactory.decodeResource(ctx.getResources(), R.mipmap.ic_launcher)).
                build();

        mNotificacion.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager .notify(NOTIFICACION_ID, mNotificacion);
    }

}
