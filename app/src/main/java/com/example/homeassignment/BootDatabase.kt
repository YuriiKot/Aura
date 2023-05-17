package com.example.homeassignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BootEventEntity::class], version = 1)
abstract class BootDatabase : RoomDatabase() {
    abstract fun bootEventDao(): BootEventDao

    companion object {
        fun buildDatabase(context: Context): BootDatabase {
            return Room.databaseBuilder(
                context,
                BootDatabase::class.java, "boot-database"
            ).build()
        }
    }
}