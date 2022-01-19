package com.example.listofflights.viewmodels

import androidx.lifecycle.ViewModel
import com.example.listofflights.model.entity.Flight
import com.example.listofflights.model.repositories.FlightRepository

class FlightViewModel(private val repository: FlightRepository) : ViewModel() {

    var flight: Flight = Flight()

    fun getFlights() = repository.getFlights()
}