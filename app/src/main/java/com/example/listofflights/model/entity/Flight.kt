package com.example.listofflights.model.entity

data class Flight(
    var currency: String? = null,
    var prices: List<Price> = mutableListOf(),
    var trips: List<Trip> = mutableListOf()
) {

    fun getSCurrency(): String = if (currency == "RUB") "руб." else ""


}