package com.example.airline.PassengerData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passengers")
data class Passenger (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int,
    val place_on_board: Int,

)