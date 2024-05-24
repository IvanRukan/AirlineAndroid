package com.example.airline.PassengerData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Passenger::class], version = 1, exportSchema = false)
abstract class PassengerDB: RoomDatabase(){

    abstract fun PassengerDao(): PassengerDao

    companion object {
        @Volatile
        private var INSTANCE: PassengerDB? = null

        fun getDatabase(context: Context): PassengerDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PassengerDB::class.java,
                    "PCDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}