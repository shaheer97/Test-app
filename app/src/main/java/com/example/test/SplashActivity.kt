package com.example.test

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.test.Notification.ReminderBroadcast
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        createNotificationChannel()

        val sideAnimation=AnimationUtils.loadAnimation(this,R.anim.slide)
        val bottonAnimation=AnimationUtils.loadAnimation(this,R.anim.slide_bottom)
        logo.startAnimation(sideAnimation)
        start.startAnimation(bottonAnimation)


        start.setOnClickListener {
            startActivity(Intent(this@SplashActivity, MainActivity2::class.java))


//this is used to get notification on defined time//

//            val calendar: Calendar = Calendar.getInstance()
//            calendar.set(Calendar.HOUR_OF_DAY, 5)
//            calendar.set(Calendar.MINUTE, 3)

// this is used to get notification upon running the app
            val intent = Intent(this@SplashActivity, ReminderBroadcast::class.java)
            val pendingIntent =
                PendingIntent.getBroadcast(this@SplashActivity, 0, intent, 0)
            val alarmManager =
                getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val timeAtButtonCLick = System.currentTimeMillis()
            val tenSecondsInMillis = 1000 * 10.toLong()
            alarmManager[AlarmManager.RTC_WAKEUP, timeAtButtonCLick + tenSecondsInMillis] =
                pendingIntent
            finish()

         //   alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent)


        }
    }


    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val name: CharSequence = "myChannel"
            val description = "Channel for asma ul husna"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel =
                NotificationChannel("notifyme", name, importance)
            channel.setDescription(description)


            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }

    }
}