package com.example.listofflights.model

import com.example.listofflights.model.entity.Flight
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("/ott/search/")
    fun getFlights(): Call<MutableList<Flight>>
}