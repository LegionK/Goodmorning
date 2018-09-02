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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b_currency;
    Button b_biorhythmus;
    Button b_weather;
    Button b_habr;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_currency=(Button) findViewById(R.id.button4);
        b_biorhythmus=(Button) findViewById(R.id.button3);
        b_weather=(Button) findViewById(R.id.button5);
        b_habr=(Button) findViewById(R.id.button6);
        Animation anim,anim1,anim2,anim3;
        anim= AnimationUtils.loadAnimation(this, R.anim.mytrans);
        anim1=AnimationUtils.loadAnimation(this,R.anim.mytrans1);
        anim2=AnimationUtils.loadAnimation(this,R.anim.mytrans2);
        anim3=AnimationUtils.loadAnimation(this,R.anim.mytrans3);
        b_currency.startAnimation(anim);
        b_biorhythmus.startAnimation(anim1);
        b_habr.startAnimation(anim2);
        b_weather.startAnimation(anim3);

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
