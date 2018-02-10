package com.example.c4q.examapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        scheduleAlarm();
    }
    public void scheduleAlarm(){
        Intent intent= new Intent(getApplicationContext(),PokemonAlarmReciever.class);
        final PendingIntent pendingInten01=PendingIntent.getBroadcast(this,PokemonAlarmReciever.REQUEST_CODE,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        long firstMillis=System.currentTimeMillis();
        AlarmManager alarmManager=(AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,firstMillis,AlarmManager.INTERVAL_HALF_HOUR,pendingInten01);

    }
}
