package com.example.patryko.testing_app_notification;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);


        NotificationManager notmen = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notmen.cancel(0);

        Intent i = getIntent();

        String title = i.getStringExtra("title");
        String text1 = i.getStringExtra("text1");
        String text2 = i.getStringExtra("text2");

        TextView tvt = (TextView)findViewById(R.id.activity_title);
        TextView tvt1 = (TextView)findViewById(R.id.activity_text1);
        TextView tvt2 = (TextView)findViewById(R.id.activity_text2);



        tvt.setText(title);
        tvt1.setText(text1);
        tvt2.setText(text2);



    }
}
