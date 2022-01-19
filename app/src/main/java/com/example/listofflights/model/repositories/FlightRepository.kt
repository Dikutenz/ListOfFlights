package com.example.listofflights.model.repositories

import com.example.listofflights.model.RetrofitServices

class FlightRepository(private val service: RetrofitServices) {


    fun getFlights() = service.getFlights()


}