package com.example.airline.PassengerData

import androidx.lifecycle.LiveData

class PassengerRepository(private val PassengerDao: PassengerDao) {

    val readAllData: LiveData<List<Passenger>> = PassengerDao.readAllData()
    suspend fun addPassenger (passenger: Passenger) {
        PassengerDao.addPassenger(passenger)
    }

    suspend fun updatePassenger(passenger: Passenger) {
        PassengerDao.updatePassenger(passenger)
    }
    suspend fun deletePassenger(passenger: Passenger) {
        PassengerDao.deletePassenger(passenger)
    }
}