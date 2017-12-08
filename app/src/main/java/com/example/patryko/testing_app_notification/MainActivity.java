package com.example.patryko.testing_app_notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        CustomNotification();
    }
    public void CustomNotification(){


        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.mojanotyfikacja);


        String str_title = "Notyfikacja: " + id;
        String str_txt1 = "Tresc1: gdfgsdgsd";
        String str_txt2 = "Tresc2: sdfgdgfdfgsdgfs";


        Intent intent = new Intent(this, MyNotification.class);
        intent.putExtra("title", str_title);
        intent.putExtra("text1", str_txt1);
        intent.putExtra("text2", str_txt2);

        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.mobile)
                .setAutoCancel(true)
                .setContentIntent(pIntent)
                .setContent(remoteViews);

        remoteViews.setTextViewText(R.id.title, str_title);
       remoteViews.setTextViewText(R.id.text1, str_txt1);
       remoteViews.setTextViewText(R.id.text2, str_txt2);

        NotificationManager notman = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notman.notify(id++, builder.build());


    }

}
