package com.example.homeassignment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BootCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            val database = BootDatabase.buildDatabase(context)
            val dataSource = BootLocalDataSourceImpl(database.bootEventDao())
            val repository = BootRepositoryImpl(dataSource)
            GlobalScope.launch {
                repository.addBootEvent(BootEvent(System.currentTimeMillis()))
            }
            println("DEBUGGING boot received")
        }
    }
}
