package com.example.homeassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BootViewModel(
    private val bootRepository: BootRepository
) {

    val lastBootData = flow {
        emit(bootRepository.getLastTwoEventsDescending())
    }
        .map { lastTwoEvents ->
            if (lastTwoEvents.isEmpty()) {
                "No boots detected"
            } else if (lastTwoEvents.size == 1) {
                "The boot was detected with the timestamp = ${lastTwoEvents.first().timestamp}"
            } else {
                val difference = lastTwoEvents.first().timestamp - lastTwoEvents[1].timestamp
                "Last boots time delta = $difference"
            }
        }
}

class MainActivity : AppCompatActivity() {
    lateinit var bootRepository: BootRepository

    val tvBootData by lazy {
        findViewById<TextView>(R.id.tvBootData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = BootDatabase.buildDatabase(this)
        val dataSource = BootLocalDataSourceImpl(database.bootEventDao())
        bootRepository = BootRepositoryImpl(dataSource)
        val bootViewModel = BootViewModel(bootRepository)

        GlobalScope.launch {
            bootViewModel.lastBootData.collect {
                tvBootData.text = it
            }
            NotificationUtils.showNotification(this@MainActivity, "test")
        }
//        println("DEBUGGING 1")
    }
}