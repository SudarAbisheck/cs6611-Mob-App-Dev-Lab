package foxtrot.umbrella.sms_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by Sudar Abisheck on 2/4/16.
 */
public class MessageReceiver extends BroadcastReceiver {
    NotificationManager manager;
    Notification myNotication;

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        String phoneNumber ;

        String senderNum;
        String message;

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    senderNum = phoneNumber;
                    message = currentMessage.getDisplayMessageBody();

                    Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);


                    manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                    Intent newIntent = new Intent(context,MainActivity.class);
                    newIntent.putExtra("phoneno",phoneNumber);
                    newIntent.putExtra("senderno",senderNum);
                    newIntent.putExtra("message",message);

                    PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, newIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Notification.Builder builder = new Notification.Builder(context);

                    builder.setAutoCancel(false);
                    builder.setTicker("ICON");
                    builder.setContentTitle("SMS Send");
                    builder.setContentText(phoneNumber);
                    builder.setSmallIcon(R.mipmap.ic_launcher);
                    builder.setContentIntent(pendingIntent);
                    builder.setSubText(message);
                    builder.build();

                    myNotication = builder.getNotification();
                    manager.notify(11, myNotication);
                }
            }

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);

        }

    }
}