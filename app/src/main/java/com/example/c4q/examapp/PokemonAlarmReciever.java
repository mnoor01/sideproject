package com.example.c4q.examapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by c4q on 1/29/18.
 */

public class PokemonAlarmReciever extends BroadcastReceiver {
    public static  final int REQUEST_CODE= 1568921;
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i= new Intent(context,PokemonNotificationService.class);
    }
}
