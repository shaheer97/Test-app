package com.example.test.Notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.test.R;

public class ReminderBroadcast extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {







        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"notifyme")
                .setSmallIcon(R.drawable.ic_baseline_category_24)
                .setContentTitle("Asma Ul Husna")
                .setContentText("Meaning")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(200,builder.build());
    }
}
