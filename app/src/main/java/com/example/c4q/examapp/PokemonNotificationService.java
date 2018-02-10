package com.example.c4q.examapp;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by c4q on 1/29/18.
 */

public class PokemonNotificationService extends IntentService {
    private static final String POKEMON_NOTIFICATION = "pokemon notification";
    private static final String POKEMON_NOTIFICAITON_CHANNEL = "pokemon notifications";
    private static final int POKFEFICATION_ID = 600;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public PokemonNotificationService() {
        super(POKEMON_NOTIFICATION);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent notificationIntent = new Intent(Intent.ACTION_VIEW);
        int requestID = (int) System.currentTimeMillis();
        int flags = PendingIntent.FLAG_CANCEL_CURRENT;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent, flags);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, POKEMON_NOTIFICAITON_CHANNEL)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("pokififcation")
                .setContentText("we are learning about pokemons")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        Notification nc = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(POKFEFICATION_ID,nc);


    }
}
