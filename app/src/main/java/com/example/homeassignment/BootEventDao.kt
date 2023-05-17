package com.example.homeassignment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BootEventDao {
    @Query("SELECT * FROM boot_event")
    fun getBootEvent(): List<BootEventEntity>

    @Query("SELECT * FROM boot_event ORDER BY timestamp DESC LIMIT 2")
    fun getLastTwoEntriesDescending(): List<BootEventEntity>

    @Insert
    fun addBootEvent(bootEvent: BootEventEntity)
}
