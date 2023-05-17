package com.example.homeassignment

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat


object NotificationUtils {
    fun showNotification(context: Context, message: String) {
        val builder: NotificationCompat.Builder =
            NotificationCompat.Builder(context, "your_channel_id")
                .setSmallIcon(R.drawable.sym_def_app_icon)
                .setContentTitle("Boot message")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, builder.build())
    }

    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Main"
            val descriptionText = "Boot events"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel("1", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}