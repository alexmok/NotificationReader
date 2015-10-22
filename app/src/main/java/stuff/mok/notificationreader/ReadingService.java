package stuff.mok.notificationreader;

import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by Alexander on 10/22/2015.
 */
public class ReadingService extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification notification){
        String packageName = notification.getPackageName();
        String message = notification.getNotification().tickerText.toString();
        Bundle extras = notification.getNotification().extras;
        String title = extras.getString("android.title");
        String text = extras.getCharSequence("android.text").toString();

        Intent messageDetails = new Intent("Notification Msg");
        messageDetails.putExtra("package", packageName);
        messageDetails.putExtra("message", message);
        messageDetails.putExtra("title", title);
        messageDetails.putExtra("text", text);

        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(messageDetails);
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification notification){
        String packageName = notification.getPackageName();

        Intent messageDetails = new Intent("Notification Msg");
        messageDetails.putExtra("package", packageName);

        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(messageDetails);
    }
}
