package notes.com.example.rafaelgp87.cursofirebasenotes;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by rgutierrez on 09/02/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(TAG,remoteMessage.getFrom());
        openActivity(remoteMessage);
    }

    public void openActivity(RemoteMessage remoteMessage){
        Intent intent = new Intent(this,NotificationActivity.class);
        intent.putExtra("title",remoteMessage.getNotification().getTitle());
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_twitter)
                .setContentTitle("Título Notificación")
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify("TAG",10,builder.build());
    }
}
