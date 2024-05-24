package com.example.airline.PassengerData

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PassengerViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Passenger>>
    val repository: PassengerRepository
    init {
        val PassengerDao = PassengerDB.getDatabase(application).PassengerDao()
        repository = PassengerRepository(PassengerDao)
        readAllData = repository.readAllData
    }
    fun addPassenger(passenger: Passenger) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPassenger(passenger)
        }
    }
    fun updatePassenger(passenger: Passenger) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.updatePassenger(passenger)
        }
    }

    fun deletePassenger(passenger: Passenger) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.deletePassenger(passenger)
        }
    }
}