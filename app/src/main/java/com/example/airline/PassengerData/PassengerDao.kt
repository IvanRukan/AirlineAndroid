package com.example.airline.PassengerData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PassengerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPassenger(passenger: Passenger)

    @Query("SELECT * FROM passengers")
    fun readAllData(): LiveData<List<Passenger>>

    @Update
    suspend fun updatePassenger(passenger: Passenger)

    @Delete
    suspend fun deletePassenger(passenger: Passenger)

}