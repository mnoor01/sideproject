package com.example.c4q.examapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by c4q on 1/29/18.
 */

public class BootBroadcastReciever extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startServiceIntent= new Intent(context,PokemonNotificationService.class);
        startWakefulService(context,startServiceIntent);
    }
}
