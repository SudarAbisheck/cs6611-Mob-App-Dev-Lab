package me.sudar.alarmclock;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;

/**
 * Created by Sudar Abisheck on 6/4/16.
 */
public class MeraBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(500);

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(context, notification);
        r.play();

        NotificationManager manager;
        Notification myNotication;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);

        builder.setAutoCancel(false);
        builder.setTicker("ICON");
        builder.setContentTitle("Alarm");
        builder.setContentText("Its time wake up");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.build();

        myNotication = builder.getNotification();
        manager.notify(11, myNotication);

    }
}
