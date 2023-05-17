package com.example.homeassignment

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boot_event")
class BootEventEntity(
    @PrimaryKey val timestamp: Long,
)