package co.paulfran.paulfranco.prettynotification;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

public class CustomNotification {

    public void simpleNotification(Context context, String title, String content, int icon) {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(icon)
                .setContentTitle(title)
                .setContentText(content);

        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(10, mBuilder.build());

    }

    public void bigTextNotification(Context context, String title, String content, String bText, String summary, int sIcon, int bIcon) {

        Bitmap bImage = BitmapFactory.decodeResource(context.getResources(), bIcon);

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(bText);
        bigTextStyle.setSummaryText(summary);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(sIcon)
                .setLargeIcon(bImage)
                .setContentTitle(title)
                .setContentText(content)
                .setStyle(bigTextStyle);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(11, mBuilder.build());
    }

    public void inboxNotification(Context context, String content, String bTitle, String title, String summary, int icon, String ... messages) {

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        inboxStyle.setBigContentTitle(bTitle);
        inboxStyle.addLine(messages[0]);
        inboxStyle.addLine(messages[1]);
        inboxStyle.addLine(messages[2]);
        inboxStyle.addLine(messages[3]);
        inboxStyle.setSummaryText(summary);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(icon)
                .setContentTitle(title)
                .setContentText(content)
                .setStyle(inboxStyle);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(12, mBuilder.build());

    }


}
