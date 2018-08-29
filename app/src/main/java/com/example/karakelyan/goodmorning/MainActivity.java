package com.example.karakelyan.goodmorning;

import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Notification notification = new Notification.Builder(this)
//                // Show controls on lock screen even when user hides sensitive content.
//                .setVisibility(Notification.VISIBILITY_PUBLIC)
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("Bla bla")
//                        .build();
//
//        notification.notify();
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//
//// notificationId is a unique int for each notification that you must define
//        notificationManager.notify(21, mBuilder.build());
    }

    public void onCurrencyClick(View view)
    {
        Intent intent = new Intent(this, CurrencyActivity.class);
        startActivity(intent);

    }

    public void onBiorhythmsClick(View view)
    {
        Intent intent = new Intent(this, BiorhythmusActivity.class);
        startActivity(intent);

    }


}
